package com.hidroplan.webservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.hidroplan.exception.Detail;
import com.hidroplan.exception.ExpectedResultException;
import com.hidroplan.exception.IllegalArgumentHidroplanException;
import com.hidroplan.service.consolidation.EnvironmentService;
import com.hidroplan.webservice.model.getenvironment.GetEnvironmentRequest;
import com.hidroplan.webservice.model.getenvironment.GetEnvironmentResponse;

@Controller
@RequestMapping("/environment")
public class EnvironmentController {

	@Autowired
	private EnvironmentService service;

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	@ResponseBody public GetEnvironmentResponse get(@ModelAttribute GetEnvironmentRequest request) {
		return service.getEnvironment(request);
	}

	@ExceptionHandler({ IllegalArgumentHidroplanException.class })
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody public Detail processException(IllegalArgumentHidroplanException e) {
		return e.getDetail();
	}

	@ExceptionHandler({ ExpectedResultException.class })
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody public Detail processException(ExpectedResultException e) {
		return e.getDetail();
	}

	@ExceptionHandler({ Exception.class })
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody public Detail processException(Exception e) {
		return new Detail(e.getMessage());
	}
}
