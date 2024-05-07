package com.wipro.Exception;


public class NoDataException extends RuntimeException{
	
	public NoDataException()
	{
		super("--------No Records Found in a Table--------");
	}
	
	public NoDataException(String error)
	{
		super(error);
	}

}
