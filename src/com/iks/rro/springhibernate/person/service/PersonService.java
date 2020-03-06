package com.iks.rro.springhibernate.person.service;

import java.util.List;

import com.iks.rro.springhibernate.person.entity.Person;

public interface PersonService {
	
	public List<Person> getPersons();

	public void savePerson(Person person);

	public Person getPerson(int id);

	public void deletePerson(int id);

	public List<Person> searchPersons(String theSearchName);
	
}
