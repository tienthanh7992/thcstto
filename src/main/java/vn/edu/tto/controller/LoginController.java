package vn.edu.tto.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.edu.tto.domain.User;
import vn.edu.tto.domain.UserInfo;
import vn.edu.tto.domain.Utils.DateUtil;
import vn.edu.tto.domain.Utils.TTOUtil;
import vn.edu.tto.mapper.UserMapper;

@Controller
public class LoginController {

	@Autowired
	UserMapper userMapper;

	@Autowired
	TTOUtil ttoUtil;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}

	@GetMapping("/home")
	public String home(Model model, Principal principal) {
		UserInfo userInfo = userMapper.findUserInfoByUserName(principal.getName());
		if (ttoUtil.checkReadyMonth(userInfo.getId()) != 0) {
			if (DateUtil.getCurrentDay() > 20) {
				return "redirect:self-check";
			}
		}
		model.addAttribute("userInfo", userInfo);
		model.addAttribute("isDetail", false);
		return "redirect:" + ttoUtil.getHomePage(userInfo);
	}

	@GetMapping("/error")
	public String error(Model model, Principal principal) {
		UserInfo userInfo = userMapper.findUserInfoByUserName(principal.getName());
		model.addAttribute("userInfo", userInfo);
		model.addAttribute("isDetail", false);
		return "error";
	}

}
