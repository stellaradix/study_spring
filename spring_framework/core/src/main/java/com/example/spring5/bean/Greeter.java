package com.example.spring5.bean;

public class Greeter {

	private String format;

	public void setFormat(String format) {
		this.format = format;
	}

	public String greet(String guest) {
		return String.format(format, guest);
	}
}
