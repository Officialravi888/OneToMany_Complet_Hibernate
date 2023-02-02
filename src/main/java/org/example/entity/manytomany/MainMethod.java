package org.example.entity.manytomany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainMethod implements CommandLineRunner {
    @Autowired
    private PersonRepository personRepository;
    public static void main(String[] args) {
        SpringApplication.run(MainMethod.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        Person person = new Person("Hibernate Many to Many", "Hibernate Many to Many", "Hibernate Many to Many");
        Tag springBoot= new Tag("Spring Boot");
        Tag hibernate= new Tag("Hibernate");

        person.getTags().add(springBoot);
        person.getTags().add(hibernate);
        springBoot.getPersons().add(person);
        hibernate.getPersons().add(person);
        this.personRepository.save(person);
    }
}
