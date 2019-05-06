package hva.ewa.service;

import hva.ewa.model.Chat;

import java.util.List;


public interface ChatRepositoryService {

    void saveChat(Chat chat);

    List<Chat> getAllChats();
}
