package com.example.slms.Database;

import com.example.slms.Entity.User;
import com.example.slms.Repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UserRepository repository) {

        return args -> {
//            log.info("Preloading " + repository.save(new User("Bilbo", "burglar")));
//            log.info("Preloading " + repository.save(new Login("Frodo", "thief")));
        };
    }
}
