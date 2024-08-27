package com.agenda.contactlist.controller;

import com.agenda.contactlist.entity.Contacts;
import com.agenda.contactlist.exception.ResourceNotFoundException;
import com.agenda.contactlist.repository.ContactsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
@CrossOrigin
@RequestMapping("/api/contacts")
@RestController
public class ContactsController {
    @Autowired
    private ContactsRepository contactsRepository;
    @GetMapping
    Iterable<Contacts> list(){
        return contactsRepository.findAll();
    }

    @GetMapping("{id}")
    public Contacts get(@PathVariable Integer id){
        final Object o = null;
        return contactsRepository
                .findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Contacts create(@Validated @RequestBody Contacts contacts){

        contacts.setCreatedAt(LocalDateTime.now());
        return contactsRepository.save(contacts);

    }

    @PutMapping("{id}")
    public Contacts update(@Validated
                           @PathVariable Integer id,
                           @RequestBody Contacts form
                           ){
        Contacts contactFromDb=contactsRepository
                .findById(id)
                .orElseThrow(ResourceNotFoundException::new);
        contactFromDb.setName(form.getName());
        contactFromDb.setEmail(form.getEmail());

        return contactsRepository.save(contactFromDb);

    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        Contacts contactFromDb=contactsRepository
                .findById(id)
                .orElseThrow(ResourceNotFoundException::new);
        contactsRepository.delete(contactFromDb);

    }


}
