package com.Contact_Manager.contact_manager.Services;

import com.Contact_Manager.contact_manager.entities.User;
import lombok.Data;

import java.util.List;
import java.util.Optional;

public interface UserServices {

    User saveUser(User user);

    Optional<User> getUserById(String id);

    Optional<User> updateUser(User user);

    void deleteUser(String id);

    boolean isUserExist(String EmailId);

    boolean isUserExistByEmailId(String EmailId);

    List<User> getAllUsers();

}
