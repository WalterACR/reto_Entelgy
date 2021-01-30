package com.wacr.demo.controller;

import java.util.ArrayList;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.wacr.demo.model.GetMessage;
import com.wacr.demo.model.PostMessage;

@RestController
@RequestMapping("/api")
public class DemoController {
	private GetMessage[] mensajes;
	private ArrayList<PostMessage> respuestaModificada;
	

	@GetMapping(value = "/getmessage", produces = MediaType.APPLICATION_JSON_VALUE)
	public GetMessage[] peticion() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<GetMessage[]> response = restTemplate.getForEntity("http://jsonplaceholder.typicode.com/comments",
				GetMessage[].class);
		this.mensajes=response.getBody();
	return this.mensajes;
	}

	@PostMapping(value = "/postmessage", produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<PostMessage> response() {
		respuestaModificada = new ArrayList<PostMessage>();
		for (GetMessage getMessage : mensajes) {
			PostMessage tempPostMessage= new PostMessage();
			
			tempPostMessage.setPostId(getMessage.getPostId());;
			tempPostMessage.setId(getMessage.getId());;
			tempPostMessage.setEmail(getMessage.getEmail());
			this.respuestaModificada.add(tempPostMessage);
		}
		
		return respuestaModificada;
	}
}
