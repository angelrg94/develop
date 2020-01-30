package com.example.springrestfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonResource {
	
	
	/* URI Versioning */
	@GetMapping("/v1/person")
	public PersonV1 retrievePersonV1() {
		return new PersonV1("Angel");
	}
	@GetMapping("/v2/person")
	public PersonV2 retrievePersonV2() {
		return new PersonV2(new Name("Angel","Gonzalez"));
	}
	
	/*Request Param versioning*/
	@GetMapping(value="person/param",params="version=1")
	public PersonV1 paramV1() {
		return new PersonV1("Angel");
	}
	@GetMapping(value="person/param",params="version=2")
	public PersonV2 paramV2() {
		return new PersonV2(new Name("Angel","Gonzalez"));
	}
}
