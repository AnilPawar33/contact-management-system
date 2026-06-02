package com.task2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.task2.entity.Contacts;
import com.task2.repository.ContactRepository;
import com.task2.service.ContactFormService;

@CrossOrigin(origins = "*")
@RestController
public class ContactController {
	
	@Autowired
	private ContactFormService service;
	
	@PostMapping("/api/contacts")
	public Contacts saveContact( @RequestBody Contacts contacts) {
		return service.saveContacts(contacts);
	}
	
	@GetMapping("/api/contacts")
	public List<Contacts> findAllContacts() {
		return service.getAllContacts();

	}

}
