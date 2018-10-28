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
        System.out.println(principal.getName());
        List<Question> questions = questionMapper.findQuestionByRole(3L);
        model.addAttribute("datas", questions);
        model.addAttribute("cheSubmitDto", new CheckPointSubmitDto());
        return "self-check";
    }

    @PostMapping("/self-check")
    public @ResponseBody String selfCheckPost(@ModelAttribute("cheSubmitDto") CheckPointSubmitDto cheSubmitDto, Principal principal) {
        try {
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
                    int point = ttoUtil.getPoint(che.getSelfPoint());;
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
                } else if("TOPIC".equals(question.getQuestionRole())) {
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

    @GetMapping("/self-data")
    public String selfDataGet(Model model, Principal principal) {
        List<SelfData> selfDatas = selfDataMapper.findSelfDataByUserName(principal.getName());
        model.addAttribute("datas", selfDatas);
        return "self-data";
    }

    @GetMapping("/self-data-detail/{id}")
    public String selfDataDetailGet( @PathVariable("id") Long id, Model model, Principal principal) {
        User user = userMapper.findUserByUserName(principal.getName());
        CheckPointResult checkPointResult = checkPointMapper.findCheResultByIdAndUserId(id, user.getId());
        if (checkPointResult != null) {
            List<SelfDataDetail> selfDataDetails = selfDataMapper.findSelfDataDetailByUserId(user.getId(), checkPointResult.getMonth());
            model.addAttribute("datas", selfDataDetails);
            model.addAttribute("checkPointResult", checkPointResult);
        }
        
        return "self-data-detail";
    }


}
