package com.example.pp_3_1_3_bootstrap.controller;

import com.example.pp_3_1_3_bootstrap.model.User;
import com.example.pp_3_1_3_bootstrap.service.RoleService;
import com.example.pp_3_1_3_bootstrap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;





@Controller
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;
//    private final User user;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/admin")
    public String adminPage(@AuthenticationPrincipal UserDetails userDetails,Model model){

        User user = userService.getUserByUsername(userDetails.getUsername());
        model.addAttribute("user", user);

        User admin = userService.getUserByUsername(userDetails.getUsername());
        model.addAttribute("admin", admin);


        model.addAttribute("users", userService.getAllUser());
        model.addAttribute("roleList",roleService.getAllRoles());

        return "adminPage";
    }



    @GetMapping("/admin/add")
    public String addUser(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleService.getAllRoles());
        return "redirect:/admin";
    }
//
//    @PostMapping("/admin/add")
//    public String saveUser(@ModelAttribute  User user, BindingResult result,  // @Valid
//                           @RequestParam(value = "checked", required = false) Long[] checked){
//        if(result.hasErrors()){
//            return "addPage";
//        }
//        if (checked == null) {
//            user.setOneRole(roleService.getRoleByRole("ROLE_USER"));
//            userService.addUser(user);
//        } else {
//            for (Long aLong : checked) {
//                if (aLong != null) {
//                    user.setOneRole(roleService.getRoleByID(aLong));
//                    userService.addUser(user);
//                }
//            }
//        }
//        return "redirect:/admin";
//    }
//
//    @GetMapping("/admin/edit/{id}")
//    public String editUser(@PathVariable("id") Long id, Model model) {
//        User user = userService.getUserById(id);
//        model.addAttribute("user", user);
//        model.addAttribute("roles", roleService.getAllRoles());
//        return "editPage";
//    }
//
//    @PostMapping("/admin/edit/{id}")
//    public String saveEditUser(@PathVariable("id") Long id,  User user, BindingResult result, //@Valid
//                               @RequestParam(value = "checked", required = false ) Long[] checked){
//        if (result.hasErrors()) {
//            user.setId(id);
//            return "editPage";
//        }
//        if (checked == null) {
//            user.setOneRole(roleService.getRoleByRole("ROLE_USER"));
//            userService.updateUser(user);
//        } else {
//            for (Long aLong : checked) {
//                if (aLong != null) {
//                    user.setOneRole(roleService.getRoleByID(aLong));
//                    userService.updateUser(user);
//                }
//            }
//        }
//        return "redirect:/admin";
//    }
//
//    @GetMapping("/admin/delete/{id}")
//    public String deleteUser(@PathVariable("id") Long id) {
//        userService.deleteById(id);
//        return "redirect:/admin";
//    }

}
