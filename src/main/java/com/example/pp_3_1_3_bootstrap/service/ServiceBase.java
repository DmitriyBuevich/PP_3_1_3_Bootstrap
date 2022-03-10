package com.example.pp_3_1_3_bootstrap.service;

import com.example.pp_3_1_3_bootstrap.model.Role;
import com.example.pp_3_1_3_bootstrap.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class ServiceBase {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public ServiceBase(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    private void startDB() {
        User user = new User("user@mail.ru", "Ivan", "Ivanov", 25,"ivan@gmail.com", "user");
//        User admin = new User("admin@mail.ru", "Oleg", "Petrov", 20, "admin@mail.ru", "admin");
        User superAdmin = new User("bigadmin@gmail.com", "Elena", "Sokolova", 30,"bigadmin@gmail.com", "admin");


        Role userRole = new Role("ROLE_USER");
        Role adminRole = new Role("ROLE_ADMIN");

        Set<Role> superAdminRole = new HashSet<Role>();
        superAdminRole.add(adminRole);
        superAdminRole.add(userRole);

        roleService.addRole(userRole);
        roleService.addRole(adminRole);

        user.setOneRole(userRole);
//        admin.setOneRole(adminRole);
        superAdmin.setRoles(superAdminRole);

        userService.addUser(user);
//        userService.addUser(admin);
        userService.addUser(superAdmin);

    }


}


//@PostConstruct
//private void startDB() {
//    User user = new User("user@mail.ru", "Ivan", "Ivanov", 25,"ivan@gmail.com", "user");
//    User admin = new User("admin@mail.ru", "Oleg", "Petrov", 20, "admin@mail.ru", "admin");
//    User superAdmin = new User("digadmin@gmail.com", "BigAdmin", "BigBig", 30,"bigadmin@gmail.com", "superadmin");
//
//
//    Role userRole = new Role("ROLE_USER");
//    Role adminRole = new Role("ROLE_ADMIN");
//
//    Set<Role> superAdminRole = new HashSet<Role>();
//    superAdminRole.add(adminRole);
//    superAdminRole.add(userRole);
//
//    roleService.addRole(userRole);
//    roleService.addRole(adminRole);
//
//    user.setOneRole(userRole);
//    admin.setOneRole(adminRole);
//    superAdmin.setRoles(superAdminRole);
//
//    userService.addUser(user);
//    userService.addUser(admin);
//    userService.addUser(superAdmin);
//
//}