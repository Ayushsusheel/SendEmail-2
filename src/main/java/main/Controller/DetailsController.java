package main.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import main.dto.BaseResponseBody;
import main.dto.DetailsDTO;
import main.dto.DetailsReqDTO;

@RestController
public class DetailsController extends BaseController
{
@GetMapping(value="/hello")
public String display()
{
	return "hello world";
}

@GetMapping(value="/details")
public ResponseEntity<BaseResponseBody> getdtails(@RequestBody DetailsReqDTO detailsreqdto)
{
	try {
		DetailsDTO detailsdto=new DetailsDTO();
		detailsdto.setReqdto(detailsreqdto);
		System.out.println(detailsreqdto.getName());
		System.out.println(detailsreqdto.getEmail());
		
		
		return success(detailsdto, "got", HttpStatus.OK);
		
	}catch(Exception e) {
		return failure("not got", "#FAILED...",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}


	
}
