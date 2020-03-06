package com.iks.rro.springhibernate.person.dao;

import java.util.List;

import com.iks.rro.springhibernate.person.entity.Person;


public interface PersonDAO {
	
	public List<Person> getPersons(); 

	public void createPerson(Person person);

	public void deletePerson(int id);

	public Person getPerson(int id);

	public List<Person> searchPersons(String theSearchName);

}
