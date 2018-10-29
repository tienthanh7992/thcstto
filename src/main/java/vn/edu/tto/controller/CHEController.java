package vn.edu.tto.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import vn.edu.tto.domain.CheckPointResult;
import vn.edu.tto.domain.CheckPointSubmitDto;
import vn.edu.tto.domain.User;
import vn.edu.tto.domain.UserInfo;
import vn.edu.tto.domain.Working;
import vn.edu.tto.domain.WorkingDetail;
import vn.edu.tto.domain.Utils.TTOUtil;
import vn.edu.tto.domain.constant.TTOConstant;
import vn.edu.tto.domain.constant.TTOConstant.RoleType;
import vn.edu.tto.mapper.CHEViewMapper;
import vn.edu.tto.mapper.CheckPointMapper;
import vn.edu.tto.mapper.QuestionMapper;
import vn.edu.tto.mapper.UserMapper;
import vn.edu.tto.mapper.WorkMapper;

@Controller
public class CHEController {
	
	@Autowired
	UserMapper userMapper;

	@Autowired
	WorkMapper workMapper;
	
	@Autowired
	CHEViewMapper cheViewMapper;

	@Autowired
	CheckPointMapper checkPointMapper;

	@Autowired
	QuestionMapper questionMapper;

	@Autowired
	TTOUtil ttoUtil;

	@GetMapping("che-list/{page}")
	public String getCHEViewList(@PathVariable("page") Integer page, Model model, Principal principal) {
		UserInfo userInfo = userMapper.findUserInfoByUserName(principal.getName());
		List<Working> workings = null;
		if (userInfo != null) {
			switch (userInfo.getRoleCode()) {
			case RoleType.PRINCIPAL:
				workings = cheViewMapper.findWorkForPrincipal(userInfo.getId(), TTOConstant.PAGE_SIZE, (page - 1) * TTOConstant.PAGE_SIZE);
				break;
			case RoleType.VICE_PRINCIPAL:
				workings = cheViewMapper.findWorkForVicePrincipal(userInfo.getId(), TTOConstant.PAGE_SIZE, (page - 1) * TTOConstant.PAGE_SIZE);
				break;
			default:
				Boolean isTeamLeader = userInfo.getIsTeamLeader();
				if (isTeamLeader != null & isTeamLeader) {
					workings = cheViewMapper.findWorkForLeader(userInfo.getId(), userInfo.getRoleCode(),
							userInfo.getTeam(), TTOConstant.PAGE_SIZE, (page - 1) * TTOConstant.PAGE_SIZE);
				}
				break;
			}
		}
		if (workings != null) {
			model.addAttribute("pre", page - 1 < 1 ? 1 : page - 1);
			model.addAttribute("next", workings.isEmpty() ? (page - 1 < 1 ? 1 : page - 1) : workings.size() == TTOConstant.PAGE_SIZE ? page + 1 : page);
			model.addAttribute("datas", workings);
			model.addAttribute("userInfo", userInfo);
			model.addAttribute("isDetail", false);
			model.addAttribute("isSelfCheckReady", ttoUtil.checkReadyMonth(userInfo.getId()) != 0);
			return "che-list";
		}
		return "error";
	}

	@GetMapping("/che-detail/{id}")
	public String selfDataDetailGet(@PathVariable("id") Long id, Model model, Principal principal) {
		UserInfo userInfoCurr = userMapper.findUserInfoByUserName(principal.getName());
		CheckPointResult checkPointResult = checkPointMapper.findCheResultById(id);
		int checkPermissionAndTypeResult = ttoUtil.checkPermissionAndTypePrincipalApproved(userInfoCurr, checkPointResult);
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
		model.addAttribute("userInfo", userInfoCurr);
		model.addAttribute("isDetail", true);
		User principalInfo = userMapper.findUserByUserId(checkPointResult.getPrincipalId());
		model.addAttribute("principalInfo", principalInfo);
		model.addAttribute("isSelfCheckReady", ttoUtil.checkReadyMonth(userInfoCurr.getId()) != 0);
		if (checkPermissionAndTypeResult == 3) {
			User leaderInfo = userMapper.findUserByUserId(checkPointResult.getLeaderId());
			model.addAttribute("leaderInfo", leaderInfo);
			return "che-view-3";
		}
		return "che-view-2";

	}
}
