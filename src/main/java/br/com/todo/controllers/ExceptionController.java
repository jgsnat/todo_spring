package br.com.todo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.todo.utils.TodoNotFoundException;

@ControllerAdvice
public class ExceptionController {
	
	@ResponseBody
	@ExceptionHandler(TodoNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String todoNotFoundHandler(TodoNotFoundException ex) {
		return ex.getMessage();
	}

}
