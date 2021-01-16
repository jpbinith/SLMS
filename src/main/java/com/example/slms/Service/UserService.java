package com.example.slms.Service;

import com.example.slms.Entity.User;
import com.example.slms.Entity.UserDetailsProjection;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User getUser(long id);
    User findByUsername(String username);
    UserDetailsProjection getUserDetails(long id);

    User createUser(User user);

    boolean deleteUser(long id, User user);

    User replaceUser(User newUser, long id);

}
