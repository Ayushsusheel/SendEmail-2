package main.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import main.dto.BaseResponseBody;

public class BaseController 
{

	public ResponseEntity<BaseResponseBody> success(Object response,String message,HttpStatus status)
	{
		BaseResponseBody baseresponsebody=new BaseResponseBody();
		baseresponsebody.setSuccess(Boolean.TRUE);
		baseresponsebody.setMessage(message);
		baseresponsebody.setData(response);
		
		return new ResponseEntity<>(baseresponsebody,status);
	}
	
	
	
	public ResponseEntity<BaseResponseBody> failure(Object response,String message,HttpStatus status)
	{
		BaseResponseBody baseresponsebody=new BaseResponseBody();
		baseresponsebody.setSuccess(Boolean.FALSE);
		baseresponsebody.setMessage(message);
		baseresponsebody.setData(response);
		
		return new ResponseEntity<>(baseresponsebody,status);
		
	}
	
	
}
