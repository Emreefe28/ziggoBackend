package hva.ewa.service;

import hva.ewa.model.Chat;

/**
 * An interface containing utility methods to manage flash card data
 * @author Emre Efe
 */
public interface ChatRepositoryService {

    void saveChat(Chat chat);
}