package com.hidroplan.webservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hidroplan.service.consolidation.PerfilTaxonService;
import com.hidroplan.webservice.model.createperfiltaxon.CreatePerfilTaxonRequest;
import com.hidroplan.webservice.model.createperfiltaxon.CreatePerfilTaxonResponse;
import com.hidroplan.webservice.model.getperfiltaxon.GetPerfilTaxonRequest;
import com.hidroplan.webservice.model.getperfiltaxon.GetPerfilTaxonResponse;

@Controller
@RequestMapping("/perfiltaxon")
public class PerfilTaxonController {

	@Autowired
	private PerfilTaxonService service;

	@RequestMapping(value="/create", method = RequestMethod.GET)
	@ResponseBody public CreatePerfilTaxonResponse create(@ModelAttribute CreatePerfilTaxonRequest request) {
		return service.createPerfilTaxon(request);
	}

	@RequestMapping(value="/get", method = RequestMethod.GET)
	@ResponseBody public GetPerfilTaxonResponse get(@ModelAttribute GetPerfilTaxonRequest request) {
		return service.getPerfilTaxon(request);
	}
}
