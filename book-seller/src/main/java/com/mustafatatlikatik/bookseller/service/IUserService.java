package com.mustafatatlikatik.bookseller.service;


import com.mustafatatlikatik.bookseller.model.User;

import java.util.Optional;

public interface IUserService {
    User saveUser(User user);

    Optional<User> findByUsername(String username);

    void makeAdmin(String userName);
}
