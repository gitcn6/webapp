package com.unicom.busi.controller;

import com.unicom.busi.entity.SysUser;
import com.unicom.busi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService us;

    @RequestMapping("/toIndex")
    public String toUserManager(){
        return "userManager/userManager";
    }

    @RequestMapping("/getUsersByName")
    @ResponseBody
    public List<SysUser> getUserByName(@RequestParam String userName){
        List<SysUser> users = us.getUsersByName(userName);
        return users;
    }
}
