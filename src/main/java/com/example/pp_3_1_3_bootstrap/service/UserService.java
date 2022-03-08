package com.example.pp_3_1_3_bootstrap.service;




import com.example.pp_3_1_3_bootstrap.model.User;


import java.util.List;

public interface UserService {
    List<User> getAllUser();
    void addUser(User user);
    void deleteById(Long id);
    User getUserById(Long id);
    void updateUser(User user);
    User getUserByUsername(String username);
}

