package com.agenda.contactlist.repository;

import com.agenda.contactlist.entity.Contacts;
import org.assertj.core.util.Arrays;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContactsRepository extends CrudRepository<Contacts,Integer> {


}
