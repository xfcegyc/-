package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService service;

    @RequestMapping("/findAll.do")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ModelAndView findAll() throws Exception{
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userList = service.findAll();
        mv.addObject("userList", userList);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(Integer id) throws Exception{
        ModelAndView mv = new ModelAndView();
        UserInfo user = service.findById(id);
        mv.addObject("user", user);
        mv.setViewName("user-show");
        return mv;
    }

    @RequestMapping("/save.do")
    @PreAuthorize("authentication.principal.username=='tom'")
    public String save(UserInfo user) throws Exception{
        service.save(user);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id",required = true) Integer userId) throws Exception{
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = service.findById(userId);
        List<Role> roleList = service.findOtherRoles(userId);
        mv.addObject("user",userInfo);
        mv.addObject("roleList",roleList);
        mv.setViewName("user-role-add");
        return mv;
    }

    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId",required = true) Integer userId,@RequestParam(name = "ids",required = true) Integer[] roleIds){
        service.addRoleToUser(userId,roleIds);
        return "redirect:findAll.do";
    }
}
