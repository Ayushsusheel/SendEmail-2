package main.Service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;



@Service
public class Service_Email
{
 
	@Autowired
	private JavaMailSender sender;
	
	public void sendEmail(String tomail,String subject,String body)
	{
		
		try 
		{
			SimpleMailMessage message=new SimpleMailMessage();
			message.setFrom("ayushsusheel3@gmail.com");
			message.setTo(tomail);
			message.setSubject(subject);
			message.setText(body);
			
			sender.send(message);
			System.out.println("MAIL SENT......");
		}catch(Exception e) {System.out.println("error--->" + e);}
		
	}
	
	
	
}
