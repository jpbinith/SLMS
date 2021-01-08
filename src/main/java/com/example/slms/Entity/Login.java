package com.example.slms.Entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonNaming( value = PropertyNamingStrategy.SnakeCaseStrategy.class)
@Table( name = "login" )
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_ID")
    private long userID;

    @Column( name = "username" )
    private String username;
    @Column( name = "password" )
    private String password;

    Login() {}

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Login))
            return false;
        Login login = (Login) o;
        return Objects.equals(this.userID, login.userID) && Objects.equals(this.username, login.username)
                && Objects.equals(this.password, login.password);
    }
    @Override
    public int hashCode(){
        return Objects.hash(this.userID, this.username, this.password);
    }
    @Override
    public String toString() {
        return "User{" + "user_id=" + this.userID + ", name='" + this.username + '\'' + ", password='" + this.password + '\'' + '}';
    }
}
