package com.ct.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ct.entity.Contact;
import com.ct.service.ContactService;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

	private ContactService service;

	public ContactController(ContactService service) {
		super();
		this.service = service;
	}

	@PostMapping( consumes = { "application/json" }, produces = { "application/json" })
	public ResponseEntity<Contact> saveContact(@RequestBody Contact contact) {

		return new ResponseEntity<Contact>(service.saveContact(contact), HttpStatus.CREATED);

	}

	@GetMapping(  consumes = { "application/json" },produces = {"application/json"})
	public List<Contact> getAllContact() {

		return service.getAllContact();
	}

	@GetMapping(value="/{id}",consumes = { "application/json" }, produces = {"application/json"})
	public ResponseEntity<Contact> getContactById(@PathVariable("id") Integer id) {

		return new ResponseEntity<Contact>(service.getContactById(id), HttpStatus.OK);
	}

	@PutMapping(value="/{id}",consumes = { "application/json" }, produces = {"application/json"})
	public ResponseEntity<Contact> updateContact(@PathVariable("id") Integer id, @RequestBody Contact contact) {

		return new ResponseEntity<Contact>(service.updateContact(contact, id), HttpStatus.OK);
	}

	@DeleteMapping(value="/{id}",consumes = { "application/json" }, produces = {"application/json"})
	public ResponseEntity<String> deleteContact(@PathVariable("id") Integer id) {

		service.deleteContact(id);
		return new ResponseEntity<String>("Contact deleted from DB....!", HttpStatus.OK);
	}

}
