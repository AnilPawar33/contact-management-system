package com.task2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.task2.entity.Contacts;
import com.task2.service.ContactFormService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ContactController {

    @Autowired
    private ContactFormService service;

    // Public - Contact Form Submission
    @PostMapping("/contacts")
    public ResponseEntity<Contacts> saveContact(
            @RequestBody Contacts contacts) {

        Contacts savedContact = service.saveContacts(contacts);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedContact);
    }

    // ADMIN Only - View All Contacts
    @GetMapping("/contacts")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Contacts>> getAllContacts() {

        List<Contacts> contacts = service.getAllContacts();

        return ResponseEntity.ok(contacts);
    }
}