package com.wacr.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wacr.demo.model.GetMessage;
import com.wacr.demo.model.PostMessage;
import com.wacr.demo.service.definition.ManageMessage;

@RestController
@RequestMapping("/api")
public class DemoController {
	@Autowired
	ManageMessage manageMessage;

	@GetMapping(value = "/getmessage", produces = MediaType.APPLICATION_JSON_VALUE)
	public GetMessage[] petition() {
		return manageMessage.getMessage();
	}

	@PostMapping(value = "/postmessage", produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<PostMessage> response() {
		return manageMessage.modifyMessage();
	}
}
