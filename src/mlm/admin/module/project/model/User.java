package mlm.admin.module.project.model;

public class User 
{
	
	private int id;
	private String topuserid;
	private String email;
	private String accountno;
	private String mobileno;
	private String address;
	private String userside;
	private String gender;
	private String pin;
	private String amount;
	

	public User() 
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

	public String getTopuserid() 
	{
		return topuserid;
	}

	public void setTopuserid(String topuserid) 
	{
		this.topuserid = topuserid;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getAccountno() 
	{
		return accountno;
	}

	public void setAccountno(String accountno) 
	{
		this.accountno = accountno;
	}

	public String getMobileno() 
	{
		return mobileno;
	}

	public void setMobileno(String mobileno) 
	{
		this.mobileno = mobileno;
	}

	public String getAddress() 
	{
		return address;
	}

	public void setAddress(String address) 
	{
		this.address = address;
	}
	
	public String getUserside() 
	{
		return userside;
	}
	public void setUserside(String userside) 
	{
		this.userside = userside;
	}

	public String getGender() 
	{
		return gender;
	}

	public void setGender(String gender) 
	{
		this.gender = gender;
	}

	public String getPin() 
	{
		return pin;
	}

	public void setPin(String pin) 
	{
		this.pin = pin;
	}

	public String getAmount() 
	{
		return amount;
	}

	public void setAmount(String amount) 
	{
		this.amount = amount;
	}


	@Override
	public String toString()
	{
		return " USER := [ TOP_USERID = " + topuserid + " , EMAIL = " + email + " , ACCOUNT NO = " + accountno + " , MOBILE NO = "
				+ mobileno + " , ADDRESS = " + address + " , USER_SIDE = " + userside + " , GENDER = " + gender + " , AMOUNT = " + amount + " ] \n " ;
	}

}
