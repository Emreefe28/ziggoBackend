package hva.ewa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
public class Chat implements Serializable {
    @Id
    @Column(name = "id")
    private String id;

    @Basic
    @Column(name = "created")
    private Timestamp created;

    @Basic
    @Column(name = "rating")
    private Integer rating;

    @OneToMany(mappedBy="id.chat", cascade = CascadeType.ALL,
            orphanRemoval = true,fetch = FetchType.LAZY)
    private Collection<Message> messages;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }


    public Collection<Message> getMessages() {
        return messages;
    }

    public void setMessages(Collection<Message> messages) {
        this.messages = messages;
    }
}
