package com.iks.rro.springhibernate.person.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.iks.rro.springhibernate.person.entity.Person;
import com.iks.rro.springhibernate.person.service.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonService personService;
			
	@GetMapping("/search")
	public String searchPersons(@RequestParam("theSearchName") String theSearchName,
									Model theModel) {
	
		List<Person> persons = personService.searchPersons(theSearchName);
				
		theModel.addAttribute("persons", persons);
		return "list-persons";		
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Person person = new Person();
		theModel.addAttribute("person", person);
		return "person-form";
	}
		
	@PostMapping("/savePerson")
	public String savePerson(@ModelAttribute("person") Person person) {
		personService.savePerson(person);
		return "redirect:/person/search?theSearchName=";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("personId") int id, Model theModel) {
		Person person = personService.getPerson(id);
		theModel.addAttribute("person", person);
		return "person-form";
	}
	
	@GetMapping("/delete")
	public String deletePerson(@RequestParam("personId") int id) {
		personService.deletePerson(id);
		return "redirect:/person/search?theSearchName=";
	}
	
}
