package vn.edu.tto.controller;

import java.security.Principal;
import java.sql.SQLException;
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
import vn.edu.tto.domain.User;
import vn.edu.tto.domain.UserInfo;
import vn.edu.tto.domain.Working;
import vn.edu.tto.domain.WorkingDetail;
import vn.edu.tto.domain.Utils.TTOUtil;
import vn.edu.tto.domain.constant.TTOConstant;
import vn.edu.tto.domain.constant.TTOConstant.CHEStatus;
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
		if (userInfoCurr == null || checkPointResult == null || !checkPermission(userInfoCurr, checkPointResult)) {
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
		if (CHEStatus.LEADER_APPROVED.equals(checkPointResult.getStatus())) {
			return "approve-3";
		}
		return "approve-2";

	}

	@PostMapping("/approve")
	public @ResponseBody String approvePost(@ModelAttribute("cheSubmitDto") CheckPointSubmitDto cheSubmitDto,
			@RequestParam("objId") Long objId, @RequestParam("cherId") Long cherId,
			Principal principal) {
		try {
			
			UserInfo userInfoCurr = userMapper.findUserInfoByUserName(principal.getName());
			
			
			User user = userMapper.findUserByUserName(principal.getName());
			List<CheckPointSubmit> checkPointSubmits = new ArrayList<>();
			Map<Long, Question> questionMap = questionMapper.findQuestionByRoleMap(3L);
			CheckPointSubmit checkPointSubmit;
			CheckPointResult checkPointResult = new CheckPointResult();
			int totalPoint = 0;
			String topic = "";
			for (CheckPointSubmit che : cheSubmitDto.getCheSubmit()) {
				Question question = questionMap.get(che.getQuestionId());
				if ("QUESTION".equals(question.getQuestionRole())) {
					checkPointSubmit = new CheckPointSubmit();
					int point = ttoUtil.getPoint(che.getSelfPoint());
					;
					if (point == -1) {
						return "Bạn chưa nhập dữ liệu ở câu hỏi ở mục " + topic + "\n" + question.getContent();
					}
					if (question.getIsIncrease()) {
						totalPoint += ttoUtil.getPoint(che.getSelfPoint());
					} else {
						totalPoint += ttoUtil.getPoint(che.getSelfPoint());
					}
					checkPointSubmit.setUserId(user.getId());
					checkPointSubmit.setQuestionId(che.getQuestionId());
					checkPointSubmit.setIssue(che.getIssue());
					checkPointSubmit.setSelfPoint(String.valueOf(ttoUtil.getPoint(che.getSelfPoint())));
					checkPointSubmit.setMonth(10);
					checkPointSubmits.add(checkPointSubmit);
				} else if ("TOPIC".equals(question.getQuestionRole())) {
					topic = question.getIndexStr();
				}

			}
			try {
				checkPointMapper.insertSelfCheckPointList(checkPointSubmits);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			checkPointResult.setUserId(user.getId());
			checkPointResult.setSelfPoint(totalPoint);
			checkPointResult.setResultType(ttoUtil.getResultType(totalPoint));
			checkPointResult.setStatus(TTOConstant.CHEStatus.PENDING);
			checkPointResult.setMonth(10);
			checkPointMapper.insertCheckPointResult(checkPointResult);
			System.out.println();
			return "SUCCESS";
		} catch (Exception e) {
			e.printStackTrace();
			return "Có một lỗi hệ thống, xin lỗi vì sự bất tiện này!";
		}
	}

	private boolean checkPermission(UserInfo userInfo, CheckPointResult che) {
		String cheStatus = che.getStatus();
		String roleCodeCurrUser = userInfo.getRoleCode();
		String roleCodeObject = che.getRoleCode();
		if (userInfo.getId() == che.getUserId() || CHEStatus.PRINCIPAL_APPROVED.equals(cheStatus)) {
			return false;
		}
		switch (roleCodeCurrUser) {
		case RoleType.PRINCIPAL:
			if (RoleType.VICE_PRINCIPAL.equals(roleCodeObject)
					|| (RoleType.TEACHER.equals(roleCodeObject)
							&& (che.getIsTeamLeader() || CHEStatus.LEADER_APPROVED.equals(cheStatus)))
					|| (RoleType.EMPLOYEE.equals(roleCodeObject)
							&& (che.getIsTeamLeader() || CHEStatus.LEADER_APPROVED.equals(cheStatus)))) {
				return true;
			}
			break;
		case RoleType.VICE_PRINCIPAL:
			if ((RoleType.TEACHER.equals(roleCodeObject)
					&& (che.getIsTeamLeader() || CHEStatus.LEADER_APPROVED.equals(cheStatus)))
					|| (RoleType.EMPLOYEE.equals(roleCodeObject)
							&& (che.getIsTeamLeader() || CHEStatus.LEADER_APPROVED.equals(cheStatus)))) {
				return true;
			}
			break;
		default:
			if (CHEStatus.PENDING.equals(cheStatus) && userInfo.getIsTeamLeader()
					&& userInfo.getTeam().equals(che.getTeam()) && !che.getIsTeamLeader()) {
				return true;
			}
			break;
		}
		return false;
	}
}
