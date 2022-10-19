package com.adminmodule.ABCUniversity.exception;

public class AdminmoduleException extends RuntimeException{
	 public AdminmoduleException(String message){
	        super(message);
	    }
	    public AdminmoduleException(long id){
	        super("Id not Found"+id);
	    }
}
