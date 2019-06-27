package br.com.todo.utils;

public class TodoNotFoundException extends RuntimeException {
	
	public TodoNotFoundException(Long id) {
		super("Não foi possível encontrar o TODO " + id);
	}
	
}
