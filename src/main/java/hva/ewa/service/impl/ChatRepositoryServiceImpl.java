package hva.ewa.service.impl;

import hva.ewa.model.Chat;
import hva.ewa.service.ChatRepositoryService;
import hva.ewa.service.RepositoryService;

import javax.persistence.EntityManager;


public class ChatRepositoryServiceImpl extends RepositoryService implements ChatRepositoryService {

    private static ChatRepositoryServiceImpl instance = new ChatRepositoryServiceImpl();

    public static ChatRepositoryService getInstance() {
        return instance;
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
