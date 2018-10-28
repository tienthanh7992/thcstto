package vn.edu.tto.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import vn.edu.tto.domain.CheckPointResult;
import vn.edu.tto.domain.CheckPointSubmit;
import vn.edu.tto.domain.CheckPointSubmitDto;
import vn.edu.tto.domain.Question;
import vn.edu.tto.domain.Utils.DateUtil;
import vn.edu.tto.domain.constant.TTOConstant;
import vn.edu.tto.mapper.CheckPointMapper;
import vn.edu.tto.mapper.QuestionMapper;
import vn.edu.tto.mapper.UserMapper;

@Controller
public class LeaderCheckPointController {

    @Autowired
    UserMapper userMapper;

    @Autowired
    QuestionMapper questionMapper;

    @Autowired
    CheckPointMapper checkPointMapper;

    @GetMapping("/leader-check")
    public String selfCheckGet(Model model) {
        List<Question> questions = questionMapper.findQuestionByRole(3L);
        model.addAttribute("datas", questions);
        model.addAttribute("cheSubmitDto", new CheckPointSubmitDto());
        return "leader-check";
    }

    @PostMapping("/leader-check")
    public String selfCheckPost(@ModelAttribute("cheSubmitDto") CheckPointSubmitDto cheSubmitDto) {
        List<CheckPointSubmit> checkPointSubmits = new ArrayList<>();
        Map<Long, Question> questionMap = questionMapper.findQuestionByRoleMap(3L);
        CheckPointSubmit checkPointSubmit;
        CheckPointResult checkPointResult = new CheckPointResult();
        int totalPoint = 0;
        for (CheckPointSubmit che : cheSubmitDto.getCheSubmit()) {
            Question question = questionMap.get(che.getQuestionId());
            if ("QUESTION".equals(question.getQuestionRole())) {
                checkPointSubmit = new CheckPointSubmit();
                if (question.getIsIncrease()) {
                    totalPoint += getPoint(che.getSelfPoint());
                } else {
                    totalPoint += getPoint(che.getSelfPoint());
                }
                checkPointSubmit.setUserId(getUserIdFromSession());
                checkPointSubmit.setQuestionId(che.getQuestionId());
                checkPointSubmit.setIssue(che.getIssue());
                checkPointSubmit.setSelfPoint(String.valueOf(getPoint(che.getSelfPoint())));
                checkPointSubmit.setMonth(10);
                checkPointSubmits.add(checkPointSubmit);
            }

        }
        try {
            checkPointMapper.insertSelfCheckPointList(checkPointSubmits);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        checkPointResult.setUserId(getUserIdFromSession());
        checkPointResult.setLeaderPoint(totalPoint);
        checkPointResult.setResultType(getResultType(totalPoint));
        checkPointResult.setStatus(TTOConstant.CHEStatus.PENDING);
        checkPointResult.setMonth(10);
        checkPointMapper.insertCheckPointResult(checkPointResult);
        System.out.println();
        return "self-check";
    }

    private int getPoint(String point) {
        try {
            return Integer.parseInt(point);
        } catch (Exception e) {
            return 0;
        }
    }

    private Long getUserIdFromSession() {
        return 1L;
    }

    private String getResultType(int point) {
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
    
}
