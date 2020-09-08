package mlm.admin.module.project.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mlm.admin.module.project.model.AdminLogin;
import mlm.admin.module.project.model.AdminRegister;
import mlm.admin.module.project.model.User;
import mlm.admin.module.project.rowmapper.AdminRowMapper;
import mlm.admin.module.project.rowmapper.UserAmountRowMapper;
import mlm.admin.module.project.rowmapper.UserFetchRowMapper;
import mlm.admin.module.project.rowmapper.UserLoginRowMapper;
import mlm.admin.module.project.rowmapper.UserRowMapper;


@Repository
public class AdminDAOImpl implements AdminDAO
{
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	// ADMIN-LOGIN
	@Override
	@Transactional(readOnly = false)
	public List<AdminRegister> adminLogin(AdminLogin adminLogin) 
	{
		String sql = "select * from admin_table where username = '"+adminLogin.getUsername()+"' and password = '"+adminLogin.getPassword()+"' ";
		AdminRowMapper rowMapper = new AdminRowMapper();
		List<AdminRegister> login = jdbcTemplate.query(sql, rowMapper);
		return login;
	}

	
	// ADMIN-REGISTRATION
	@Override
	@Transactional(readOnly = false)
	public int adminRegister(AdminRegister adminRegister) 
	{
		String sql = "insert into admin_table values (?,?,?,?)";
		int register = jdbcTemplate.update(sql, adminRegister.getId() , adminRegister.getUsername(), adminRegister.getPassword(), adminRegister.getConfirmpassword());
		return register;
	}


	// GET ALL USERS ON ADMIN DASHBOARD
	@Override
	public List<User> getAllUsers() 
	{
		String sql = "select * from user_table";
		UserRowMapper userRowMapper = new UserRowMapper();
		List<User> allUsers = jdbcTemplate.query(sql, userRowMapper);
		return allUsers;
	}


	// GET SINGLE USER BY USERID FOR POPULATING DATA IN PIN REQUEST
	@Override
	public List<User> getSingleUser(int id) 
	{
		String sql = "select topuserid,email from user_table where id=? ";
		UserFetchRowMapper userFetchRowMapper = new UserFetchRowMapper();
		List<User> users = jdbcTemplate.query(sql, new Object[] {id}, userFetchRowMapper);
		return users;
	}


	@Override
	public int savePin(User user) 
	{
		String sql = "insert into pin_request values (?,?,?,?)";
		int savepin = jdbcTemplate.update(sql, user.getId(), user.getTopuserid() , user.getEmail(), user.getPin());
		return savepin;
	}


	// GET ALL PIN
	@Override
	public List<User> getAllPinRequest() 
	{
		String sql = "select * from pin_request";
		UserLoginRowMapper loginRowMapper = new UserLoginRowMapper();
		List<User> allPins = jdbcTemplate.query(sql, loginRowMapper);
		return allPins;
	}


	// GET ALL RECORDS WITH AMOUNT FOR CALCULATING COMMISSION OF ADMIN
	@Override
	public int showAdminCommission() 
	{
		String sql = "select sum(amount) from user_table ";
		int queryForInt = jdbcTemplate.queryForInt(sql);
		return queryForInt;
	}


	// CHECK ADMIN USERNAME IS ALREADY EXIST IN DB
	@Override
	public boolean isUsernameExist(String username) 
	{
		String sql = " select count(username) from admin_table where username = ? ";
		Integer adminExist = jdbcTemplate.queryForObject(sql, new String[] {username}, Integer.class);
		if(adminExist==1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
