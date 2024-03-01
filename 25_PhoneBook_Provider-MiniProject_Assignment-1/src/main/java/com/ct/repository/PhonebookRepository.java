package com.ct.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ct.entity.Contact;

public interface PhonebookRepository extends JpaRepository<Contact, Integer> {

}
