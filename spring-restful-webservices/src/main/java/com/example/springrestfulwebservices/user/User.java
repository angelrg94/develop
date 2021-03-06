package com.example.springrestfulwebservices.user;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description="All user details") //descripcion para swagger
@Entity
public class User {

	@Id
	@GeneratedValue
	//@JsonIgnore
	private Integer id;
	@Size(min=2,message="Name should have atleast 2 characters")
	@ApiModelProperty(notes="Name should have atleast 2 characters") //descripcion para swagger
	private String name;
	@Past
	@ApiModelProperty(notes="birth date cannot be in future")
	private Date birthDate;

	@OneToMany(mappedBy = "user")
	private List<Post> posts;


	public List<Post> getPost() {
		return posts;
	}

	public void setPost(List<Post> post) {
		this.posts = post;
	}

	public User() {
	}

	public User(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
	
	
}
