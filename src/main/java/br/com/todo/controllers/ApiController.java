package br.com.todo.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.todo.persistence.entity.Todo;
import br.com.todo.persistence.repository.TodoRepository;
import br.com.todo.utils.TodoNotFoundException;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	private final TodoRepository repository;
	
	ApiController(TodoRepository repository){
		this.repository = repository;
	}
	
	@GetMapping
	List<Todo> index(){
		return repository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	void create(@RequestBody Todo todo) {
		repository.save(todo);
	}
	
	@GetMapping(value = "/{id}")
	Todo edit(@PathVariable long id) {
		return repository.findById(id).orElseThrow(() -> new TodoNotFoundException(id));
	}
	
	@PutMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	Todo update(@RequestBody Todo newTodo, @PathVariable long id) {
		return repository.findById(id)
				.map(todo -> {
					todo.setDescricao(newTodo.getDescricao());
					todo.setCompletado(newTodo.isCompletado());
					return repository.save(todo);
				})
				.orElseGet(() -> {
					newTodo.setId(id);
					return repository.save(newTodo);
				});
	}
	
	@DeleteMapping(value = "/{id}")
	void delete(@PathVariable long id) {
		repository.deleteById(id);
	}

}
