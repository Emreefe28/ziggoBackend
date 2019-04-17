package nl.hva.ewa.services;

import nl.hva.ewa.config.Database;
import nl.hva.ewa.models.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class UserRepository {

    private EntityManager em;

    public List<User> getAllEmployees(){
        em = new Database().getFactory().createEntityManager();
        Query query = em.createQuery("SELECT e FROM User e WHERE e.role = 2");
        return query.getResultList();
    }
    public void saveEmployee(User user){
        User those = new User();
        those.setName("G");
        those.setUsername("GORAD");
        em = new Database().getFactory().createEntityManager();
        em.persist(those);
    }
}
