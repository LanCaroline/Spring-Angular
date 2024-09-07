package com.sa.sweeterassociation.repository;

import com.sa.sweeterassociation.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    public void save(User user){
        if(user.getId() == null){
            System.out.println("SAVE - Recebendo o usuário na camada de repository");

        }else {
            System.out.println("UPDATE - Recebendo o usuário na camada de repository");
        }

        System.out.println(user);
    }

    public void deleteById(Integer id){
        System.out.println(String.format("DELETE/id - Recebendo o id: %d para repository", id));
        System.out.println(id);
    }

    public List<User> findAll(){
        System.out.println("LIST - Listando os usuários do sistema");
        List<User> users = new ArrayList<>();
        users.add(new User("someone", "password"));
        users.add(new User("frank", "frankpass"));
        return users;
    }

    public User findById(Integer id){
        System.out.println(String.format("FIND/username - Recebendo o username", id));
        return new User("someone", "password");
    }

    public User findByUsername(String username){
        System.out.println(String.format("FIND/username - Recebendo o username: %s para localizar um usuário", username));
        return new User("frank", "frankpass");
    }
}
