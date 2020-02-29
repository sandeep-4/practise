package com.java.spring.practise.practises.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.spring.practise.practises.Model.User;

@Repository
public interface UserDao extends JpaRepository<User,Integer>{

	public User findUserByUsernameAndPassword(String username,String password);
	
}
