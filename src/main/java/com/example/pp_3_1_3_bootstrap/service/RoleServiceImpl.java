package com.example.pp_3_1_3_bootstrap.service;


import com.example.pp_3_1_3_bootstrap.model.Role;
import com.example.pp_3_1_3_bootstrap.repository.RoleRepository;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.Set;


@Transactional
@Service
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Set<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleByID(Long id) {
        return roleRepository.findRoleById(id);
    }

    @Override
    public Role getRoleByRole(String role) {
        return roleRepository.findRoleByRole(role);
    }

    @Override
    public void addRole(Role role) {
        roleRepository.save(role);
    }
}
