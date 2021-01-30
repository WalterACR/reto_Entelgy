package com.wacr.demo.util;

import lombok.Getter;

@Getter
public enum URLs {

	COMMENTS_CLIENT(1, "http://jsonplaceholder.typicode.com/comments");

	private int codigo;
	private String url;

	private URLs(int codigo, String url) {
		this.codigo = codigo;
		this.url = url;
	}

}
