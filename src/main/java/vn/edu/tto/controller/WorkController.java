package vn.edu.tto.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import vn.edu.tto.domain.UserInfo;
import vn.edu.tto.domain.Working;
import vn.edu.tto.domain.constant.TTOConstant;
import vn.edu.tto.domain.constant.TTOConstant.RoleType;
import vn.edu.tto.mapper.UserMapper;
import vn.edu.tto.mapper.WorkMapper;

@Controller
public class WorkController {

    @Autowired
    UserMapper userMapper;

    @Autowired
    WorkMapper workMapper;

    @GetMapping("working-list/{page}")
    public String getWorkingList(@PathVariable("page") Integer page, Model model, Principal principal) {
        UserInfo userInfo = userMapper.findUserInfoByUserName(principal.getName());
        List<Working> workings = null;
        if (userInfo != null) {
            switch (userInfo.getRoleCode()) {
            case RoleType.PRINCIPAL:
                    workings = workMapper.findWorkForPrincipal(userInfo.getId(), TTOConstant.PAGE_SIZE, page - 1);
                break;
            case RoleType.VICE_PRINCIPAL:
                workings = workMapper.findWorkForVicePrincipal(userInfo.getId(), TTOConstant.PAGE_SIZE, page - 1);
                break;
            default:
                Boolean isTeamLeader = userInfo.getIsTeamLeader();
                if (isTeamLeader!= null & isTeamLeader) {
                    workings = workMapper.findWorkForLeader(userInfo.getId(), userInfo.getRoleCode(), userInfo.getTeam(), TTOConstant.PAGE_SIZE, page - 1);
                }
                break;
            }
        }
        if (workings != null) {
            model.addAttribute("datas", workings);
            model.addAttribute("userInfo", userInfo);
            return "working-list";
        }
        return "error";
    }
}
