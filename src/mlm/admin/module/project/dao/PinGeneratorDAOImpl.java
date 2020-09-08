package mlm.admin.module.project.dao;


import java.util.Random;

import org.springframework.stereotype.Repository;


@Repository
public class PinGeneratorDAOImpl implements PinGeneratorDAO 
{

	// PIN GENERATOR
	public char[] generatePin(int length) 
	{
		
		String no = "0123456789";
		Random r = new Random();
		char[] pin = new char[length];

		for(int i=0;i<length;i++)
		{
			pin[i] = no.charAt(r.nextInt(no.length()));
		}
		
		return pin;
	}

}
