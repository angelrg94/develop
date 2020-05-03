package com.example.springrestfulwebservices.user;

import com.example.springrestfulwebservices.user.exception.UserNotFountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class UserJPAResource {

	@Autowired
	UserDaoService service;

	@Autowired
	UserRepository repository;
	@Autowired
	PostRepository postRepository;
	// GET /users
	// Retrieve all users
	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers() {
		return repository.findAll();

	}

	@GetMapping("/jpa/users/{id}")
	public Resource retrieveUser(@PathVariable int id) {
	
		Optional<User> user = repository.findById(id);
		if(!user.isPresent())
			throw new UserNotFountException("id-"+id);
		
		Resource<User> resource = new Resource<User>(user.get());
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		resource.add(linkTo.withRel("all-users"));
		return resource;

	}

	@PostMapping("/jpa/users")
	//la anotacion valid indica que el request sera validado usando el api de validación de java
	public ResponseEntity<?> createUser(@Valid @RequestBody User user) {
		User savedUser = repository.save(user);
		URI location =ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/jpa/users/{id}")
	//si el metodo es void siempre retorna 200 a menos que exista una exception
	public void deleteUser(@PathVariable int id) {
		 repository.deleteById(id);
	}

	@GetMapping("/jpa/users/{id}/post")
	public List<Post> retreieveAllUser(@PathVariable int id)
	{
		Optional<User> user = repository.findById(id);
		if(!user.isPresent())
		{
			throw new UserNotFountException("id-" + id);
		}

	return user.get().getPost();
	}

	@PostMapping("/jpa/users/{id}/post")
	//la anotacion valid indica que el request sera validado usando el api de validación de java
	public ResponseEntity<Object> createPost(@PathVariable int id, @RequestBody Post post) {

		Optional<User> userOptional = repository.findById(id);
		if(!userOptional.isPresent())
		{
			throw new UserNotFountException("id-" + id);
		}

		User user= userOptional.get();
		post.setUser(user);
		postRepository.save(post);

		URI location =ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId()).toUri();

		return ResponseEntity.created(location).build();
	}
}
