package hva.ewa.model;

import hva.ewa.model.embeddable.MessageId;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Message implements Serializable {

    @EmbeddedId
    private MessageId id;

    @Basic
    @Column(name = "sent")
    private long sent;

    @Basic
    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    private User user;


    public MessageId getId() {
        return id;
    }

    public void setId(MessageId id) {
        this.id = id;
    }

    public long getSent() {
        return sent;
    }

    public void setSent(long sent) {
        this.sent = sent;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
