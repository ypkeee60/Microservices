package com.learn.springboot.serviceinterface;

import com.learn.springboot.ui.model.User;

public interface IUserService {
	
	User createUser(User user);
	
	User getuser(String userId);
	
	User updateUser(User user);

}
