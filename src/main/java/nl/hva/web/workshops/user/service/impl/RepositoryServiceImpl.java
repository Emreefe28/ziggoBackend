package nl.hva.web.workshops.user.service.impl;

import java.util.List;

import nl.hva.web.workshops.user.model.User;
import nl.hva.web.workshops.user.service.RepositoryService;

import javax.persistence.*;

/**
 *
 * A simple implementation of the repository service
 * using memory. Some predefined cards are added 
 * during class loading. 
 * 
 * @author Emre Efe
 */

public class RepositoryServiceImpl implements RepositoryService {

    private EntityManagerFactory entityManagerFactory;

    // A singleton reference
    private static RepositoryServiceImpl instance;

    // An instance of the service is created and during class initialisation
    static {
        instance = new RepositoryServiceImpl();
        instance.loadExamples();
    }

    //  Method to get a reference to the instance (singleton)
    public static RepositoryService getInstance() {
        return instance;
    }

    private RepositoryServiceImpl() {

        entityManagerFactory = Persistence.createEntityManagerFactory("userPU");
    }

    private EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    @Override
    public List<User> getAllUsers() {

        EntityManager em = entityManagerFactory.createEntityManager();

        List<User> users =
                em.createQuery("SELECT u FROM User u").getResultList();

        em.close();

        return users;
    }

    @Override
    public User getUserFromId(int id) {

        EntityManager em = getEntityManager();

        User fc = em.find(User.class,id);

        em.close();

        return fc;
    }

    @Override
    public void addUser(User user) {

        EntityManager em = getEntityManager();

        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();

        em.close();
    }

    private void loadExamples() {

        User us = new User("testt", "pw1");
        addUser(us);
    }
}
