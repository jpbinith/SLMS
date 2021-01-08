package com.example.slms.Responses;

import com.example.slms.Entity.Login;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class LoginResponse {
    private String errorMessage;
    private boolean resultOk;
    private Login login;
    private LocalDateTime dateTime = LocalDateTime.now();

//    public LoginResponse(String e, boolean b, Login o, LocalDateTime now) {
//        this.errorMessage = e;
//        this.resultOk = b;
//        this.login = o;
//        this.dateTime = now;
//    }
}
