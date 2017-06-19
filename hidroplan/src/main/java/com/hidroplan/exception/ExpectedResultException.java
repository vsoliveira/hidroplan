package com.hidroplan.exception;

public class ExpectedResultException extends Exception {

	private static final long serialVersionUID = 5943004108541022029L;
	private final Detail detail;
	
	public ExpectedResultException(String message) {
		super(message);
		this.detail = new Detail(message);
	}
	
	public Detail getDetail() {
		return detail;
	}
}
