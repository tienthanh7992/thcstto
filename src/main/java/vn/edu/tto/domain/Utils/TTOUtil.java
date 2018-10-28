package vn.edu.tto.domain.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vn.edu.tto.domain.CheckPointResult;
import vn.edu.tto.domain.UserInfo;
import vn.edu.tto.domain.constant.TTOConstant.CHEStatus;
import vn.edu.tto.domain.constant.TTOConstant.RoleType;
import vn.edu.tto.mapper.CheckPointMapper;

@Component
public class TTOUtil {

	@Autowired
	CheckPointMapper checkPointMapper;

	public Double getPoint(String point) {
		try {
			return Double.parseDouble(point);
		} catch (Exception e) {
			return -1.0;
		}
	}

	public String getResultType(double point) {
		if (Double.compare(point, 89) > 0 && Double.compare(point, 101) < 1) {
			return "A";
		} else if (Double.compare(point, 69) > 0 && Double.compare(point, 90) < 1) {
			return "B";
		} else if (Double.compare(point, 49) > 0 && Double.compare(point, 70) < 1) {
			return "C";
		} else {
			return "D";
		}
	}

	public int checkReadyMonth(Long userId) {
		int currentMonth = DateUtil.getCurrentMonth();
		CheckPointResult checkPointResult = checkPointMapper.findLastCheResult(userId);
		if (checkPointResult == null) {
			return currentMonth;
		}
		int month = checkPointResult.getMonth();
		if (month == currentMonth) {
			return 0;
		}
		if (month < currentMonth) {
			return month++;
		}
		return 0;
	}

	public boolean checkPermission(UserInfo userInfo, CheckPointResult che) {
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

	public int checkPermissionAndType(UserInfo userInfo, CheckPointResult che) {
		String cheStatus = che.getStatus();
		String roleCodeCurrUser = userInfo.getRoleCode();
		String roleCodeObject = che.getRoleCode();
		if (userInfo.getId() == che.getUserId() || CHEStatus.PRINCIPAL_APPROVED.equals(cheStatus)) {
			return -1;
		}
		switch (roleCodeCurrUser) {
		case RoleType.PRINCIPAL:
			if (RoleType.VICE_PRINCIPAL.equals(roleCodeObject)
					|| (RoleType.TEACHER.equals(roleCodeObject) && che.getIsTeamLeader())
					|| (RoleType.EMPLOYEE.equals(roleCodeObject) && che.getIsTeamLeader())) {
				return 1;
			}

			if ((RoleType.TEACHER.equals(roleCodeObject) && CHEStatus.LEADER_APPROVED.equals(cheStatus))
					|| (RoleType.EMPLOYEE.equals(roleCodeObject) && CHEStatus.LEADER_APPROVED.equals(cheStatus))) {
				return 3;
			}
			break;
		case RoleType.VICE_PRINCIPAL:
			if ((RoleType.TEACHER.equals(roleCodeObject) && che.getIsTeamLeader())
					|| (RoleType.EMPLOYEE.equals(roleCodeObject) && che.getIsTeamLeader())) {
				return 1;
			}

			if ((RoleType.TEACHER.equals(roleCodeObject) && CHEStatus.LEADER_APPROVED.equals(cheStatus))
					|| (RoleType.EMPLOYEE.equals(roleCodeObject) && CHEStatus.LEADER_APPROVED.equals(cheStatus))) {
				return 3;
			}
			break;
		default:
			if (CHEStatus.PENDING.equals(cheStatus) && userInfo.getIsTeamLeader()
					&& userInfo.getTeam().equals(che.getTeam()) && !che.getIsTeamLeader()) {
				return 2;
			}
			break;
		}
		return -1;
	}

	public int checkPermissionAndTypePrincipalApproved(UserInfo userInfo, CheckPointResult che) {
		String cheStatus = che.getStatus();
		String roleCodeCurrUser = userInfo.getRoleCode();
		String roleCodeObject = che.getRoleCode();
		if (!CHEStatus.PRINCIPAL_APPROVED.equals(cheStatus)) {
			return -1;
		}
		switch (roleCodeCurrUser) {
		case RoleType.PRINCIPAL:
			if (RoleType.VICE_PRINCIPAL.equals(roleCodeObject)
					|| (RoleType.TEACHER.equals(roleCodeObject) && che.getIsTeamLeader())
					|| (RoleType.EMPLOYEE.equals(roleCodeObject) && che.getIsTeamLeader())) {
				return 1;
			}

			if (RoleType.TEACHER.equals(roleCodeObject) || RoleType.EMPLOYEE.equals(roleCodeObject)) {
				return 3;
			}
			break;
		case RoleType.VICE_PRINCIPAL:
			if ((RoleType.TEACHER.equals(roleCodeObject) && che.getIsTeamLeader())
					|| (RoleType.EMPLOYEE.equals(roleCodeObject) && che.getIsTeamLeader())) {
				return 1;
			}

			if (RoleType.TEACHER.equals(roleCodeObject) || RoleType.EMPLOYEE.equals(roleCodeObject)) {
				return 3;
			}
			break;
		default:
			if (userInfo.getIsTeamLeader() && userInfo.getTeam().equals(che.getTeam()) && !che.getIsTeamLeader()) {
				return 2;
			}
			break;
		}
		return -1;
	}

	public String getHomePage(UserInfo userInfo) {
		switch (userInfo.getRoleCode()) {
		case RoleType.PRINCIPAL:
			return "working-list/1";
		case RoleType.VICE_PRINCIPAL:
			return "working-list/1";
		default:
			if (userInfo.getIsTeamLeader()) {
				return "working-list/1";
			}
			return "self-data/1";
		}
	}
}
