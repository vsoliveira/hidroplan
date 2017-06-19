package com.hidroplan.exception;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.SENDER)
public class IllegalArgumentHidroplanException extends Exception{

	private static final long serialVersionUID = -4146666758655495573L;
	private final IllegalArgumentExceptionData data = new IllegalArgumentExceptionData();

	public IllegalArgumentHidroplanException(String message) {
		super(message);
		this.data.detail = new Detail(message);
	}

	public IllegalArgumentHidroplanException(Throwable t) {
		super(t);
		this.data.detail = new Detail(t.getMessage());
	}

	public Detail getDetail() {
		return data.detail;
	}
}
