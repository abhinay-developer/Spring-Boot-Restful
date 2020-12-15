package com.fileupload.model;

import lombok.Data;

@Data
public class ResponseMessage {

	
	private String message;

	public ResponseMessage(String message) {
		super();
		this.message = message;
	}
	
}
