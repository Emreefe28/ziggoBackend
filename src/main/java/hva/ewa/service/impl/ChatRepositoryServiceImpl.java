package hva.ewa.service.impl;

import hva.ewa.model.Chat;
import hva.ewa.service.ChatRepositoryService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class ChatRepositoryServiceImpl implements ChatRepositoryService {

    private EntityManagerFactory entityManagerFactory;

    private static ChatRepositoryServiceImpl instance;

    static {
        instance = new ChatRepositoryServiceImpl();
    }

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
