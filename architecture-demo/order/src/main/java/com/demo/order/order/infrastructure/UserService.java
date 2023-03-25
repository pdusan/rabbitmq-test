package com.demo.order.order.infrastructure;

import com.demo.order.order.domain.User;

public interface UserService {
    User createUser(String email, String password);

    User getUserByEmail(String email);
}
