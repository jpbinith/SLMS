package com.example.slms.Controller;

import com.example.slms.Entity.Login;
import com.example.slms.Responses.LoginResponse;
import com.example.slms.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping( path = "/slms" )
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping( value = "/login", method = RequestMethod.GET)
    public List<Login> getAllUsers(){
        return loginService.getAllUsers();
    }

    // Need to return http status with the body
    @RequestMapping( value = "/login/{id}", method = RequestMethod.GET,
                     produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Login> getLogin(@PathVariable long id){
//        loginService.getLogin(id);
//        return new ResponseEntity<Login>(HttpStatus.OK);
        return new ResponseEntity<Login>(loginService.getLogin(id),null,HttpStatus.OK);
//        return new LoginResponse("User Found, ", false, null, LocalDateTime.now());
    }

    @RequestMapping( value = "/login", method = RequestMethod.POST,
                    produces = { MediaType.APPLICATION_XML_VALUE,
                                 MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Login> createLogin(@RequestBody Login login){
        loginService.createLogin(login);
        return new ResponseEntity<Login>(HttpStatus.OK);
//        return new ResponseEntity<Login>(login, HttpStatus.BAD_REQUEST);
//        return new ResponseEntity<Login>("User Created Successfully", HttpStatus.OK);
    }

    // update is not done

//    @RequestMapping( value = "/login/{username}", method = RequestMethod.PUT)
//    public void updateLogin(@RequestBody Login login, @RequestBody String pw){
//        loginService.updateLogin(login, pw);
//    }
    @RequestMapping( value = "/login/{id}", method = RequestMethod.PUT)
    public void replaceUser(@RequestBody Login login, @PathVariable long id){
        loginService.replaceUser(login, id);
    }

    @RequestMapping( value = "/login/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Login> deleteLogin(@PathVariable long id){
        boolean isdeleted = loginService.deleteLogin(id);
        if (isdeleted == true){
            return new ResponseEntity<Login>(HttpStatus.OK);
        }else{
            return new ResponseEntity<Login>(HttpStatus.NO_CONTENT);
        }
    }

}
