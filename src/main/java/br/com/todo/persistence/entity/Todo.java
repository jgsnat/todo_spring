package br.com.todo.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "todo")
public class Todo {
	
	private long id;
	private String descricao;
	private boolean completado;
	
	private Todo() {
	}
	
	public Todo(String descricao, boolean completado) {
		this.descricao = descricao;
		this.completado = completado;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	@Column
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	@Column
	public boolean isCompletado() {
		return completado;
	}
	
	public void setCompletado(boolean completado) {
		this.completado = completado;
	}
	
	@Override
	public String toString() {
		return "Todo{" +
				"id= " + id +
				", descricao= " + descricao +
				", completado= " + completado + 
				"}";
	}

}

