package br.admjr.com.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.admjr.com.model.Person;

@Service
public class PersonService {

	private static final String RESULT2 = "result";

	private List<Person> listOfPersons = new ArrayList<>();

	PersonService() {
		listOfPersons.add(new Person("Adilson", "Monteiro", "1983/12/11", "amdj@gmail.com"));

	}

	public List<Person> findAll() {
		return this.listOfPersons;
	}

	public Person findOne(String name) {
		for (Person person : listOfPersons) {
			if (person.getName().equalsIgnoreCase(name)) {
				return person;
			}
		}
		return null;
	}

	public Map<String, String> insert(Person person) {
		Map<String, String> result = new HashMap<>();

		boolean isSucess = listOfPersons.add(person);
		if (isSucess) {
			result.put(RESULT2, "Pessoa cadastrada com sucesso.");
		} else
			result.put(RESULT2, "Erro ao cadastrar pessoa.");

		return result;
	}

	public Map<String, String> edit(Person person) {
		Map<String, String> result = new HashMap<>();
		for (Person element : listOfPersons) {
			if (element.getName().equalsIgnoreCase(person.getName())) {
				int index = listOfPersons.indexOf(element);
				listOfPersons.set(index, person);
				result.put(RESULT2, "Pessoa editada com sucesso.");
				return result;
			}
		}
		result.put(RESULT2, "Não foi possível editar a pessoa.");
		return result;
	}

	public Map<String, String> remove(@PathVariable String name) {
		Map<String, String> result = new HashMap<>();
		boolean isSucess = listOfPersons.removeIf((element) -> element.getName().equalsIgnoreCase(name));
		if (isSucess) {
			result.put(RESULT2, "Pessoa removida com sucesso.");
		} else {
			result.put(RESULT2, "Pessoa não removida, erro.");
			return result;
		}
		return Collections.emptyMap();
	}
}
