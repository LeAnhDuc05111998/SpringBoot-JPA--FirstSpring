package org.SpringProject.sbjdbc.service;

import java.util.Map;

import org.SpringProject.sbjdbc.entity.User;

public interface UserService {
	
	Map<String, Object>  saveUser(User User);
	
	Map<String, Object> getAllUser(String searchString, Integer page, Integer pageSize, String sortData);

	Map<String, Object> deleteUser(Long id);

	Map<String, Object> getUserById(Long id);

	Map<String, Object> updateUser(User User);

 
}
