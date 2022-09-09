package com.nidservices.admin_registration.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.nidservices.admin_registration.model.User;

@Repository("Dao")
public class UserDataAccessService implements UserDao {
 
	public static List<User> DB = new ArrayList<>();
	
	@Override
    public int insertUser(UUID id, User user) {
		DB.add(new User(id, user.getCode(), user.getType()));
	 return 1;
    }
	
	@Override
	public List<User> selectAllUser() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Optional<User> selectUserById(UUID id) {
		// TODO Auto-generated method stub
		return DB.stream()
				.filter(user -> user.getId().equals(id))
				.findFirst();
	}
	
	@Override
	public int deleteUserById(UUID id) {
		Optional<User> userMaybe = selectUserById(id);
		if (userMaybe.isEmpty()) {
		return 0;
		}
		DB.remove(userMaybe.get());
		return 1;
	}
	
	@Override
	public int updateUserById(UUID id, User user) {
		return selectUserById(id)
				.map(p -> {
					int indexOfuserToUpdate = DB.indexOf(p);
					if (indexOfuserToUpdate>= 0) {
						DB.set(indexOfuserToUpdate, new User(id, user.getCode(),  user.getType()));
						return 1;
					}
					return 0;
				
				})
				.orElse(0);
		
	}

}
