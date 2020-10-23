package com.itheima.ssm.service;

import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;

import java.util.List;

public interface IRoleService {
    List<Role> findAll() throws Exception;

    void save(Role role) throws Exception;

    Role findById(Integer roleId) throws Exception;

    List<Permission> findOtherPermissions(Integer roleId) throws Exception;
}
