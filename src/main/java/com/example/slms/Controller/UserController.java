package com.example.slms.Controller;

import com.example.slms.Entity.User;
import com.example.slms.Entity.UserDetailsProjection;
import com.example.slms.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( path = "/slms" )
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping( value = "/login", method = RequestMethod.GET)
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    // Not working exception
    @RequestMapping( value = "/login/{id}", method = RequestMethod.GET,
                     produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<User> getLogin(@PathVariable long id){
        return ResponseEntity.ok().body(userService.getUser(id));
    }

    // Need to return UserNotFoundException
    @RequestMapping( value = "/user/{id}", method = RequestMethod.GET)
    public UserDetailsProjection getUserDetails(@PathVariable long id){
        return userService.getUserDetails(id);
    }

    // Need to return UserNotFoundException
    @RequestMapping( value = "/login/username/{username}", method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<User> findByUsername(@PathVariable String username){
        return ResponseEntity.ok().body(userService.findByUsername(username));
    }

    // new user saved but 500
    @RequestMapping( value = "/login", method = RequestMethod.POST,
                    produces = { MediaType.APPLICATION_XML_VALUE,
                                 MediaType.APPLICATION_JSON_VALUE },
                    consumes = { MediaType.APPLICATION_XML_VALUE,
                                 MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<User> createLogin(@RequestBody User user){
//        userService.createUser(user);
//        return new ResponseEntity<User>(HttpStatus.OK);
        return ResponseEntity.ok().body(userService.createUser(user));
    }

    // update is not done
    @RequestMapping( value = "/login/{id}", method = RequestMethod.PUT)
    public void replaceUser(@RequestBody User user, @PathVariable long id){
        userService.replaceUser(user, id);
    }

    // error
    @RequestMapping( value = "/login/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteLogin(@PathVariable long id, @RequestBody User user){
        boolean isdeleted = userService.deleteUser(id, user);
        if (isdeleted == true){
            return ResponseEntity.ok().body(userService.getUser(id));
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(userService.getUser(id));
        }
    }

}
