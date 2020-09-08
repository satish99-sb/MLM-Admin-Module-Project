package mlm.admin.module.project.rowmapper;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mlm.admin.module.project.model.User;


public class UserLoginRowMapper implements RowMapper<User> 
{

	@Override
	public User mapRow(ResultSet rs, int numRow) throws SQLException 
	{
		// TODO Auto-generated method stub

		User userlogin = new User();
		userlogin.setId(rs.getInt("id"));
		userlogin.setTopuserid(rs.getString("topuserid"));
		userlogin.setEmail(rs.getString("email"));
		userlogin.setPin(rs.getString("pin"));
		return userlogin;
	}

}
