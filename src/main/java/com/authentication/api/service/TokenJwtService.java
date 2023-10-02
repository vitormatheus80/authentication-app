package com.authentication.api.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.authentication.api.dto.response.TokenDto;
import com.authentication.api.model.User;
import com.authentication.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenJwtService {

    @Value("${jwt.secret.token}")
    private String secretKey;

    @Autowired
    private UserRepository userRepository;

    public TokenDto generateToken(UserDetails usuario) {

        User userDetails = userRepository.findByEmail(usuario.getUsername());

        var jwt = JWT.create()
                .withSubject(usuario.getUsername())
                .withClaim("id", userDetails.getId())
                .withExpiresAt(LocalDateTime.now().plusHours(8).toInstant(ZoneOffset.of("-03:00")))
                .sign(Algorithm.HMAC256(secretKey));
        TokenDto jwtAuthenticationResponse = new TokenDto(jwt, "Autenticação feita com sucesso!");
        return jwtAuthenticationResponse;
    }

    public String getSubject(String token) {

        return JWT.require(Algorithm.HMAC256(secretKey))
                .build().verify(token).getSubject();
    }

}
