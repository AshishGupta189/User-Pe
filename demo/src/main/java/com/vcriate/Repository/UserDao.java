package com.vcriate.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vcriate.Entity.User;

@Repository
public interface UserDao extends JpaRepository<User, String>{
	public User findByMobile(String phone);
}
