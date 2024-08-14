package com.example.tech_assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.tech_assignment.model.UserInfo;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<UserInfo, Integer> {

    List<UserInfo> findByName(String name);
    UserInfo findByEmail(String email);
    UserInfo findByMobile(String mobile);

}
