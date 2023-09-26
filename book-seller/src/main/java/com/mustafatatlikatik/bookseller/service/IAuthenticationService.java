package com.mustafatatlikatik.bookseller.service;

import com.mustafatatlikatik.bookseller.model.User;

public interface IAuthenticationService {

    User signInAndReturnJwt(User signInRequest);
}
