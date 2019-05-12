package hva.ewa.service.impl;

import hva.ewa.model.Chat;
import hva.ewa.model.Customer;
import hva.ewa.service.ChatRepositoryService;
import hva.ewa.service.RepositoryService;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
    public Chat getChat(String id) {
        EntityManager em = getEntityManager();
        return em.find(Chat.class, id);
    }

    @Override
    public void updateChat(Chat chat) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(chat);
        em.getTransaction().commit();
    }

    @Override
    public List<Chat> getAllChats() {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM Chat c ");
        return query.getResultList();
    }

    @Override
    public Integer getAmountOfChats() {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT COUNT(c) FROM Chat c ");
        return (Integer) query.getSingleResult();
    }

    @Override
    public Map<String, Integer> getAmountOfChatsByMonth() {
        Map map = new HashMap<String, Integer>();
    }

    @Override
    public Map<String, Integer> getCustomerSatisfaction() {
        return null;
    }
}
