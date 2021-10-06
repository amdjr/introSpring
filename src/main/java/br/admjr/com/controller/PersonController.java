package br.admjr.com.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.admjr.com.model.Person;
import br.admjr.com.service.PersonService;

@RestController
@RequestMapping("/person")

public class PersonController {

	@Autowired
	private PersonService personService;

	@GetMapping
	public List<Person> findAll() {
		return personService.findAll();
	}

	@GetMapping("/{name}")
	public Person findOne(@PathVariable String name) {
		return personService.findOne(name);
	}

	@PostMapping
	public Map<String, String> insert(@RequestBody Person person) {
		return personService.insert(person);
	}

	@PutMapping
	public Map<String, String> edit(@RequestBody Person person) {
		return personService.edit(person);
	}

	@DeleteMapping("/{name}")
	public Map<String, String> remove(@PathVariable String name) {
		return personService.remove(name);
	}

}
