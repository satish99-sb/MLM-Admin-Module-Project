package mlm.admin.module.project.rowmapper;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mlm.admin.module.project.model.User;


public class UserRowMapper implements RowMapper<User> 
{

	@Override
	public User mapRow(ResultSet rs, int numRow) throws SQLException 
	{
		// TODO Auto-generated method stub
		
		/*User user = new User();
		user.setId(rs.getInt("id"));
		user.setTopuserid(rs.getString("topuserid"));
		user.setEmail(rs.getString("email"));
		user.setAccountno(rs.getString("accountno"));
		user.setMobileno(rs.getString("mobileno"));
		user.setAddress(rs.getString("address"));
		user.setUserside(rs.getString("side"));
		user.setGender(rs.getString("gender"));
		return user;*/
		
		
		User user = new User();
		user.setId(rs.getInt(1));
		user.setTopuserid(rs.getString(2));
		user.setEmail(rs.getString(3));
		user.setAccountno(rs.getString(4));
		user.setMobileno(rs.getString(5));
		user.setAddress(rs.getString(6));
		user.setUserside(rs.getString(7));
		user.setGender(rs.getString(8));
		user.setAmount(rs.getString(9));
		return user;
		
	}

}
