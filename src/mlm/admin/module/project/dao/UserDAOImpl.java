package mlm.admin.module.project.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mlm.admin.module.project.model.User;
import mlm.admin.module.project.rowmapper.UserFetchRowMapper;
import mlm.admin.module.project.rowmapper.UserLoginRowMapper;
import mlm.admin.module.project.rowmapper.UserRowMapper;


@Repository
public class UserDAOImpl implements UserDAO 
{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	// USER LOGIN
	@Override
	public List<User> userLogin(User user) 
	{
		String sql = "select * from pin_request where email = '"+user.getEmail()+"' and pin = '"+user.getPin()+"' ";
		UserLoginRowMapper userloginRowMapper = new UserLoginRowMapper();
		List<User> userquery = jdbcTemplate.query(sql, userloginRowMapper);
		return userquery;
	}

	
	// USER REGISTER
	@Override
	public int userRegister(User user) 
	{
		String sql = "insert into user_table values (?,?,?,?,?,?,?,?,?)";
		int register = jdbcTemplate.update(sql,user.getId() , user.getTopuserid(), user.getEmail(), user.getAccountno(), user.getMobileno(), user.getAddress(), user.getUserside(), user.getGender(), user.getAmount());
		return register;
	}
	
	
	//GET ALL USER BY EMAIL ID
	@Override
	public List<User> getAllUsersByEmailID(String emailId) 
	{
		String sql = "select * from user_table where email = ? ";
		UserRowMapper userRowMapper = new UserRowMapper();
		List<User> usersByEmailID = jdbcTemplate.query(sql, new Object[] {emailId}, userRowMapper);
		return usersByEmailID;
	}



	//GET ALL USER BY TOP USER ID
	@Override
	public List<User> getAllUsersBytopUserId(String topUserId) 
	{
		String sql = "select * from user_table where topuserid = ? ";
		UserRowMapper userRowMapper = new UserRowMapper();
		List<User> getAllUsers = jdbcTemplate.query(sql, new Object[] {topUserId}, userRowMapper);
		return getAllUsers;
	}


	// GET ALL USERS
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
		String sql = "select topuserid,email from user_table where id=?";
		UserFetchRowMapper userFetchRowMapper = new UserFetchRowMapper();
		List<User> singleUser = jdbcTemplate.query(sql, new Object[] {id}, userFetchRowMapper);
		return singleUser;
	}
		
	
	// SAVE PIN
	@Override
	public int savePin(User user)
	{
		String sql = "insert into pin_request values (?,?,?,?)";
		int savepin = jdbcTemplate.update(sql, user.getId(), user.getTopuserid() , user.getEmail(), user.getPin());
		return savepin;
	}
	

	// VIEW ALL PIN FOR USER BY HIS TOPUSERID
	@Override
	public List<User> getAllPins(String email) 
	{
		String sql = "select * from pin_request where email = ?";
		UserLoginRowMapper loginRowMapper = new UserLoginRowMapper();
		List<User> getPins = jdbcTemplate.query(sql, new Object[] {email}, loginRowMapper);
		return getPins;
	}


	// GET COMMISSION OF USER BY HIS TOPUSERID
	@Override
	public int showUserCommission(String emailId) 
	{
		String sql = "select sum(amount) from user_table where topuserid=?";
		int userCommission = jdbcTemplate.queryForInt(sql, new Object [] {emailId});
		return userCommission;
	}


	// CHECK ADMIN USERNAME IS ALREADY EXIST IN DB
	@Override
	public boolean isEmailExist(String emailId) 
	{
		String sql = " select count(email) from user_table where email = ? ";
		Integer emailExist = jdbcTemplate.queryForObject(sql, new String[] {emailId}, Integer.class);
		
		if(emailExist==1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	
}
