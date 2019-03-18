package com.visualpath.user.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.visualpath.user.model.User;
@Service
public interface UserService {
	User findById(Long id);

	List<User> getUserByName(String name);

	List<User> findByLowerName(String name);

	List<User> findByLocation(String address);

	List<User> getUserByNameAddress(String name, String address);

	ResponseEntity<String> createUser(User user);

	ResponseEntity<Object> updateUserByID(User user, long id);

	void deleteUserById(long id);

	

}
