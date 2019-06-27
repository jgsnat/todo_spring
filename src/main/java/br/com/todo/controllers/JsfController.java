package br.com.todo.controllers;

import org.springframework.stereotype.Component;

@Component("jsfController")
public class JsfController {
	
	public String getText() {
		return "Funcionando!";
	}

}
