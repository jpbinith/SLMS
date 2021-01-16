package com.example.slms.Responses;

import com.example.slms.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class LoginResponse {
    private String errorMessage;
    private boolean resultOk;
    private User user;
    private LocalDateTime dateTime = LocalDateTime.now();

}
