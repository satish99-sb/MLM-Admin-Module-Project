package mlm.admin.module.project.dao;


public interface MailDao 
{
	
	// MAIL SEND TO TOP USERID FROM BELOW USERID
	public void send(String fromAddress, String toAddress, String subject, String content);
	
	
	// MAIL SEND TO USERID WITH PIN
	public void sendPin(String fromAddress, String toAddress, String subject, String content);

}
