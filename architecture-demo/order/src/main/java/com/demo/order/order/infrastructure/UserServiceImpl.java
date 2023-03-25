package com.demo.order.order.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.order.order.domain.Role;
import com.demo.order.order.domain.User;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepo;
    @Autowired
    private final PasswordEncoder pwdEncoder;

    @Override
    public User createUser(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(pwdEncoder.encode(password));
        user.setRole(Role.STANDARD);
        return userRepo.save(user);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepo.findUserByEmail(email).orElseThrow(() -> new RuntimeException("User not found."));
    }
}
