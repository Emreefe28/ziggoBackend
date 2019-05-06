package hva.ewa.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
public class Questionnaire {

    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "created")
    private Timestamp created;

    @ManyToOne
    @JoinColumn(name = "category", nullable = false)
    private Category category;

    @OneToMany
    private Collection<Question> questions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
