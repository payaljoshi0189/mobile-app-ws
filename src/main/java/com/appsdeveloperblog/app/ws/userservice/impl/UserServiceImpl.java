package com.appsdeveloperblog.app.ws.userservice.impl;

import java.util.HashMap;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsdeveloperblog.app.ws.shared.Utils;
import com.appsdeveloperblog.app.ws.ui.model.request.UserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.ui.model.response.UserRest;
import com.appsdeveloperblog.app.ws.userservice.UserService;


@Service
public class UserServiceImpl implements UserService{
	HashMap<String, UserRest> users;
	Utils utils;
	
	public UserServiceImpl() {
		
	}
	
	@Autowired
	public UserServiceImpl(Utils utils) {
		this.utils = utils;
	}

	@Override
	public UserRest createUser(UserDetailsRequestModel userDetails) {
		// TODO Auto-generated method stub
		UserRest returnVal = new UserRest();
		returnVal.setFirstName(userDetails.getFirstName());
		returnVal.setLastName(userDetails.getLastName());
		returnVal.setEmail(userDetails.getEmail());
		String userId = utils.getUserId();
		returnVal.setUserId(userId);
		
		if(users == null)
			users = new HashMap<String, UserRest>();
		
		users.put(userId, returnVal);
		return returnVal;
	}

}
