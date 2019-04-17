package hva.ewa.service;

import java.util.List;

import hva.ewa.model.User;

/**
 * An interface containing utility methods to manage flash card data
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

    User checkCredentials(String username, String password);

    User getUserFromId(int id);

}
