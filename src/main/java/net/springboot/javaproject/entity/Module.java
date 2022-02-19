package net.springboot.javaproject.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "modules")
public class Module {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "specialite")
	private String specialite;
	
	@Column(name = "element1")
	private String element1;
	
	@Column(name = "element2")
	private String element2;
	
	@Column(name = "element3")
	private String element3;
	
	
	
	
	public Module() {
		super();
	}

	public Module(String name, String specialite) {
		super();
		this.name = name;
		this.specialite = specialite;
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
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	public String getElement1() {
		return element1;
	}
	public void setElement1(String element1) {
		this.element1 = element1;
	}
	public String getElement2() {
		return element2;
	}
	public void setElement2(String element2) {
		this.element2 = element2;
	}
	public String getElement3() {
		return element3;
	}
	public void setElement3(String element3) {
		this.element3 = element3;
	}
	
	
	
}
