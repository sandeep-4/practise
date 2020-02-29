package com.java.spring.practise.practises.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.spring.practise.practises.Model.User;
import com.java.spring.practise.practises.Services.UserService;

@RestController
public class UserController {

	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/user" ,method=RequestMethod.GET )
	public List<User> allUSers(User user) {
		return userService.getAllUser();
	}
	
	@PostMapping("/user")
	public User insertIntoUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(name="id") int id,@RequestBody User user){
		
		User updatedUser=userService.findOne(id);
		
		if(updatedUser==null) {
			return ResponseEntity.notFound().build();

		}
		
		updatedUser.setName(user.getName());
		updatedUser.setUsername(user.getUsername());
		updatedUser.setPassword(user.getPassword());
		
		userService.saveUser(updatedUser);
		return ResponseEntity.ok().body(updatedUser);
	}
	
	@GetMapping("/user/{id}")
	public Optional<User> getOneUser(@PathVariable(name="id") int id){
		return userService.findUserById(id);
	}
	
	@ResponseBody
	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable int id) {
		userService.deleteUserById(id);
		return "user deleted sucessfully";
	}
	
	@RequestMapping("/user/{username}/{password}")
	public User loginUSer(@PathVariable(name="username")String username,
			@PathVariable(name="password")String password) {
		return userService.findUserByUsernameAndPassword(username, password);
	}

}
