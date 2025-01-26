package com.Contact_Manager.contact_manager.ServicesImpl;

import com.Contact_Manager.contact_manager.Helpers.AppConstants;
import com.Contact_Manager.contact_manager.Helpers.ResourceNotFoundException;
import com.Contact_Manager.contact_manager.Repositories.UserRepo;
import com.Contact_Manager.contact_manager.Services.UserServices;
import com.Contact_Manager.contact_manager.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.beans.BeanUtils.copyProperties;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Service
public class UserServicesImp implements UserServices {


    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public User saveUser(User user) {
        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        user.setRoleList(List.of(AppConstants.ROLE_USER));
        return userRepo.save(user);
    }

    @Override
    public Optional<User> getUserById(String id) {
        return userRepo.findById(id);
    }

    @Override
    public Optional<User> updateUser(User user) {
        User user1 = userRepo.findById(user.getUserId()).orElseThrow(() -> new ResourceNotFoundException("user not found"));
//        user1.setName(user.getName());
//        user1.setEmail(user.getEmail());
//        user1.setPassword(user.getPassword());
//        user1.setPhoneNumber(user.getPhoneNumber());
//        user1.setAbout(user.getAbout());
//        user1.setProfilePic(user.getProfilePic());
//        user1.setEnabled(user.isEnabled());
//        user1.setEmailVerified(user.isEmailVerified());
//        user1.setPhoneVerified(user.isPhoneVerified());
//        user1.setProvider(user.getProvider());
//        user1.setProviderId(user.getProviderId());
        // Copy properties from user to user1, ignoring null values
        copyProperties(user, user1, "userId");
        User save = userRepo.save(user1);
        return Optional.ofNullable(save);
    }

    @Override
    public void deleteUser(String id) {
        User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("user not found"));
        userRepo.delete(user);

    }

    @Override
    public boolean isUserExist(String EmailId) {
        User user = userRepo.findById(EmailId).orElse(null);
        return user != null;
    }

    @Override
    public boolean isUserExistByEmailId(String EmailId) {
        User user = userRepo.findByEmail(EmailId).orElse(null);
        return user != null;
    }
    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}
