package com.nidservices.admin_registration.api;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nidservices.admin_registration.model.User;
import com.nidservices.admin_registration.service.UserService;

@RequestMapping("api/v1/user")
@RestController
public class UserController {
	
  private final UserService userService;
  
  @Autowired
  public UserController(UserService userService) {
	  this.userService = userService;
  }
  
  @PostMapping
  public void addUser(@Validated @NonNull @RequestBody User user) {
	  userService.addUser(user);
  }
  
  @GetMapping
  public List<User> getAllUser() {
	  return userService.getAllUser();
  }
  
  @GetMapping(path = "{id}")
  public User getUserById(@PathVariable UUID id) {
	  return userService.getUserById(id)
			  .orElse(null);
  }
  
  @DeleteMapping(path = "{id}")
  public int deleteUserById(@PathVariable UUID id) {
	  return userService.deleteUser(id);
  }
  
  @PutMapping(path = "{id}")
  public int updateUserById(@PathVariable UUID id, @Validated @NonNull @RequestBody User userToUpdate) {
	  return userService.updateUser(id, userToUpdate);
  } 
}
