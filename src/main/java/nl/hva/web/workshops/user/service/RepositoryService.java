package nl.hva.web.workshops.user.service;

import java.util.List;
import nl.hva.web.workshops.user.model.User;
/**
 * An interface containing utility methods to manage flash card data
 * @author Emre Efe
 */
public interface RepositoryService {
    
    /**
     * Getting all users
     * @return 
     */
    List<User> getAllUsers();
    
    /**
     * Getting a specific user
     * @param userId
     * @return 
     */
    User getUserFromId(int userId);

    /**
     * Adding a user
     * @param user
     */
    void addUser(User user);

}
