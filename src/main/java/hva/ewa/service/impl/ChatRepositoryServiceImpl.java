package hva.ewa.service.impl;

import hva.ewa.model.Chat;
import hva.ewa.service.ChatRepositoryService;
import hva.ewa.service.RepositoryService;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


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

    @Override
    public List<Chat> getAllChats() {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM Chat c ");
        return query.getResultList();
    }
}
