package com.task2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task2.entity.Contacts;

public interface ContactRepository extends JpaRepository<Contacts, Long> {

}
