package mlm.admin.module.project.dao;


import java.util.List;

import mlm.admin.module.project.model.AdminLogin;
import mlm.admin.module.project.model.AdminRegister;
import mlm.admin.module.project.model.User;


public interface AdminDAO 
{
	
	// LOGIN
	public List<AdminRegister> adminLogin(AdminLogin adminLogin);
	
	
	// REGISTER
	public int adminRegister(AdminRegister adminRegister);
	
	
	// GET ALL USERS
	public List<User> getAllUsers();
	
	
	// GET SINGLE USER BY USERID FOR POPULATING DATA IN PIN REQUEST
	public List<User> getSingleUser(int id);
	
	
	// SAVE PIN
	public int savePin(User user);
	
	
	// GET ALL PIN
	public List<User> getAllPinRequest();
	
	
	// GET COMMISSION OF ADMIN
	public int showAdminCommission();
	
	
	// CHECK ADMIN USERNAME IS ALREADY EXIST IN DB
	public boolean isUsernameExist(String username);

}
