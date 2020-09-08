package mlm.admin.module.project.model;


public class AdminRegister 
{
	private int id;
	private String username;
	private String password;
	private String confirmpassword;
	
	
	public AdminRegister() 
	{
		// TODO Auto-generated constructor stub
	}
	
	
	
	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getUsername() 
	{
		return username;
	}

	public void setUsername(String username) 
	{
		this.username = username;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getConfirmpassword() 
	{
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) 
	{
		this.confirmpassword = confirmpassword;
	}


	@Override
	public String toString() 
	{
		return " AdminRegister : [ USERNAME = " + username + " , PASSWORD = " + password + " , CONFIRMPASSWORD = " + confirmpassword + " ] ";
	}

}
