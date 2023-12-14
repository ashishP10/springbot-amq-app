package com.springboot.app.publish.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.model.SystemMessage;
import com.springboot.app.service.EventPublisher;

@RestController
@RequestMapping("/fmm/api")
public class PublishController{
	
	@Autowired
	private EventPublisher eventPublisher;
	
	
	@PostMapping("/publishMessage")
	public ResponseEntity<String> publishMessage(
			@RequestBody SystemMessage systemMessage)
	{
			return eventPublisher.publishMessage(systemMessage);
	}
	
	
}