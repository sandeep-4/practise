package com.java.spring.practise.practises.Services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.spring.practise.practises.DAO.UserDao;
import com.java.spring.practise.practises.Model.User;

@Service
public class UserService {

	@Autowired
	UserDao userDao;
	
	//CURD
	public User saveUser(User user) {
		return userDao.save(user);
	}
	
	public List<User> getAllUser(){
		return userDao.findAll();
	}
	 public User findOne(int id) {
		 return userDao.getOne(id);
	 }
	 public Optional<User> findUserById(int id){
		 return userDao.findById(id);
	 }
	 public void deleteUserById(int id) {
		 userDao.deleteById(id);
	 }
	 public User findUserByUsernameAndPassword(String username, String password) {
		 return userDao.findUserByUsernameAndPassword(username, password);
	 }

//		@Bean 
//		public PasswordEncoder passwordEncoder() {
//			return new BCryptPasswordEncrypter();
//		}


}

