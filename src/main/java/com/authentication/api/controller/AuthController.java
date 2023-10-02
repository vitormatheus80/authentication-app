package com.authentication.api.controller;

import com.authentication.api.dto.request.UserLoginDTO;
import com.authentication.api.dto.response.TokenDto;
import com.authentication.api.repository.UserRepository;
import com.authentication.api.service.TokenJwtService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/authentication")
@CrossOrigin("*")
@AllArgsConstructor
public class AuthController {

    private  UserDetailsService userDetailsService;
    private TokenJwtService tokenService;
    private  AuthenticationEventPublisher eventPublisher;
    private UserRepository userRepository;


    @PostMapping
    public ResponseEntity<TokenDto> authenticateUser(@RequestBody UserLoginDTO userLoginDTO) {
        try{
            var user = userRepository.findByEmail(userLoginDTO.email());

            if (user == null) {
                throw new BadCredentialsException("email not found");
            }

            final UserDetails userDetails = userDetailsService.loadUserByUsername(userLoginDTO.email());
            var token = tokenService.generateToken(userDetails);
            return ResponseEntity.ok(token);

        } catch (BadCredentialsException e){

            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userLoginDTO.email(), userLoginDTO.password());
            eventPublisher.publishAuthenticationFailure(e, auth);
            throw new BadCredentialsException("E-mail e/ou senha invalido(s).");
        }
    }

    @GetMapping("/check-token")
    public String checkToken(){
        return "Token JWT autenticado com sucesso!";
    }
}
