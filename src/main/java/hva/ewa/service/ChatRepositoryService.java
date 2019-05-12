package hva.ewa.service;

import hva.ewa.model.Chat;

import java.util.List;
import java.util.Map;


public interface ChatRepositoryService {

    void saveChat(Chat chat);
    Chat getChat(String id);
    void updateChat(Chat chat);
    List<Chat> getAllChats();
    Integer getAmountOfChats();
    Map<String, Integer> getAmountOfChatsByMonth();
    Map<String, Integer> getCustomerSatisfaction();
}
