package mlm.admin.module.project.rowmapper;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mlm.admin.module.project.model.User;


public class UserAmountRowMapper implements RowMapper<User> 
{

	@Override
	public User mapRow(ResultSet rs, int numRow) throws SQLException 
	{
		// TODO Auto-generated method stub
		
		User userAmount = new User();
		userAmount.setAmount(rs.getString("amount"));
		return userAmount;
	}

}
