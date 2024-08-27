package com.start.restwithspring;

import com.start.restwithspring.entity.Role;
import com.start.restwithspring.entity.User;
import com.start.restwithspring.service.RoleService;
import com.start.restwithspring.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

public class Initializer {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @PostConstruct
    public void criaUsuariosEPermissoes() {
        Role roleAdmin = new Role();

        roleAdmin.setName("USER");

        roleService.save(roleAdmin);

        User user = new User();
        user.setActive(true);
        user.setEmail("teste@teste.com");
        user.setName("Kaique Arantes");
        user.setPassword(new BCryptPasswordEncoder().encode("123456"));
        user.setUsername("karantes");
        user.setRoles(Arrays.asList(roleAdmin));

        userService.save(user);

    }
}
