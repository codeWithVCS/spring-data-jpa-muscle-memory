package org.chandra.springdatajpamusclememory.topic2_entitymapping.task1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BookDataRunner implements CommandLineRunner {
    private final BookRepository bookRepository;
    @Autowired
    public BookDataRunner(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        Book b1= new Book("Java Fundamentals", "John Doe", 599.0);
        Book b2 = new Book("Spring in Action", "Craig Walls", 799.0);
        Book b3 = new Book("Hibernate Mastery","Gavin King", 699.0);

        bookRepository.save(b1);
        bookRepository.save(b2);
        bookRepository.save(b3);

        bookRepository.findAll().forEach(System.out::println);
    }
}
