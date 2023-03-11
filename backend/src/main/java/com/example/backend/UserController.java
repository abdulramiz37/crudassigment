package com.example.backend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(maxAge = 3600)
public class UserController {
	
	@Autowired
	private IUserRepository repo;
	
	@RequestMapping(value = "users")
	public List<User> findAllUsers() {
		return repo.findAll();
	}
	
	@RequestMapping(value = "/create/user", method = RequestMethod.POST)
	public void create(@RequestBody User user) {
		repo.save(user);
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable long id, @RequestBody User user) {
		User user1 = repo.findById(id).get();
		
		user1.setName(user.getName());
		user1.setEmail(user.getEmail());
		user1.setAddress(user.getAddress());
		
		repo.save(user1);
	}
	
	@RequestMapping(value = "/user/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		repo.deleteById(id);
	}
	
	@RequestMapping(value = "user")
	public User user() {
		User u = new User();
		return u;
	}
}
