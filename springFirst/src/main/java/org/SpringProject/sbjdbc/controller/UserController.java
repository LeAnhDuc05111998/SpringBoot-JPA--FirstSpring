package org.SpringProject.sbjdbc.controller;

import java.util.Map;
import org.SpringProject.sbjdbc.entity.User;
import org.SpringProject.sbjdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService UserService;

	@PostMapping("/")
	public Map<String, Object> saveUser(@RequestBody User User) {
		return UserService.saveUser(User);
	};

	@GetMapping("/")
	public Map<String, Object> getAllUser(@RequestParam(required = false) String searchString,
			@RequestParam(required = false) String sortData, @RequestParam(required = false) Integer pageSize,
			@RequestParam(required = false) Integer page) {
		return UserService.getAllUser(searchString, page, pageSize, sortData);
	};
	
	@GetMapping("/{id}")
	public Map<String, Object> getUserById(@PathVariable Long id) {
		return UserService.getUserById(id);
	};

	@PutMapping("/{id}")
	public Map<String, Object> updateUser(User User) {
		return UserService.updateUser(User);
	};

	@DeleteMapping("/{id}")
	public Map<String, Object> deleteUser(@PathVariable Long id) {
		return UserService.deleteUser(id);
	};
    
}
