package com.wacr.demo.model;

import lombok.Data;

@Data
public class GetMessage {
	private int postId;
	private int id;
	private String name;
	private String email;
	private String body;
}
