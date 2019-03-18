package com.visualpath.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.visualpath.user.model.User;
import com.visualpath.user.repository.UserCRUDRepository;
//import com.visualpath.user.repository.UserRepository;

@Service("UserService")
public class UserServiceImpl implements UserService{
	@Autowired
	 UserCRUDRepository userCRUDRepository;
	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		return userCRUDRepository.findById(id).get();
	}
	@Override
	public List<User> getUserByName(String name) {
		// TODO Auto-generated method stub
		//return userCRUDRepository.findByName(name);
		return userCRUDRepository.findByName(name);
	}
	@Override
	public List<User> findByLowerName(String name) {
		// TODO Auto-generated method stub
		return userCRUDRepository.findByLowerName(name);
	}
	@Override
	public List<User> findByLocation(String address) {
		// TODO Auto-generated method stub
		return userCRUDRepository.findByLocation(address);
	}
	@Override
	public List<User> getUserByNameAddress(String name, String address) {
		// TODO Auto-generated method stub
		return userCRUDRepository.getUsersByNameAndCity(name, address);
	}
	@Override
	public ResponseEntity<String> createUser(User user) {
		User savedUser=userCRUDRepository.save(user);
		if(savedUser!=null)
		{
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}
		// TODO Auto-generated method stub
		return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
	}
	@Override
	public ResponseEntity<Object> updateUserByID(User user, long id) {
		// TODO Auto-generated method stub
		Optional<User> user1=userCRUDRepository.findById(id);
		if(user1.isPresent())
		{
            user.setId(id);
			userCRUDRepository.save(user);	
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	
	}
	@Override
	public void deleteUserById(long id) {
		// TODO Auto-generated method stub
		userCRUDRepository.deleteById(id);
	}
	

}
