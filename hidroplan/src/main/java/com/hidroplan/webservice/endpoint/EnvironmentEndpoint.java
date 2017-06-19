package com.hidroplan.webservice.endpoint;

import javax.xml.bind.JAXBElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.hidroplan.service.consolidation.EnvironmentService;
import com.hidroplan.webservice.model.getenvironment.GetEnvironmentRequest;
import com.hidroplan.webservice.model.getenvironment.GetEnvironmentResponse;

@Endpoint
public class EnvironmentEndpoint {
	@Autowired
	private EnvironmentService service;

	@PayloadRoot(namespace = "http://hidroplan.com/webservice/model/getenvironment", localPart = "getEnvironmentRequest")
	@ResponsePayload public JAXBElement<GetEnvironmentResponse> getEnvironment(@RequestPayload JAXBElement<GetEnvironmentRequest> getEnvironmentRequest) {
		GetEnvironmentResponse response = service.getEnvironment(getEnvironmentRequest.getValue());
		return new com.hidroplan.webservice.model.getenvironment.ObjectFactory().createGetEnvironmentResponse(response);
	}
}
