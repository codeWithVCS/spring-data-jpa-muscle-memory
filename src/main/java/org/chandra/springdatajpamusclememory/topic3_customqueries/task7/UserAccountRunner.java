package org.chandra.springdatajpamusclememory.topic3_customqueries.task7;

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
        userAccountRepository.save(new UserAccount("Chandra", "chandra@corp.com", "ADMIN", true));
        userAccountRepository.save(new UserAccount("Daniel", "daniel@corp.com", "USER", true));
        userAccountRepository.save(new UserAccount("Asha", "asha@corp.com", "USER", true));
        userAccountRepository.save(new UserAccount("Ravi", "ravi@corp.com", "MANAGER", true));
        userAccountRepository.save(new UserAccount("Neha", "neha@corp.com", "USER", false));
        userAccountRepository.save(new UserAccount("Vikas", "vikas@corp.com", "HR", true));
        userAccountRepository.save(new UserAccount("Divya", "divya@corp.com", "USER", true));

        System.out.println("Updating role of 'Daniel' to 'MANAGER'...");
        System.out.println("Rows effected: " + userAccountRepository.updateUserRoleByUsername("Daniel", "MANAGER"));
        System.out.println();
        System.out.println("Deactivating all users with role 'USER'...");
        System.out.println("Rows effected: " + userAccountRepository.updateUserActiveByUserRole("USER"));
        System.out.println();
        System.out.println("Deleting all inactive users...");
        System.out.println("Rows effected: " + userAccountRepository.deleteInactiveUsers());
        System.out.println();
        System.out.println("Remaining users: ");
        userAccountRepository.findAll().forEach(System.out::println);
    }
}
