package com.wipro.Exception;

public class NotFoundException extends RuntimeException{
	
	public NotFoundException()
	{
		super("No Row Found");
	}
	
	public NotFoundException(long id)
	{
		super("No Row "+id+" Found");
	}

}
