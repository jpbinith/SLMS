package com.example.slms.Service;

import com.example.slms.Entity.Login;
import java.util.List;

public interface LoginService {

    List<Login> getAllUsers();
    Login getLogin(long id);
    Login createLogin(Login login);
    boolean deleteLogin(long id);
    Login deleteLogin2(long id);
    //    void updateLogin(Login login, String pw);
    Login replaceUser(Login newUser, long id);
}
