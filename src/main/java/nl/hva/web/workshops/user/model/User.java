package nl.hva.web.workshops.user.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * A flash card representation containing a set of questions
 * 
 * @author Emre Efe
 */
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String userName;


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
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
