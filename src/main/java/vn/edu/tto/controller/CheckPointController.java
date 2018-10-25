package vn.edu.tto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import vn.edu.tto.domain.Question;
import vn.edu.tto.mapper.QuestionMapper;
import vn.edu.tto.mapper.UserMapper;

@Controller
public class CheckPointController {

    @Autowired
    UserMapper userMapper;
    
    @Autowired
    QuestionMapper questionMapper;
    
    @GetMapping("/self-check")
    public String index(Model model) {
        List<Question> questions = questionMapper.findQuestionByRole(3L);
        model.addAttribute("datas", questions);
        return "self-check";
    }
}
