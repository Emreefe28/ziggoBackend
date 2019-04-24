package hva.ewa.service.impl;

import hva.ewa.model.Chat;
import hva.ewa.service.ChatRepositoryService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * A simple implementation of the repository service
 * using memory. Some predefined cards are added
 * during class loading.
 *
 * @author Emre Efe
 */

public class ChatRepositoryServiceImpl implements ChatRepositoryService {

    private EntityManagerFactory entityManagerFactory;

    // A singleton reference
    private static ChatRepositoryServiceImpl instance;

    // An instance of the service is created and during class initialisation
    static {
        instance = new ChatRepositoryServiceImpl();
    }

    //  Method to get a reference to the instance (singleton)
    public static ChatRepositoryService getInstance() {
        return instance;
    }

    private ChatRepositoryServiceImpl() {

        entityManagerFactory = Persistence.createEntityManagerFactory("userPU");
    }

    private EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    @Override
    public void saveChat(Chat chat) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(chat);
        em.getTransaction().commit();

        em.close();
    }

}