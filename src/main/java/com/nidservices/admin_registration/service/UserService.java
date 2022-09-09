package com.nidservices.admin_registration.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nidservices.admin_registration.dao.UserDao;
import com.nidservices.admin_registration.model.User;

@Service
public class UserService {
    
	private final UserDao userDao;
	
	/**
	 * @param userDao
	 */
	@Autowired
	public UserService(@Qualifier("postgres") UserDao userDao) {
		this.userDao = userDao;
	}
	
	public int addUser(User user) {
		return userDao.insertUser(user);
	}
	
	
	public List<User> getAllUser() {
		return userDao.selectAllUser();
	}

	public Optional<User> getUserById(UUID id) {
		return userDao.selectUserById(id);
	}
	
	public int deleteUser(UUID id){
		return userDao.deleteUserById(id);
	}
	
	public int updateUser(UUID id, User user){
		return userDao.updateUserById(id, user);
	}
	
	
}
