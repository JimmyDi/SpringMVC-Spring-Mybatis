package com.di.exception;

public class SeckillCloseException extends RuntimeException{
	
	public SeckillCloseException(String message){
		super(message);
	}
	
	public SeckillCloseException(String message, Throwable cause){
		super(message, cause);
	}
	
}