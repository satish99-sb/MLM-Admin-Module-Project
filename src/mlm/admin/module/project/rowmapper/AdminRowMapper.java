package mlm.admin.module.project.rowmapper;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mlm.admin.module.project.model.AdminRegister;


public class AdminRowMapper implements RowMapper<AdminRegister>
{

	@Override
	public AdminRegister mapRow(ResultSet rs, int numRow) throws SQLException 
	{
		// TODO Auto-generated method stub
		
		AdminRegister adminRegister = new AdminRegister();
		adminRegister.setId(rs.getInt("id"));
		adminRegister.setUsername(rs.getString("username"));
		adminRegister.setPassword(rs.getString("password"));
		adminRegister.setConfirmpassword(rs.getString("confirmpassword"));
		return adminRegister;
	}

}
