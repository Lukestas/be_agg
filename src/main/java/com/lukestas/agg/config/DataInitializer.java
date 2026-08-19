package com.lukestas.agg.config;

import com.lukestas.agg.user.model.Role;
import com.lukestas.agg.user.model.User;
import com.lukestas.agg.user.repository.RoleRepository;
import com.lukestas.agg.user.repository.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initData(
            UserRepository userRepository,
            RoleRepository roleRepository,
            PasswordEncoder passwordEncoder) {

        return args -> {

            Role adminRole = roleRepository.findByName("ROLE_ADMIN")
                    .orElseGet(() -> roleRepository.save(
                            new Role("ROLE_ADMIN")));

            if (!userRepository.existsByUsername("admin")) {

                User admin = new User(
                        "admin",
                        passwordEncoder.encode("admin123"));

                admin.getRoles().add(adminRole);

                userRepository.save(admin);
            }
        };
    }
}