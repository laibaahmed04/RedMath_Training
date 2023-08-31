package com.redmath.bank.Account;
//import com.redmath.bank.User;
import jakarta.persistence.*;

@Entity
public class Account {


    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Account_ID;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//  private User user;

    private String Name;
   private String Password;
    private String Email;
    private String Address;

    // Getters and setters
    public Long getId() {
        return Account_ID;
    }

    public void setId(Long Account_ID) {
        this.Account_ID = Account_ID;
    }


    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }
    public void setPassword(String Password) {
        this.Password=Password;
    }

    public String getPassword() {
        return Password;
    }




}
