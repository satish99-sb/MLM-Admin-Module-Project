package mlm.admin.module.project.service;


import java.util.Random;

import org.springframework.stereotype.Service;


@Service
public class PinGeneratorServiceImpl implements PinGeneratorService 
{
	
	public char[] generatePin(int length) 
	{
		/*String no = "0123456789";
		Random r = new Random();
		char[] pin = new char[length];

		for(int i=0;i<length;i++)
		{
			pin[i] = no.charAt(r.nextInt(no.length()));
		}
		return pin;*/
		return null;
	}

}
