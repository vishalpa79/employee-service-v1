package com.evoke.researchlabs.row.employee.exception;

/**
 * Its a custom exception class for throwing user defined exception
 * @author apandiri
 *
 */
public class AppException extends Exception {

	private static final long serialVersionUID = 1L;
	private String message;

	/**
	 * @param message
	 */
	public AppException(String message) {
		super(message);
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
