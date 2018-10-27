package vn.edu.tto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.edu.tto.domain.User;
import vn.edu.tto.mapper.UserMapper;

@Controller
public class LoginController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

//    @PostMapping("/login")
//    public String login(@ModelAttribute User user, HttpServletRequest request) {
//        User userLogin = userMapper.findUserByUserName(user.getUserName());
//        if (userLogin != null) {
//            HttpSession session = request.getSession();
//            session.setAttribute("tto-auth", user.getId());
//            System.out.println(userLogin.toString());
//            return "redirect:/working-list/1";
//        }
//        return "error";
//    }

    @GetMapping("/home")
    public String home(Model model) {
        return "index";
    }
    
    @GetMapping("/error")
    public String error(Model model) {
        return "error";
    }
    
}
