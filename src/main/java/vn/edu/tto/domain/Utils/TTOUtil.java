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

	public int getPoint(String point) {
		try {
			return Integer.parseInt(point);
		} catch (Exception e) {
			return -1;
		}
	}

	public String getResultType(int point) {
		if (90 >= point && point <= 100) {
			return "A";
		} else if (70 >= point && point < 90) {
			return "B";
		} else if (50 >= point && point < 70) {
			return "C";
		} else {
			return "D";
		}
	}

	public int checkReadyMonth() {
		int currentMonth = DateUtil.getCurrentMonth();
		CheckPointResult checkPointResult = checkPointMapper.findLastCheResult();
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
}
