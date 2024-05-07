package com.wipro.Exception;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

	@ResponseBody
	@ExceptionHandler(NoDataException.class)
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	Object HandleNoDataException(NoDataException e)
	{
		Map<String,Object> ex=new LinkedHashMap<String,Object>();
		ex.put("timestamp",LocalDate.now());
		ex.put("message",e.getMessage() );
		return ex;
	}
	@ResponseBody
	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	Object HandleNotFoundException(NotFoundException e)
	{
		Map<String,Object> ex=new LinkedHashMap<String,Object>();
		ex.put("timestamp",LocalDate.now());
		ex.put("message",e.getMessage() );
		return ex;
	}

}
