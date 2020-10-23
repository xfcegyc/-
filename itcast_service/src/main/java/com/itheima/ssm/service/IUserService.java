package com.itheima.ssm.service;

import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService{

    List<UserInfo> findAll() throws Exception;

    void save(UserInfo user) throws Exception;

    UserInfo findById(Integer id) throws Exception;

    List<Role> findOtherRoles(Integer userId) throws Exception;

    void addRoleToUser(Integer userId, Integer[] roleIds);
}
