package main.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.Service.Service_Email;
import main.dto.BaseResponseBody;
import main.dto.DetailsDTO;
import main.dto.DetailsReqDTO;

@RestController

public class DetailsController extends BaseController
{
	
	@Autowired 
	Service_Email service;
	
	
	
//------------------------------------------------------------------------------------------------------------------------------------	

	
@GetMapping(value="/hello")
public String display()
{
	return "hello world";
}



//------------------------------------------------------------------------------------------------------------------------------------	


@PostMapping("/details")
public ResponseEntity<BaseResponseBody> getdtails(@RequestBody DetailsReqDTO detailsreqdto)
{
	try {
		DetailsDTO detailsdto=new DetailsDTO();
		detailsdto.setReqdto(detailsreqdto);
		System.out.println("name---->"+ "  " +detailsreqdto.getName());
		System.out.println("eamil--->"+"   " +detailsreqdto.getEmail());
		
		
		return success(detailsdto, "got", HttpStatus.OK);
		
	}catch(Exception e) {
		return failure("not got", "#FAILED...",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}


//------------------------------------------------------------------------------------------------------------------------------------	

@PostMapping(value="/mail/send")
public ResponseEntity<BaseResponseBody> sendmail(@RequestBody DetailsReqDTO detailsreqdto)
{
	try {
		DetailsDTO detailsdto=new DetailsDTO();
		detailsdto.setReqdto(detailsreqdto);
		
		service.sendEmail(detailsreqdto.getEmail(), "Successfully registered", "Hello,\n Thankyou for registering in SaaS-Nest Technologies \n we will be contacting you soon\n Regards,\n Team-SaaS-Nest.");
		
		System.out.println("name---->"+ "  " +detailsreqdto.getName());
		System.out.println("email--->"+"   " +detailsreqdto.getEmail());
		
		
		return success(detailsdto, "sent", HttpStatus.OK);
		
	}catch(Exception e) {
		return failure("not sent", "#FAILED...",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}





//public void sendMail(@RequestBody DetailsReqDTO detailsreqdto)
//{
//	service.sendEmail(detailsreqdto.getEmail(), "SUCCESS", "hi welcome");
//}	





}
