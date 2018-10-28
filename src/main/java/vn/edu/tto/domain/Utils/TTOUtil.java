package vn.edu.tto.domain.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vn.edu.tto.domain.CheckPointResult;
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
}
