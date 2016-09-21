package com.epam.mentorship.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class DatabaseExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public String handle(RuntimeException e) {
		return "Some errors occurred...";
	}
}
