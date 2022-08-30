package by.tc.task01.service;

public class ServiceException extends Exception{
	
	public ServiceException (Exception e) {
		super(e);
	}
	public ServiceException() {
		super();
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(String message, Exception e) {
		super(message, e);
	}
	
	

}
