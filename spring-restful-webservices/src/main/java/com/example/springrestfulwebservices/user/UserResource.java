package com.example.springrestfulwebservices.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.springrestfulwebservices.user.exception.UserNotFountException;

@RestController
public class UserResource {

	@Autowired
	UserDaoService service;

	// GET /users
	// Retrieve all users
	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return service.findAll();

	}

	@GetMapping("/users/{id}")
	public EntityModel retrieveUser(@PathVariable int id) {
	
		User user = service.findOne(id);
		if(user==null)
			throw new UserNotFountException("id-"+id);
		
		EntityModel<User> model = new EntityModel<>(user);
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		model.add(linkTo.withRel("all-users"));
		return model;

	}

	@PostMapping("/users")
	//la anotacion valid indica que el request sera validado usando el api de validación de java
	public ResponseEntity<?> createUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
		URI location =ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}")
	//si el metodo es void siempre retorna 200 a menos que exista una exception
	public void deleteUser(@PathVariable int id) {
	
		User user = service.deleteById(id);
		if(user==null)
			throw new UserNotFountException("id-"+id);
		

	}


}
