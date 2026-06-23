package com.task2.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task2.entity.Contacts;
import com.task2.repository.ContactRepository;
import com.task2.service.ContactFormService;

@Service
public class ContactFormServiceImpl implements ContactFormService {
    
    @Autowired
    private ContactRepository contactRepository;
    
    @Override
    public Contacts saveContacts(Contacts contact) {
        return contactRepository.save(contact);
    }
    
    @Override
    public List<Contacts> getAllContacts() {
        return contactRepository.findAll();
    }
}