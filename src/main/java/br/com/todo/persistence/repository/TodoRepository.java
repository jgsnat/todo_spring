package br.com.todo.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.todo.persistence.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
