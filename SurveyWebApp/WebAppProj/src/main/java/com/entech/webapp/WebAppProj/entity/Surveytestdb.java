package com.entech.webapp.WebAppProj.entity;

import javax.persistence.*;

//Turn our table into an entity
@Entity
public class Surveytestdb {
	//Private Field
	//Table will have the primary key named ID
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column( name = "id", updatable = false, nullable = false)	
	private int id;
	private String timestamp;
	private String name;
	private String email;
	private String college;
	private String degree;
	private String role;
	private String project;
	private String client;
	private String fact1;
	private String fact2;
	//private String picLink;

	//Class Constructor
    public Surveytestdb() {  }
    
    public Surveytestdb(String name, 
    					String email,
						String college,
						String degree,
						String role,
						String project,
						String client,
						String fact1,
						String fact2)
	{
		this.setName(name);
		this.setEmail(email);
		this.setCollege(college);
		this.setDegree(degree);
		this.setRole(role);
		this.setProject(project);
		this.setClient(client);
		this.setFact1(fact1);
		this.setFact2(fact2);
		//this.setPicLink(picLink);
	}
    
	public Surveytestdb(int id,
						String timestamp, 
						String name, 
						String email,
						String college,
						String degree,
						String role,
						String project,
						String client,
						String fact1,
						String fact2)
	{
		this.setId(id);
		this.setTimestamp(timestamp);
		this.setName(name);
		this.setEmail(email);
		this.setCollege(college);
		this.setDegree(degree);
		this.setRole(role);
		this.setProject(project);
		this.setClient(client);
		this.setFact1(fact1);
		this.setFact2(fact2);
		//this.setPicLink(picLink);

	}




	//Getter and Setter Methods
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getFact1() {
		return fact1;
	}

	public void setFact1(String fact1) {
		this.fact1 = fact1;
	}

	public String getFact2() {
		return fact2;
	}

	public void setFact2(String fact2) {
		this.fact2 = fact2;
	}
	/*
	public String getPicLink() {
		return picLink;
	}

	public void setPicLink(String picLink) {
		this.picLink = picLink;
	}*/

}
