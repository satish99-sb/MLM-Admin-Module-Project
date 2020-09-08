package mlm.admin.module.project.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mlm.admin.module.project.dao.UserDAO;
import mlm.admin.module.project.model.User;


@Service
public class UserServiceImpl implements UserService 
{
	
	@Autowired
	private UserDAO userDAO;
	
	
	// LOGIN USER
	@Override
	public List<User> userLogin(User user) 
	{
		List<User> userLogin = userDAO.userLogin(user);
		return userLogin;
	}
	

	// USER REGISTER
	@Override
	public int userRegister(User user) 
	{
		int userRegister = userDAO.userRegister(user);
		return userRegister;
	}


	//GET ALL USER BY TOP USERID
	@Override
	public List<User> getAllUsersBytopUserId(String topUserId)
	{
		List<User> topUserid = userDAO.getAllUsersBytopUserId(topUserId);
		return topUserid;
	}


	// GET ALL USERS
	@Override
	public List<User> getAllUsers() 
	{
		List<User> allUsers = userDAO.getAllUsers();
		return allUsers;
	}
	
	
	// GET SINGLE USER BY USERID FOR POPULATING DATA IN PIN REQUEST
	@Override
	public List<User> getSingleUser(int id) 
	{
		List<User> singleUser = userDAO.getSingleUser(id);
		return singleUser;
	}
	
	
	// SAVE PIN
	@Override
	public int savePin(User user) 
	{
		int savePin = userDAO.savePin(user);
		return savePin;
	}
	

	// VIEW ALL PIN FOR USER BY HIS TOPUSERID
	@Override
	public List<User> getAllPins(String email) 
	{
		List<User> allPins = userDAO.getAllPins(email);
		return allPins;
	}


	// GET COMMISSION OF USER
	@Override
	public int showUserCommission(String emailId) 
	{
		int showUserCommission = userDAO.showUserCommission(emailId);
		return showUserCommission;
	}


	// GET COMMISSION OF USER BY HIS TOPUSERID
	@Override
	public List<User> getAllUsersByEmailID(String emailId) 
	{
		List<User> usersByEmailID = userDAO.getAllUsersByEmailID(emailId);
		return usersByEmailID;
	}


	// CHECK ADMIN USERNAME IS ALREADY EXIST IN DB
	@Override
	public boolean isEmailExist(String emailId) 
	{
		boolean emailExist = userDAO.isEmailExist(emailId);
		return emailExist;
	}


}
