package com.iks.rro.springhibernate.person.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iks.rro.springhibernate.person.dao.PersonDAO;
import com.iks.rro.springhibernate.person.entity.Person;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonDAO personDAO;

	public List<Person> getPersons() {
		return personDAO.getPersons();
	}

	public void savePerson(Person person) {
		personDAO.createPerson(person);		
	}

	public Person getPerson(int id) {
		return personDAO.getPerson(id);
	}

	public void deletePerson(int id) {
		personDAO.deletePerson(id);		
	}

	public List<Person> searchPersons(String theSearchName) {
		return personDAO.searchPersons(theSearchName);
	}
}
