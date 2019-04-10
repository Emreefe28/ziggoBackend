package ewa.users.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * A user representation
 * 
 * @author Emre Efe
 */
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String username;


    private String password;


    public User() {
    }


    public User(String name, String password) {
        setUserName(name);
        setPassword(password);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
