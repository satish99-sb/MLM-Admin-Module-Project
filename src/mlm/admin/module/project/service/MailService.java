package mlm.admin.module.project.service;


public interface MailService 
{
	
	// MAIL SEND TO TOP USERID FROM BELOW USERID
	public void send(String fromAddress, String toAddress, String subject, String content);
	
	
	// MAIL SEND TO USERID WITH PIN
	public void sendPin(String fromAddress, String toAddress, String subject, String content);

}
