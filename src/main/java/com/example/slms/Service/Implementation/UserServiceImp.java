package com.example.slms.Service.Implementation;

import com.example.slms.Entity.User;
import com.example.slms.Entity.UserDetailsProjection;
import com.example.slms.Exceptions.CustomException;
import com.example.slms.Repository.UserRepository;
import com.example.slms.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new CustomException(400, "User not found"));
    }

    public UserDetailsProjection getUserDetails(long id) {
        Optional<UserDetailsProjection> optionalUser = userRepository.findUserDetails(id);
        if(optionalUser.isPresent()){
            return optionalUser.get();
        }else{
            throw new CustomException(400, "User not found");
        }
    }

    public User findByUsername(String username){
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if(optionalUser.isPresent()){
            return optionalUser.get();
        }else{
            throw new CustomException(400, "User not found");
        }
    }

    public User createUser(User user) {
        Optional<User> optionalUser = userRepository.findByUsername(user.getUsername());
        if (optionalUser.isPresent()){
            throw new CustomException(400, "User already exists");
        }else
            return userRepository.save(user);
    }

    public boolean deleteUser(long id, User user) {
        Optional<User> loginOptional = userRepository.findById(id);
        if(loginOptional.isPresent()){
            if(loginOptional.get().getUsername() == user.getUsername() &&
            loginOptional.get().getPassword() == user.getPassword()){
                userRepository.deleteById(id);
            }
            return true;
        }else{
            return  false;
        }
    }

    public User replaceUser(User newUser, long id) {
        return userRepository.findById(id)
                .map( login -> {
                    login.setUsername(newUser.getUsername());
                    login.setPassword(newUser.getPassword());
                    return userRepository.save(login);
                })
                .orElseGet(() -> {
                    newUser.setUsername(newUser.getUsername());
                    return userRepository.save(newUser);
                });
    }

}
