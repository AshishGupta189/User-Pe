package com.vcriate.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vcriate.Entity.User;
import com.vcriate.Entity.UserSession;

@Repository
public interface UserSessionDao extends JpaRepository<UserSession, Integer>{
	public UserSession findBySessionId(String id);
}