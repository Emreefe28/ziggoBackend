package hva.ewa.model;

import hva.ewa.model.Message;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "chat")
public class Chat {

    @Id
    private int created;

    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Message> messages;
    private int rating;

    public Chat() {
        setMessages(new ArrayList<>());
    }

    public int getCreated() {
        return created;
    }

    public void setCreated(int created) {
        this.created = created;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}