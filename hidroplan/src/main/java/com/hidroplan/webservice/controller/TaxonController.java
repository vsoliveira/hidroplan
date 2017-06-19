package com.hidroplan.webservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hidroplan.exception.ExecutionInProgressException;
import com.hidroplan.service.consolidation.TaxonService;
import com.hidroplan.webservice.model.gettaxon.GetTaxonRequest;
import com.hidroplan.webservice.model.gettaxon.GetTaxonResponse;

@Controller
@RequestMapping("/taxon")
public class TaxonController {

	@Autowired
	private TaxonService service;

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	@ResponseBody public GetTaxonResponse get(@ModelAttribute GetTaxonRequest request) throws ExecutionInProgressException{
		return service.getTaxon(request);
	}
}
