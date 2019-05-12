package hva.ewa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Chat implements Serializable {
    @Id
    @Column(name = "id")
    private String id;

    @Basic
    @Column(name = "created")
    private long created;

    @Basic
    @Column(name = "rating")
    private Integer rating;

    @OneToMany(mappedBy="id.chat", cascade = CascadeType.ALL,
            orphanRemoval = true,fetch = FetchType.LAZY)
    private List<Message> messages;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }


    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
