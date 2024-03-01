package com.ct.service;

import java.util.List;

import com.ct.entity.Contact;

public interface ContactService {

	Contact saveContact(Contact contact);

	List<Contact> getAllContact();

	Contact getContactById(Integer id);

	Contact updateContact(Contact contact, Integer id);

	void deleteContact(Integer id);
}
