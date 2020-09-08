package mlm.admin.module.project.service;

import java.util.List;

import mlm.admin.module.project.model.AdminLogin;
import mlm.admin.module.project.model.AdminRegister;
import mlm.admin.module.project.model.User;

public interface AdminService 
{
	
	// LOGIN
	public List<AdminRegister> adminLogin(AdminLogin adminLogin);
	
	
	// REGISTER
	public int adminRegister(AdminRegister adminRegister);
	
	
	// GET ALL USERS
	public List<User> getAllUsers();
	
	
	// GET SINGLE USERS BY USERID
	public List<User> getSingleUser(int id);
	
	
	// SAVE PIN
	public int savePin(User user);
	
	
	// GET ALL PIN
	public List<User> getAllPinRequest();
	
	
	// GET ALL RECORDS WITH AMOUNT FOR CALCULATING COMMISSION OF ADMIN
	public int showAdminCommission();
	
	
	// CHECK ADMIN USERNAME IS ALREADY EXIST IN DB
	public boolean isUsernameExist(String username);

}
