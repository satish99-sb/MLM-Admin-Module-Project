package mlm.admin.module.project.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mlm.admin.module.project.dao.AdminDAO;
import mlm.admin.module.project.model.AdminLogin;
import mlm.admin.module.project.model.AdminRegister;
import mlm.admin.module.project.model.User;


@Service
public class AdminServiceImpl implements AdminService
{
	
	@Autowired
	private AdminDAO adminDAO;
	
	
	// ADMIN LOGIN
	@Override
	public List<AdminRegister> adminLogin(AdminLogin adminLogin) 
	{
		List<AdminRegister> login = adminDAO.adminLogin(adminLogin);
		return login;
	}
	

	// ADMIN REGISTRATION
	@Override
	public int adminRegister(AdminRegister adminRegister) 
	{
		int register = adminDAO.adminRegister(adminRegister);
		return register;
	}


	// GET ALL USERS ON ADMIN DASHBOARD
	@Override
	public List<User> getAllUsers() 
	{
		List<User> allUsers = adminDAO.getAllUsers();
		return allUsers;
	}


	// GET SINGLE USERS BY USERID
	@Override
	public List<User> getSingleUser(int id) 
	{
		List<User> singleUser = adminDAO.getSingleUser(id);
		return singleUser;
	}


	@Override
	public int savePin(User user) 
	{
		int savePin = adminDAO.savePin(user);
		return savePin;
	}


	// GET ALL PIN REQUEST
	@Override
	public List<User> getAllPinRequest() 
	{
		List<User> allPinRequest = adminDAO.getAllPinRequest();
		return allPinRequest;
	}


	// GET ALL RECORDS WITH AMOUNT FOR CALCULATING COMMISSION OF ADMIN
	@Override
	public int showAdminCommission() 
	{
		int showAdminCommission = adminDAO.showAdminCommission();
		return showAdminCommission;
	}


	// CHECK ADMIN USERNAME IS ALREADY EXIST IN DB
	@Override
	public boolean isUsernameExist(String username) 
	{
		boolean usernameExist = adminDAO.isUsernameExist(username);
		return usernameExist;
	}

}
