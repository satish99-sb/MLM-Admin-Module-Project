package mlm.admin.module.project.service;


import java.util.List;

import mlm.admin.module.project.model.User;


public interface UserService 
{
	
	// LOGIN USER
	public List<User> userLogin(User user);
		
	
	// USER REGISTER
	public int userRegister(User user);
	
	
	//GET ALL USER BY TOPUSERID
	public List<User> getAllUsersBytopUserId(String topUserId);
	
	//GET ALL USER BY EMAIL ID
	public List<User> getAllUsersByEmailID(String emailId);
	
	
	// GET ALL USERS
	public List<User> getAllUsers();
	
	
	// GET SINGLE USER BY USERID FOR POPULATING DATA IN PIN REQUEST
	public List<User> getSingleUser(int id);
	
	
	// SAVE PIN
	public int savePin(User user);

	
	// VIEW ALL PIN FOR USER BY HIS TOPUSERID
	public List<User> getAllPins(String email);
	
	
	// GET COMMISSION OF USER BY HIS TOPUSERID
	public int showUserCommission(String emailId);
	
	
	// CHECK ADMIN USERNAME IS ALREADY EXIST IN DB
	public boolean isEmailExist(String emailId);

}
