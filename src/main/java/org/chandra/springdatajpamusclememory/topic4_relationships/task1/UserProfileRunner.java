package org.chandra.springdatajpamusclememory.topic4_relationships.task1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserProfileRunner implements CommandLineRunner {

    private final UserProfileRepository userProfileRepository;
    private final AddressRepository addressRepository;

    @Autowired
    public UserProfileRunner(UserProfileRepository userProfileRepository, AddressRepository addressRepository) {
        this.userProfileRepository = userProfileRepository;
        this.addressRepository = addressRepository;
    }
    @Override
    public void run(String... args) throws Exception {

        UserProfile u1 = new UserProfile("Chandra", "chandra@corp.com");
        u1.setAddress(new Address("Street 1", "Hyderabad", "500001"));

        UserProfile u2 = new UserProfile("Daniel", "daniel@corp.com");
        u2.setAddress(new Address("Street 2", "Chennai", "600001"));

        UserProfile u3 = new UserProfile("Asha", "asha@corp.com");
        u3.setAddress(new Address("Street 3", "Bangalore", "560001"));

        userProfileRepository.save(u1);
        userProfileRepository.save(u2);
        userProfileRepository.save(u3);

        System.out.println("User Profiles: ");
        userProfileRepository.findAll().forEach(System.out::println);

    }
}
