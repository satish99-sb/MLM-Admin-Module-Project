package mlm.admin.module.project.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mlm.admin.module.project.dao.MailDao;


@Service
public class MailServiceImpl implements MailService 
{
	
	@Autowired
	private MailDao mailDAO;

	
	// MAIL SEND TO TOP USERID FROM BELOW USERID
	@Override
	public void send(String fromAddress, String toAddress, String subject, String content) 
	{
		
		mailDAO.send(fromAddress, toAddress, subject, content);
	}

	
	// MAIL SEND TO USERID WITH PIN
	@Override
	public void sendPin(String fromAddress, String toAddress, String subject, String content) 
	{
		mailDAO.sendPin(fromAddress, toAddress, subject, content);
	}

}
