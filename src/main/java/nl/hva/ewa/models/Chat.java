package nl.hva.ewa.models;

import java.time.LocalDate;
import java.util.List;

public class Chat {
    private String chatId;
    private LocalDate created;
    private List<Message> messages;
}
