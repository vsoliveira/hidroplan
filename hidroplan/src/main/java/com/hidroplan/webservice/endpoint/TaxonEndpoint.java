package com.hidroplan.webservice.endpoint;

import javax.xml.bind.JAXBElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.hidroplan.exception.ExecutionInProgressException;
import com.hidroplan.service.consolidation.TaxonService;
import com.hidroplan.webservice.model.gettaxon.GetTaxonRequest;
import com.hidroplan.webservice.model.gettaxon.GetTaxonResponse;

@Endpoint
public class TaxonEndpoint {

	@Autowired
	private TaxonService service;


	@PayloadRoot(namespace = "http://hidroplan.com/webservice/model/gettaxon", localPart = "getTaxonRequest")
	@ResponsePayload public JAXBElement<GetTaxonResponse> getTaxon(@RequestPayload JAXBElement<GetTaxonRequest> getTaxonRequest) throws ExecutionInProgressException {
		GetTaxonResponse response = service.getTaxon(getTaxonRequest.getValue());
		return new com.hidroplan.webservice.model.gettaxon.ObjectFactory().createGetTaxonResponse(response);
	}
}
