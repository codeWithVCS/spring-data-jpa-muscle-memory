package org.chandra.springdatajpamusclememory.topic4_relationships.task2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserDataRunner implements CommandLineRunner {

    private final UserRepository userRepository;
    private final UserProfileRepository userProfileRepository;

    @Autowired
    public UserDataRunner(UserRepository userRepository, UserProfileRepository userProfileRepository) {
        this.userRepository = userRepository;
        this.userProfileRepository = userProfileRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User("chandra", "chandra@corp.com");
        User u2 = new User("daniel", "daniel@corp.com");
        User u3 = new User("asha", "asha@corp.com");

        UserProfile up1 = new UserProfile("Chandra Sekhar", "9876543210", "Hyderabad");
        UserProfile up2 = new UserProfile("Daniel Victor", "9123456789", "Chennai");
        UserProfile up3 = new UserProfile("Asha Rao", "9988776655", "Bangalore");

        userProfileRepository.save(up1);
        userProfileRepository.save(up2);
        userProfileRepository.save(up3);

        u1.setUserProfile(up1);
        u2.setUserProfile(up2);
        u3.setUserProfile(up3);

        userRepository.save(u1);
        userRepository.save(u2);
        userRepository.save(u3);

        System.out.println("Users: ");
        userRepository.findAll().forEach(System.out::println);
    }
}
