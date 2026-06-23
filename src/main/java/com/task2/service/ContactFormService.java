package com.task2.service;

import java.util.List;

import com.task2.entity.Contacts;

public interface ContactFormService {
	
	Contacts saveContacts(Contacts contact);
	
	List<Contacts> getAllContacts();
	

}