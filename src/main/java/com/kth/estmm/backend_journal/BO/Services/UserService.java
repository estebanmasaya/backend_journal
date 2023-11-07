package com.kth.estmm.backend_journal.BO.Services;

import com.kth.estmm.backend_journal.BO.User;
import com.kth.estmm.backend_journal.Persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public User login(String email, String password) throws LoginException {
        User user = getUserByEmail(email);
        if(user.getPassword().equals(password)){
            return user;
        }
        throw new LoginException("Wrong username or password");
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
