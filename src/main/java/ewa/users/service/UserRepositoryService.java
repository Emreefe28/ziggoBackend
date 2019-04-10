package ewa.users.service;

import java.util.List;
import ewa.users.model.User;
/**
 * An interface containing utility methods to manage user data
 * @author Emre Efe
 */
public interface UserRepositoryService {
    
    /**
     * Getting all users
     * @return 
     */
    List<User> getAllUsers();
    
    /**
     * Getting a specific user
     * @param username
     * @return 
     */
    User getUserFromUsername(String username);

    /**
     * Adding a user
     * @param user
     */
    void addUser(User user);

}
