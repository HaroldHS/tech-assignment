package com.example.tech_assignment.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.tech_assignment.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

    List<User> findByName(String name);
    List<User> findByEmail(String email);
    List<User> findByMobile(String mobile);
    List<User> findByAddress(String address);

}
