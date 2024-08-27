package com.agenda.contactlist;

import com.agenda.contactlist.entity.Contacts;
import com.agenda.contactlist.repository.ContactsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ContactlistApplication {

	public static void main(String[] args) {SpringApplication.run(ContactlistApplication.class, args);}


    @Bean
	CommandLineRunner runner(ContactsRepository contactsRepository) {

		return (String...args) -> {
				List<Contacts> contacts = Arrays.asList(
						new Contacts("Dante","Perez","3515481744" ,"Dante@gmail.com", LocalDateTime.now()),
						new Contacts("Carlos","Rojas","345567890", "carlos@gmail.com", LocalDateTime.now()),
						new Contacts("Pedro","Pereyra","342245670","pedro@gmail.com", LocalDateTime.now()),
						new Contacts("Alicia","Schmit","456334290", "alicia@gmail.com", LocalDateTime.now()),
						new Contacts("Ester","Castelar","2998657430", "ester@gmail.com", LocalDateTime.now())
				);
				contactsRepository.saveAll(contacts);

		};
	}

}
