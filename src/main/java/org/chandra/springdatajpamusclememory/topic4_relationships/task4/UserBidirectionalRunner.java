package org.chandra.springdatajpamusclememory.topic4_relationships.task4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserBidirectionalRunner implements CommandLineRunner {

    private final UserRepository userRepository;
    private final UserProfileRepository userProfileRepository;

    @Autowired
    public UserBidirectionalRunner(UserRepository userRepository, UserProfileRepository userProfileRepository) {
        this.userRepository = userRepository;
        this.userProfileRepository = userProfileRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User("chandra", "chandra@corp.com");
        UserProfile up1 = new UserProfile("Chandra Sekhar", "9876543210", "Hyderabad");

        User u2 = new User("daniel", "daniel@corp.com");
        UserProfile up2 = new UserProfile("Daniel Victor", "9123456789", "Chennai");

        User u3 = new User("asha", "asha@corp.com");
        UserProfile up3 = new UserProfile("Asha Rao", "9988776655", "Bangalore");

        u1.setUserProfile(up1);
        u2.setUserProfile(up2);
        u3.setUserProfile(up3);

        up1.setUser(u1);
        up2.setUser(u2);
        up3.setUser(u3);

        userRepository.save(u1);
        userRepository.save(u2);
        userRepository.save(u3);

        System.out.println("Users: ");
        userRepository.findAll().forEach(System.out::println);
        System.out.println();
        System.out.println("UserProfiles: ");
        userProfileRepository.findAll().forEach(System.out::println);
    }
}
