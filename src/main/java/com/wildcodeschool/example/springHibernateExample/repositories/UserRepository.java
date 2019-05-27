package com.wildcodeschool.example.springHibernateExample.repositories;

import com.wildcodeschool.example.springHibernateExample.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
}
