package com.mustafatatlikatik.bookseller.security.jwt;

import com.mustafatatlikatik.bookseller.security.UserPrincipal;
import io.jsonwebtoken.Claims;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

public interface IJwtProvider {
    String generateToken(UserPrincipal auth);

    Authentication getAuthentication(HttpServletRequest request);

    boolean validateToken(HttpServletRequest request);


}
