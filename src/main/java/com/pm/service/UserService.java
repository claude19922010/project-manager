package com.pm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pm.dao.TUserDAO;
import com.pm.entity.TUser;

@Service("userService")
public class UserService {
	
	@Autowired
	TUserDAO tUserDAO;

	public int login(String userName, String passWord){
		int ret = -1;
		List<TUser> userList = null;
		userList = tUserDAO.findByProperty("username", userName);
		
		
		
		switch (userList.size()) {
			case 0:
				ret = 0;
				break;
			case 1:
				ret = userList.get(0).getPassword().equals(passWord) ? 1 : -1;

				break;
			default:
				ret = -1;
				break;
		}

		return ret;
	}
}
