package com.redmath.bank.User;
import jakarta.persistence.*;

@Entity
public class User{

    @Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String User_Name;
    private String Password;
    private String Roles;

    public Long getId() {
        return ID;
    }

    public void setId(Long ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return User_Name;
    }

    public void setUsername(String User_Name) {
        this.User_Name = User_Name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getRole() {
        return Roles;
    }

    public void setRole(String Roles) {
        this.Roles = Roles;
    }
}








