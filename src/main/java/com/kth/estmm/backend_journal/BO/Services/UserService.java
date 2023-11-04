package com.kth.estmm.backend_journal.BO.Services;

import com.kth.estmm.backend_journal.BO.Encounter;
import com.kth.estmm.backend_journal.BO.Role;
import com.kth.estmm.backend_journal.BO.User;
import com.kth.estmm.backend_journal.Persistence.EncounterRepository;
import com.kth.estmm.backend_journal.Persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();

    }

    public boolean addUser(String name, String email, String password, Role role) {
        User newUser = new User(name, email, password, role);
        userRepository.save(newUser);
        return true;
    }


}
