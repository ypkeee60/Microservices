package com.learn.springboot.shared;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class Utils {
	
	public String getUniqueId() {
		
		return UUID.randomUUID().toString();
	}

}
