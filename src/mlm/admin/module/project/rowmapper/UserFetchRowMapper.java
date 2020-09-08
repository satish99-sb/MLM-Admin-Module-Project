package mlm.admin.module.project.rowmapper;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mlm.admin.module.project.model.User;


public class UserFetchRowMapper implements RowMapper<User> 
{

	
	@Override
	public User mapRow(ResultSet rs, int numRow) throws SQLException 
	{
		User user1 = new User();
		user1.setTopuserid(rs.getString("topuserid"));
		user1.setEmail(rs.getString("email"));
		return user1;
	}

}
