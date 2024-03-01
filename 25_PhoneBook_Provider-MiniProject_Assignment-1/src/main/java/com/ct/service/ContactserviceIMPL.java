package com.ct.service;

import java.util.List;
import java.util.Optional;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.ct.entity.Contact;
import com.ct.exception.ResourceNotFoundException;
import com.ct.repository.PhonebookRepository;

@Service
public class ContactserviceIMPL implements ContactService {

	private PhonebookRepository pbr;

	public ContactserviceIMPL(PhonebookRepository pbr) {
		super();
		this.pbr = pbr;
	}

	// contact created
	@Override
	public Contact saveContact(Contact contact) {

		return pbr.save(contact);
	}

	@Override
	public List<Contact> getAllContact() {

		return pbr.findAll();
	}

	@Override
	public Contact updateContact(Contact contact, Integer id) {

		Contact existingContact = pbr.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Contact", "id", id));

		// existingContact.setId(contact.getId());
		existingContact.setFirstName(contact.getFirstName());
		existingContact.setLastName(contact.getLastName());
		existingContact.setAdds(contact.getAdds());
		existingContact.setEmail(contact.getEmail());
		existingContact.setNumber(contact.getNumber());

		pbr.save(existingContact);

		System.out.println(existingContact);
		return existingContact;
	}

	@Override
	public void deleteContact(Integer id) {

		pbr.findById(id).orElseThrow(() -> new ResourceNotFoundException("Contact", "id", id));
		pbr.deleteById(id);

	}

	@Override
	public Contact getContactById(Integer id) {
		// TODO Auto-generated method stub
		return pbr.findById(id).orElseThrow(() -> new ResourceNotFoundException("Contact", "id", id));
	}

}
