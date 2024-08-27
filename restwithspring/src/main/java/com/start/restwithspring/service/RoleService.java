package com.start.restwithspring.service;

import com.start.restwithspring.entity.Role;
import com.start.restwithspring.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.header.writers.CacheControlHeadersWriter;

import java.util.List;

public class RoleService {

    @Autowired
    private RoleRepository repository;
    public Role save(Role role){
        return repository.save(role);
    }

    public Role findById(Long id){
        return repository.findById(id).orElse(null);
    }

    public List<Role> findAll(){
        return repository.findAll();
    }

}
