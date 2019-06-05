package hva.ewa.service;

import java.util.List;

import hva.ewa.model.User;

import javax.ws.rs.core.UriInfo;

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
     * @param user
     * @return
     */
    User getUser(User user);

    /**
     * Adding a user
     * @param user
     */
    void addUser(User user);

    /**
     *
     * @param email
     * @param password
     * @return
     */
    Boolean checkCredentials(String email, String password);

    /**
     *
     * @param id
     * @return
     */
    User getUserFromId(int id);

    /**
     *
     * @param user
     */
    void deleteUser(User user);

    /**
     *
     * @param user
     */
    void changeUser(User user);

    /**
     * Issues a token for the user
     * @param email
     * @param uri
     * @return
     */
    String issueToken(String email, UriInfo uri);

}
