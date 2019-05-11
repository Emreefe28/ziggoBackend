package hva.ewa.model.embeddable;

import hva.ewa.model.Chat;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class MessageId implements Serializable {

    @Column(name = "id")
    private int id;

    @JsonbTransient
    @ManyToOne
    @JoinColumn(name = "chat")
    private Chat chat;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }
}
