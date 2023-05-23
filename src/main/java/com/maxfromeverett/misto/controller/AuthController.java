package com.maxfromeverett.misto.controller;

import com.maxfromeverett.misto.entity.User;
import com.maxfromeverett.misto.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/auth")
public class AuthController {
  @Autowired
  private UserRepository repository;

  @Autowired
  AuthenticationManager authenticationManager;

  @PostMapping("/signup")
  public ResponseEntity<?> signup(@RequestBody SignupRequest request_) {
    User user = new User();
    user.setEmail(request_.getEmail());
    user.setPassword(request_.getPassword());
    repository.save(user);

    return new ResponseEntity<>(user, HttpStatus.OK);
  }


  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody LoginRequest request_) throws Exception {
    Authentication authentication;
    try {
      //String encodedPassword = (new BCryptPasswordEncoder()).encode(loginRequest.getPassword());
      authentication = authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(request_.getEmail(), request_.getPassword()));
    } catch (org.springframework.security.authentication.BadCredentialsException e) {
      throw new Exception("Nevernoe_imja_polzovatelja_ili_parol");
    }
    SecurityContextHolder.getContext().setAuthentication(authentication);
    //UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    User loggedUser_ = (User) authentication.getPrincipal();

    String access_token_ = jwtUtils.generateTokenFromUserId(logged_c_usr_.getC_usr());
    return new ResponseEntity<>(loggedUser_, HttpStatus.OK);
  }

}
