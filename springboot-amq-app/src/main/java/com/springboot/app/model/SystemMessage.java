package com.springboot.app.model;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;

public class SystemMessage implements Serializable {
	private static final long serialVersionUID = 1;
	
	@NotNull(message = "Source is required")
	private String source;
	@NotNull(message = "Message is required")
	private String message;
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "SystemMessage [source=" + source + ", message=" + message + "]";
	}
	
}