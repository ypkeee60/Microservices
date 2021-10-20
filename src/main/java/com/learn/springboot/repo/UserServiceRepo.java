package com.learn.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.springboot.entity.UserDetails;

public interface UserServiceRepo extends JpaRepository<UserDetails, String>{

}
