package net.springboot.javaproject.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "todo")
public class Todo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "element")
	private String element;
	
	@Column(name = "deadline")
	private String deadline;
	
	@Column(name = "statut")
	private String statut;
	
	
	
	
	public Todo() {
		super();
	}

	public Todo(String name, String element) {
		super();
		this.name = name;
		this.element = element;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getElement() {
		return element;
	}
	public void setElement(String element) {
		this.element = element;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	public String getStatut() {
		return name;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	
}
