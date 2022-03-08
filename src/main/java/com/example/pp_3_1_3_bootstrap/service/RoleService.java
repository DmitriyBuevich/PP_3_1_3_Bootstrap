package com.example.pp_3_1_3_bootstrap.service;


import com.example.pp_3_1_3_bootstrap.model.Role;


import java.util.Set;

public interface RoleService {
    Set<Role> getAllRoles();
    Role getRoleByID(Long id);
    Role getRoleByRole(String role);
    void addRole(Role role);
}

