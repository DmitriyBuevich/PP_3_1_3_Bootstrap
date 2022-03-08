package com.example.pp_3_1_3_bootstrap.repository;


import com.example.pp_3_1_3_bootstrap.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll();
    User findUserById(Long id);
    User findUserByUsername(String username);
}
