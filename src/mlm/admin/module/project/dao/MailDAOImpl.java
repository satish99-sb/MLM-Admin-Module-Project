package mlm.admin.module.project.dao;


import java.util.Date;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Repository;


@Repository
public class MailDAOImpl implements MailDao 
{
	
	@Autowired
	private JavaMailSender javaMailSender;

	
	// MAIL SEND TO TOP USERID FROM BELOW USERID
	@Override
	public void send(String fromAddress, String toAddress, String subject, String content) 
	{

		try 
		{
			
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setFrom(fromAddress);			
			mimeMessageHelper.setTo(toAddress);			
			mimeMessageHelper.setSubject(subject);			
			mimeMessageHelper.setText(content);			
			mimeMessageHelper.setSentDate(new Date());
			
			javaMailSender.send(mimeMessage);
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}


	// MAIL SEND TO USERID WITH PIN
	@Override
	public void sendPin(String fromAddress, String toAddress, String subject, String content) 
	{
		
		try 
		{
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setFrom(fromAddress);
			mimeMessageHelper.setTo(toAddress);
			mimeMessageHelper.setSubject(subject);
			mimeMessageHelper.setText(content);
			mimeMessageHelper.setSentDate(new Date());
			
			javaMailSender.send(mimeMessage);
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}


}
