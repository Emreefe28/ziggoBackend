package hva.ewa.service.impl;

import java.util.List;

import hva.ewa.rest.model.WebToken;
import hva.ewa.service.UserRepositoryService;
import hva.ewa.model.User;

import javax.persistence.*;
import javax.persistence.criteria.*;

/**
 *
 * A simple implementation of the repository service
 * using memory. Some predefined cards are added
 * during class loading.
 *
 * @author Emre Efe
 */

public class UserRepositoryServiceImpl implements UserRepositoryService {

    private EntityManagerFactory entityManagerFactory;

    // A singleton reference
    private static UserRepositoryServiceImpl instance;

    // An instance of the service is created and during class initialisation
    static {
        instance = new UserRepositoryServiceImpl();
        instance.loadExamples();
    }

    //  Method to get a reference to the instance (singleton)
    public static UserRepositoryService getInstance() {
        return instance;
    }

    private UserRepositoryServiceImpl() {

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
    public User getUserFromUsername(String name) {

        EntityManager em = getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<User> q = cb.createQuery(User.class);
        Root<User> c = q.from(User.class);
        Predicate usernamePredicate = cb.equal(c.get("userName"), name);
        q.where(usernamePredicate);
        TypedQuery<User> query = em.createQuery(q);

        User user;
        try {
            user = query.getSingleResult();
        } catch (NoResultException e) {
            user = null;
        }

        em.close();

        return user;
    }

    @Override
    public User getUserFromId(int id) {

        EntityManager em = getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<User> q = cb.createQuery(User.class);
        Root<User> c = q.from(User.class);
        Predicate idPredicate = cb.equal(c.get("id"), id);
        q.where(idPredicate);
        TypedQuery<User> query = em.createQuery(q);

        User user;
        try {
            user = query.getSingleResult();
        } catch (NoResultException e) {
            user = null;
        }

        em.close();

        return user;
    }

    @Override
    public void addUser(User user) {

        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();

        em.close();
    }

    @Override
    public User checkCredentials(String username, String password) {

        EntityManager em = getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<User> q = cb.createQuery(User.class);
        Root<User> c = q.from(User.class);
        Predicate usernamePredicate = cb.equal(c.get("userName"), username);
        Predicate passwordPredicate = cb.equal(c.get("password"), password);
        q.where(usernamePredicate, passwordPredicate);
        TypedQuery<User> query = em.createQuery(q);

        WebToken jwt = new WebToken();

        User user;
        try {
            user = query.getSingleResult();
            user.setJwtToken(jwt.generateToken(user));
        } catch (NoResultException e) {
            user = null;
        }

        em.close();

        return user;
    }

    private void loadExamples() {

        User us = new User("test", "pw1");
        addUser(us);
    }
}