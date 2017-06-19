package com.hidroplan.exception;

public class ExecutionInProgressException extends Exception {

	private static final long serialVersionUID = 9141929980339857985L;

	private final Detail detail;
	
	public ExecutionInProgressException(String message) {
		super(message);
		this.detail = new Detail(message);
	}
	
	public Detail getDetail() {
		return detail;
	}
}
