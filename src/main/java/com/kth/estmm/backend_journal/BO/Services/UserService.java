package com.kth.estmm.backend_journal.BO.Services;

import com.kth.estmm.backend_journal.BO.User;
import com.kth.estmm.backend_journal.Persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();

    }

    public boolean addUser(String name, String email, String password) {
        User newUser = new User(name, email, password);
        userRepository.save(newUser);
        return true;
    }


}
