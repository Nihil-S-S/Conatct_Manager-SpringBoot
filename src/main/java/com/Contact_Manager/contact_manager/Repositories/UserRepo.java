package com.Contact_Manager.contact_manager.Repositories;

import com.Contact_Manager.contact_manager.entities.User;
import lombok.Data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

    Optional<User> findByEmail(String email);
}
