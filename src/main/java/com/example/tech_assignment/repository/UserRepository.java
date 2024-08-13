package com.example.tech_assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.tech_assignment.model.User;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByName(String name);
    User findByEmail(String email);
    User findByMobile(String mobile);

}
