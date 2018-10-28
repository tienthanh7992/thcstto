package vn.edu.tto.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.edu.tto.domain.CheckPointResult;
import vn.edu.tto.domain.CheckPointSubmit;
import vn.edu.tto.domain.CheckPointSubmitDto;
import vn.edu.tto.domain.Question;
import vn.edu.tto.domain.UserInfo;
import vn.edu.tto.domain.Working;
import vn.edu.tto.domain.WorkingDetail;
import vn.edu.tto.domain.Utils.TTOUtil;
import vn.edu.tto.domain.constant.TTOConstant;
import vn.edu.tto.domain.constant.TTOConstant.RoleType;
import vn.edu.tto.mapper.CheckPointMapper;
import vn.edu.tto.mapper.QuestionMapper;
import vn.edu.tto.mapper.UserMapper;
import vn.edu.tto.mapper.WorkMapper;

@Controller
public class WorkController {

	@Autowired
	UserMapper userMapper;

	@Autowired
	WorkMapper workMapper;

	@Autowired
	CheckPointMapper checkPointMapper;

	@Autowired
	QuestionMapper questionMapper;

	@Autowired
	TTOUtil ttoUtil;

	@GetMapping("working-list/{page}")
	public String getWorkingList(@PathVariable("page") Integer page, Model model, Principal principal) {
		UserInfo userInfo = userMapper.findUserInfoByUserName(principal.getName());
		List<Working> workings = null;
		if (userInfo != null) {
			switch (userInfo.getRoleCode()) {
			case RoleType.PRINCIPAL:
				workings = workMapper.findWorkForPrincipal(userInfo.getId(), TTOConstant.PAGE_SIZE, page - 1);
				break;
			case RoleType.VICE_PRINCIPAL:
				workings = workMapper.findWorkForVicePrincipal(userInfo.getId(), TTOConstant.PAGE_SIZE, page - 1);
				break;
			default:
				Boolean isTeamLeader = userInfo.getIsTeamLeader();
				if (isTeamLeader != null & isTeamLeader) {
					workings = workMapper.findWorkForLeader(userInfo.getId(), userInfo.getRoleCode(),
							userInfo.getTeam(), TTOConstant.PAGE_SIZE, page - 1);
				}
				break;
			}
		}
		if (workings != null) {
			model.addAttribute("datas", workings);
			model.addAttribute("userInfo", userInfo);
			return "working-list";
		}
		return "error";
	}

	@GetMapping("/working-detail/{id}")
	public String selfDataDetailGet(@PathVariable("id") Long id, Model model, Principal principal) {
		UserInfo userInfoCurr = userMapper.findUserInfoByUserName(principal.getName());
		CheckPointResult checkPointResult = checkPointMapper.findCheResultById(id);
		int checkPermissionAndTypeResult = ttoUtil.checkPermissionAndType(userInfoCurr, checkPointResult);
		if (userInfoCurr == null || checkPointResult == null || checkPermissionAndTypeResult == -1) {
			model.addAttribute("msg", "Bạn không có quyền truy cập.");
			return "error";
		}
		List<WorkingDetail> workingDetails = workMapper.findWorkingDetailByUserId(checkPointResult.getUserId(),
				checkPointResult.getMonth());
		model.addAttribute("datas", workingDetails);
		model.addAttribute("checkPointResult", checkPointResult);
		model.addAttribute("cheSubmitDto", new CheckPointSubmitDto());
		model.addAttribute("objId", checkPointResult.getUserId());
		model.addAttribute("cherId", checkPointResult.getId());
		if (checkPermissionAndTypeResult == 3) {
			return "approve-3";
		}
		return "approve-2";

	}

	@PostMapping("/approve")
	public @ResponseBody String approvePost(@ModelAttribute("cheSubmitDto") CheckPointSubmitDto cheSubmitDto,
			@RequestParam("objId") Long objId, @RequestParam("cherId") Long cherId, @RequestParam("comment") String comment,  Principal principal) {
		try {

			UserInfo userInfoCurr = userMapper.findUserInfoByUserName(principal.getName());
			CheckPointResult checkPointResultObj = checkPointMapper.findCheResultByIdAndUserIdMoreInfo(cherId, objId);
			int checkPermissionAndTypeResult = ttoUtil.checkPermissionAndType(userInfoCurr, checkPointResultObj);
			if (userInfoCurr == null || checkPointResultObj == null || checkPermissionAndTypeResult == -1) {
				return "Bạn không có quyền truy cập.";
			}
			List<CheckPointSubmit> checkPointSubmits = new ArrayList<>();
			Map<Long, Question> questionMap = questionMapper.findQuestionByRoleMap(3L);
			CheckPointSubmit checkPointSubmit;
			CheckPointResult checkPointResult = new CheckPointResult();
			int totalPoint = 0;
			String topic = "";
			for (CheckPointSubmit ches : cheSubmitDto.getCheSubmit()) {
				Question question = questionMap.get(ches.getQuestionId());
				if ("QUESTION".equals(question.getQuestionRole())) {
					checkPointSubmit = new CheckPointSubmit();
					int point = ttoUtil.getPoint(ches.getPoint());
					if (point == -1) {
						return "Bạn chưa nhập dữ liệu ở câu hỏi ở mục " + topic + "\n" + question.getContent();
					}
					if (question.getIsIncrease()) {
						totalPoint += ttoUtil.getPoint(ches.getSelfPoint());
					} else {
						totalPoint -= ttoUtil.getPoint(ches.getSelfPoint());
					}
					checkPointSubmit.setChesId(ches.getChesId());
					checkPointSubmit.setUserId(checkPointResultObj.getUserId());
					checkPointSubmit.setPoint(String.valueOf(ttoUtil.getPoint(ches.getPoint())));
					checkPointSubmits.add(checkPointSubmit);
				} else if ("TOPIC".equals(question.getQuestionRole())) {
					topic = question.getIndexStr();
				}

			}
			if (checkPermissionAndTypeResult == 2) {
				checkPointMapper.updateCheckPointSubmitLeader(checkPointSubmits);
				checkPointResult.setId(checkPointResultObj.getId());
				checkPointResult.setUserId(checkPointResultObj.getUserId());
				checkPointResult.setLeaderPoint(totalPoint);
				checkPointResult.setLeaderComment(comment);
				checkPointResult.setResultType(ttoUtil.getResultType(totalPoint));
				checkPointResult.setStatus(TTOConstant.CHEStatus.LEADER_APPROVED);
				checkPointResult.setLeaderId(userInfoCurr.getId());
				checkPointMapper.updateCheckPointResultLeader(checkPointResult);
			} else {
				checkPointMapper.updateCheckPointSubmitPrincipal(checkPointSubmits);
				checkPointResult.setId(checkPointResultObj.getId());
				checkPointResult.setUserId(checkPointResultObj.getUserId());
				checkPointResult.setPrincipalPoint(totalPoint);
				checkPointResult.setPrincipalComment(comment);
				checkPointResult.setResultType(ttoUtil.getResultType(totalPoint));
				checkPointResult.setStatus(TTOConstant.CHEStatus.LEADER_APPROVED);
				checkPointResult.setPrincipalId(userInfoCurr.getId());
				checkPointMapper.updateCheckPointResultPrincipal(checkPointResult);
			}
			return "SUCCESS";
		} catch (Exception e) {
			e.printStackTrace();
			return "Có một lỗi hệ thống, xin lỗi vì sự bất tiện này!";
		}
	}
	

}
