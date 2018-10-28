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
import org.springframework.web.bind.annotation.ResponseBody;

import vn.edu.tto.domain.CheckPointResult;
import vn.edu.tto.domain.CheckPointSubmit;
import vn.edu.tto.domain.CheckPointSubmitDto;
import vn.edu.tto.domain.Question;
import vn.edu.tto.domain.SelfData;
import vn.edu.tto.domain.SelfDataDetail;
import vn.edu.tto.domain.User;
import vn.edu.tto.domain.UserInfo;
import vn.edu.tto.domain.Utils.DateUtil;
import vn.edu.tto.domain.Utils.TTOUtil;
import vn.edu.tto.domain.constant.TTOConstant;
import vn.edu.tto.mapper.CheckPointMapper;
import vn.edu.tto.mapper.QuestionMapper;
import vn.edu.tto.mapper.SelfDataMapper;
import vn.edu.tto.mapper.UserMapper;

@Controller
public class SelfCheckPointController {

	@Autowired
	UserMapper userMapper;

	@Autowired
	QuestionMapper questionMapper;

	@Autowired
	CheckPointMapper checkPointMapper;

	@Autowired
	SelfDataMapper selfDataMapper;

	@Autowired
	TTOUtil ttoUtil;

	@GetMapping("/self-check")
	public String selfCheckGet(Model model, Principal principal) {
		UserInfo userInfo = userMapper.findUserInfoByUserName(principal.getName());
		int month = ttoUtil.checkReadyMonth(userInfo.getId());
		if (month == 0) {
			return "redirect:self-data/1";
		}
		List<Question> questions = questionMapper.findQuestionByRole(3L);
		if (questions.isEmpty()) {
			return "redirect:self-data/1";
		}
		model.addAttribute("datas", questions);
		model.addAttribute("isDetail", false);
		model.addAttribute("month", month);
		model.addAttribute("userInfo", userInfo);
		model.addAttribute("cheSubmitDto", new CheckPointSubmitDto());
		return "self-check";
	}

	@PostMapping("/self-check")
	public @ResponseBody String selfCheckPost(@ModelAttribute("cheSubmitDto") CheckPointSubmitDto cheSubmitDto,
			Principal principal) {
		try {
			User user = userMapper.findUserByUserName(principal.getName());
			int month = ttoUtil.checkReadyMonth(user.getId());
			if (month == 0) {
				return "Bạn đã làm phiếu đánh giá tháng này rồi.";
			}
			int year = DateUtil.getCurrentYear();
			List<CheckPointSubmit> checkPointSubmits = new ArrayList<>();
			Map<Long, Question> questionMap = questionMapper.findQuestionByRoleMap(3L);
			CheckPointSubmit checkPointSubmit;
			CheckPointResult checkPointResult = new CheckPointResult();
			double totalPoint = 0;
			String topic = "";
			for (CheckPointSubmit che : cheSubmitDto.getCheSubmit()) {
				Question question = questionMap.get(che.getQuestionId());
				if ("QUESTION".equals(question.getQuestionRole())) {
					checkPointSubmit = new CheckPointSubmit();
					Double point = ttoUtil.getPoint(che.getSelfPoint());
					if (Double.compare(point, -1) == 0) {
						return "Bạn chưa nhập dữ liệu ở câu hỏi ở mục " + topic + "\n" + question.getContent();
					}
					if (question.getIsIncrease()) {
						totalPoint += ttoUtil.getPoint(che.getSelfPoint());
					}
					checkPointSubmit.setUserId(user.getId());
					checkPointSubmit.setQuestionId(che.getQuestionId());
					checkPointSubmit.setIssue(che.getIssue());
					checkPointSubmit.setSelfPoint(String.valueOf(ttoUtil.getPoint(che.getSelfPoint())));
					checkPointSubmit.setMonth(month);
					checkPointSubmit.setYear(year);
					checkPointSubmits.add(checkPointSubmit);
				} else if ("TOPIC".equals(question.getQuestionRole())) {
					topic = question.getIndexStr();
				} else if ("DECREASE".equals(question.getQuestionRole())) {
					checkPointSubmit = new CheckPointSubmit();
					checkPointSubmit.setUserId(user.getId());
					checkPointSubmit.setQuestionId(che.getQuestionId());
					checkPointSubmit.setIssue(che.getIssue());
					checkPointSubmit.setMonth(month);
					checkPointSubmit.setYear(year);
					checkPointSubmits.add(checkPointSubmit);
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
			checkPointResult.setMonth(month);
			checkPointResult.setYear(year);
			checkPointMapper.insertCheckPointResult(checkPointResult);
			return "SUCCESS";
		} catch (Exception e) {
			e.printStackTrace();
			return "Có một lỗi hệ thống, xin lỗi vì sự bất tiện này!";
		}
	}

	@GetMapping("/self-data/{page}")
	public String selfDataGet(@PathVariable("page") Integer page, Model model, Principal principal) {
		UserInfo userInfo = userMapper.findUserInfoByUserName(principal.getName());
		List<SelfData> selfDatas = selfDataMapper.findSelfDataByUserName(principal.getName(), TTOConstant.PAGE_SIZE, (page - 1) * TTOConstant.PAGE_SIZE);
		model.addAttribute("datas", selfDatas);
		model.addAttribute("pre", page - 1 < 1 ? 1 : page - 1);
		model.addAttribute("next", selfDatas.isEmpty() ? (page - 1 < 1 ? 1 : page -1) : selfDatas.size() == TTOConstant.PAGE_SIZE ? page + 1 : page);
		model.addAttribute("userInfo", userInfo);
		model.addAttribute("isDetail", false);
		model.addAttribute("isSelfCheckReady", ttoUtil.checkReadyMonth(userInfo.getId()) != 0);
		return "self-data";
	}

	@GetMapping("/self-data-detail/{id}")
	public String selfDataDetailGet(@PathVariable("id") Long id, Model model, Principal principal) {
		UserInfo userInfo = userMapper.findUserInfoByUserName(principal.getName());
		CheckPointResult checkPointResult = checkPointMapper.findCheResultByIdAndUserId(id, userInfo.getId());
		if (checkPointResult != null) {
			List<SelfDataDetail> selfDataDetails = selfDataMapper.findSelfDataDetailByUserId(userInfo.getId(),
					checkPointResult.getMonth());
			model.addAttribute("datas", selfDataDetails);
			model.addAttribute("userInfo", userInfo);
			model.addAttribute("isDetail", true);
			model.addAttribute("isSelfCheckReady", ttoUtil.checkReadyMonth(userInfo.getId()) != 0);
			model.addAttribute("checkPointResult", checkPointResult);
			return "self-data-detail";
		}
		return "error";
		
	}

}
