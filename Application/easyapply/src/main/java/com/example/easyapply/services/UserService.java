package com.example.easyapply.services;

import com.example.easyapply.entities.UserDetailsEntity;
import com.example.easyapply.models.UserModel;
import com.example.easyapply.repositories.UserRepository;
import com.example.easyapply.utilities.ApplicationLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    /**
     * Create user for the given user model
     * @param user
     * @return
     */
    public Optional<Integer> createUser(@NonNull UserModel user){
        if (user != null) {
            UserDetailsEntity userDetailsEntity = new UserDetailsEntity();
            userDetailsEntity.setEmail(user.getEmail());
            userDetailsEntity.setUsername(user.getUsername().toLowerCase());
            userDetailsEntity.setPassword(encoder.encode(user.getPassword()));
            try {
                userDetailsEntity = userRepository.save(userDetailsEntity);
                return Optional.ofNullable(userDetailsEntity.getUserId());
            } catch (Exception ex) {
                ApplicationLogger.getInstance().logException(ex);
            }
        }

        return Optional.ofNullable(null);
    }

    /**
     * Returns a user model with matching user id
     * @param userId
     * @return
     */
    public Optional<UserModel> getUser(int userId){
        Optional<UserDetailsEntity> userDetailsEntity = userRepository.findById(userId);

        if(userDetailsEntity.isPresent()){
            UserModel userModel = new UserModel();
            userModel.setEmail(userDetailsEntity.get().getEmail());
            userModel.setUsername(userDetailsEntity.get().getUsername());
            userModel.setUserId(userDetailsEntity.get().getUserId());
            userModel.setLastLogin(userDetailsEntity.get().getLastLogin());
            return Optional.of(userModel);
        }

        return Optional.ofNullable(null);
    }

    /**
     * Checks if user credentials are valid and returns user id, if valid
     * @param userModel
     * @return
     */
    public Optional<Integer> loginUser(UserModel userModel){
        Optional<UserDetailsEntity> userDetailsEntity =
                userRepository.findUserByUserName(userModel.getUsername().toLowerCase());

        if(userDetailsEntity.isPresent()){
            if (encoder.matches(userModel.getPassword(), userDetailsEntity.get().getPassword())) {
                return Optional.ofNullable(userDetailsEntity.get().getUserId());
            }
        }

        return Optional.ofNullable(null);
    }
}
