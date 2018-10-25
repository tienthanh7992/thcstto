package vn.edu.tto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import vn.edu.tto.domain.CheckPointSubmit;
import vn.edu.tto.domain.CheckPointSubmitDto;
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
	public String selfCheckGet(Model model) {
		List<Question> questions = questionMapper.findQuestionByRole(3L);
		model.addAttribute("datas", questions);
		model.addAttribute("cheSubmitDto", new CheckPointSubmitDto());
		return "self-check";
	}

	@PostMapping("/self-check")
	public String selfCheckPost(@ModelAttribute("cheSubmitDto") CheckPointSubmitDto cheSubmitDto) {
		for (CheckPointSubmit che : cheSubmitDto.getCheSubmit()) {
			if (che.getSelfPoint() != null) {
				System.out.println(cheSubmitDto.getCheSubmit().toString());
			}
		}

		return "self-check";
	}
}
