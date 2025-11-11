package org.chandra.springdatajpamusclememory.topic2_entitymapping.task2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserAccountRunner implements CommandLineRunner {
    private final UserAccountRepository userAccountRepository;
    @Autowired
    public UserAccountRunner(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        UserAccount ua1 = new UserAccount("A","A@company.com","ADMIN");
        UserAccount ua2 = new UserAccount("B", "B@company.com", "USER");
        UserAccount ua3 = new UserAccount("C","C@company.com", "MODERATOR");

        userAccountRepository.save(ua1);
        userAccountRepository.save(ua2);
        userAccountRepository.save(ua3);

        userAccountRepository.findAll().forEach(System.out::println);
    }
}
