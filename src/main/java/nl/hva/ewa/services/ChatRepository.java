package nl.hva.ewa.services;

import nl.hva.ewa.config.Database;
import nl.hva.ewa.models.Chat;

import javax.persistence.EntityManager;

public class ChatRepository {
    private EntityManager em;

    public void saveChat(Chat chat) {
        em = new Database().getFactory().createEntityManager();
        em.getTransaction().begin();
        if (chat != null) {
            em.persist(chat);
            em.flush();
            em.getTransaction().commit();
        }
    }
}
