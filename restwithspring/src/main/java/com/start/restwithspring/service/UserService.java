package com.start.restwithspring.service;

import com.start.restwithspring.entity.User;
import com.start.restwithspring.jwt.JwtRequest;
import com.start.restwithspring.jwt.JwtTokenUtil;
import com.start.restwithspring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public User save(User user){
        return repository.save(user);
    }

    public User findById(Long id){
        return repository.findById(id).orElse(null);
    }

    public List<User> findAll(){
        return repository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        return repository.findByUsername(username);
    }

    public ResponseEntity<?> signin(JwtRequest authenticationRequest){
        try{
            authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
            final User userDetails = repository.findByUsername(authenticationRequest.getUsername());
            final String token = jwtTokenUtil.generateToken(userDetails);
            return ResponseEntity.ok(token);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.ok(e.getMessage());
        }
    }

    private void authenticate(String username, String password) throws Exception{
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }catch (DisabledException e){
            throw new Exception("USER DISABLED", e);

        }catch (BadCredentialsException e){
            throw new Exception("INVALID CREDENTIALS", e);
        }
    }

}
