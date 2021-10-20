package com.learn.springboot.serviceimpl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.springboot.entity.UserDetails;
import com.learn.springboot.repo.UserServiceRepo;
import com.learn.springboot.serviceinterface.IUserService;
import com.learn.springboot.shared.Utils;
import com.learn.springboot.ui.model.User;


@Service 
@Transactional
public class UserServiceImpl implements IUserService{
	
	private Utils utility;
	
	@Autowired
	private UserServiceRepo userviceRepo;
	
	public UserServiceImpl() {
		
	}
	
	@Autowired
	public UserServiceImpl(Utils utility) {
		this.utility = utility;
	}

	@Override
	@Transactional
	public User createUser(User user) {
		
		UserDetails entity = new UserDetails(); 
		
		entity.setFirstName(user.getFirstName());
		entity.setLastName(user.getLastName());
		entity.setEmail(user.getEmail());		
		userviceRepo.save(entity);
		
		user.setUserId(entity.getId());
		user.setMsg("User created Successfully.");
		
		
		return user;
	}

	@Override
	public User getuser(String userId) {
		Optional<UserDetails> userDetails = userviceRepo.findById(userId);
		User user = new User();
		userDetails.ifPresent(u -> {
			user.setUserId(u.getId());
			user.setFirstName(u.getFirstName());
			user.setLastName(u.getLastName());
			user.setEmail(u.getEmail());
			
			
			});
		
		return user;
	}

	@Override
	@Transactional
	public User updateUser(User user) {
		
		UserDetails entity = new UserDetails(); 
		entity.setId(user.getUserId());
		entity.setFirstName(user.getFirstName());
		entity.setLastName(user.getLastName());
		entity.setEmail(user.getEmail());		
		userviceRepo.save(entity);
		
		
		
		return user;
	}

}
