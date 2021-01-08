package com.example.slms.Service.Implementation;

import com.example.slms.Entity.Login;
import com.example.slms.Exceptions.UserNotFoundException;
import com.example.slms.Repository.LoginRepository;
import com.example.slms.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LoginServiceImp implements LoginService {
    @Autowired
    private LoginRepository loginRepository;

    public List<Login> getAllUsers() {
        return loginRepository.findAll();
    }

    public Login getLogin(long id){
//        Optional<Login> loginOptional = loginRepository.findById(id);
//        return loginOptional.get();
        return loginRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public Login createLogin(Login login) {
        return loginRepository.save(login);
    }

    public boolean deleteLogin(long id) {
        Optional<Login> loginOptional = loginRepository.findById(id);
        if(loginOptional.isPresent()){
//            if(loginOptional.get().getUsername() == login.getUsername() &&
//            loginOptional.get().getPassword() == login.getPassword()){
                loginRepository.deleteById(id);
//            }
            return true;
        }else{
            return  false;
        }
    }

    public Login deleteLogin2(long id) {
        if(loginRepository.findById(id).isPresent()){
            loginRepository.deleteById(id);
            return null;
        }
//        else{
//            return new UserNotFoundException(id);
//        }
        return null;
    }

    public Login replaceUser(Login newUser, long id) {
        return loginRepository.findById(id)
                .map( login -> {
                    login.setUsername(newUser.getUsername());
                    login.setPassword(newUser.getPassword());
                    return loginRepository.save(login);
                })
                .orElseGet(() -> {
                    newUser.setUsername(newUser.getUsername());
                    return loginRepository.save(newUser);
                });
    }

//    public void updateLogin(Login login, String pw) {
//        Optional<Login> loginOptional = loginRepository.findById(login.getUsername());
//        if(loginOptional.isPresent()){
//            if(loginOptional.get().getUsername() == login.getUsername() &&
//                    loginOptional.get().getPassword() == login.getPassword()){
//                    login.setPassword(pw);
//                    loginRepository.save(login);
//            }
//        }
//    }
}
