package com.iks.rro.springhibernate.person.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iks.rro.springhibernate.person.entity.Person;

@Repository
public class PersonDAOImpl implements PersonDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public List<Person> getPersons() {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Person> query = currentSession.createQuery("FROM Person ORDER BY lastname", Person.class);

		List<Person> persons = query.getResultList();
		return persons;
	}

	@Transactional
	public List<Person> searchPersons(String theSearchName) {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Person> query = null;
		query = currentSession.createQuery(
				"FROM Person WHERE LOWER(firstname) LIKE :theName OR LOWER(lastname) LIKE :theName ORDER BY lastname",
				Person.class);
		query.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

		List<Person> persons = query.getResultList();
		return persons;
	}
	
	@Transactional
	public void createPerson(Person person) {
		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(person);
	}

	@Transactional
	public void deletePerson(int id) {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<?> query = currentSession.createQuery("DELETE FROM Person WHERE id = :personId");
		query.setParameter("personId", id);
		query.executeUpdate();
	}

	@Transactional
	public Person getPerson(int id) {
		Session currentSession = sessionFactory.getCurrentSession();

		Person person = currentSession.get(Person.class, id);
		return person;
	}

}
