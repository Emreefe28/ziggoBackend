package hva.ewa.service;

import hva.ewa.model.Chat;
import hva.ewa.model.Message;

import java.util.List;


public interface ChatRepositoryService {

    void saveChat(Chat chat);
    Chat getChat(String id);
    void updateChat(Chat chat);
    List<Chat> getAllChats();
    Integer getAmountOfChats();
    void saveMessages(List<Message> messages, Chat chat);
    List<Long> getAmountOfChatsByMonth();
    Double getCustomerSatisfaction();
}
