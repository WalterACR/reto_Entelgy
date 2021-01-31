package com.wacr.demo.service.impl;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wacr.demo.model.GetMessage;
import com.wacr.demo.model.PostMessage;
import com.wacr.demo.service.definition.ManageMessage;
import com.wacr.demo.util.URLs;

@Service
public class ManageMessageImpl implements ManageMessage {

	@Override
	public GetMessage[] getMessage() {
		RestTemplate restTemplate = new RestTemplate();
		URLs apiClient = URLs.COMMENTS_CLIENT;
		ResponseEntity<GetMessage[]> response = restTemplate.getForEntity(apiClient.getUrl(), GetMessage[].class);
		return response.getBody();
	}

	@Override
	public ArrayList<PostMessage> modifyMessage() {
		ArrayList<PostMessage> answerModified = new ArrayList<PostMessage>();
		GetMessage[] messages = getMessage();
		
		for (GetMessage getMessage : messages) {
			PostMessage tempPostMessage = new PostMessage();
			tempPostMessage.setPostId(getMessage.getPostId());
			tempPostMessage.setId(getMessage.getId());
			tempPostMessage.setEmail(getMessage.getEmail());
			answerModified.add(tempPostMessage);
		}
		return answerModified;
	}

}
