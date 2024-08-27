package com.start.restwithspring.repository;

import com.start.restwithspring.entity.User;
import org.hibernate.query.criteria.JpaCollectionJoin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);



}
