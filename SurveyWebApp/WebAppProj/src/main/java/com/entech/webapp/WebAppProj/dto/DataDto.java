//Data Dto used to interact with frontend entity
package com.entech.webapp.WebAppProj.dto;

public class DataDto {
	
	//Initialized Field
	int id;
	String timestamp;
	String name;
	String role;
	String piclink;
	String project;
	String client;
	String college;
	String degree;
	String fact1;
	String fact2;
	
	//Class Constructor
	public DataDto(int id,
					String timestamp, 
					String name, 
					String role,
					String piclink,
					String project,
					String client,
					String college,
					String degree,
					String fact1,
					String fact2)
	{
		this.setId(id);
		this.setTimestamp(timestamp);
		this.setName(name);
		this.setRole(role);
		this.setPiclink(piclink);
		this.setProject(project);
		this.setClient(client);
		this.setCollege(college);
		this.setDegree(degree);
		this.setFact1(fact1);
		this.setFact2(fact2);
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

	public String getPiclink() {
		return piclink;
	}

	public void setPiclink(String piclink) {
		this.piclink = piclink;
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
}
