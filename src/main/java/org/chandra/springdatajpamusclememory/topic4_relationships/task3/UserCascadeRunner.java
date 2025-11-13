package org.chandra.springdatajpamusclememory.topic4_relationships.task3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserCascadeRunner implements CommandLineRunner {

    private final UserRepository userRepository;
    private final UserProfileRepository userProfileRepository;

    @Autowired
    public UserCascadeRunner(UserRepository userRepository, UserProfileRepository userProfileRepository) {
        this.userRepository = userRepository;
        this.userProfileRepository = userProfileRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        User u1 = new User("chandra", "chandra@corp.com");
        u1.setUserProfile(new UserProfile("Chandra Sekhar", "9876543210", "Hyderabad"));

        User u2 = new User("daniel", "daniel@corp.com");
        u2.setUserProfile(new UserProfile("Daniel Victor", "9123456789", "Chennai"));

        User u3 = new User("asha", "asha@corp.com");
        u3.setUserProfile(new UserProfile("Asha Rao", "9988776655", "Bangalore"));

        userRepository.save(u1);
        userRepository.save(u2);
        userRepository.save(u3);

        System.out.println("Users: ");
        userRepository.findAll().forEach(System.out::println);

    }
}
