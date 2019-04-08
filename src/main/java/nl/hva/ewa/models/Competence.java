package nl.hva.ewa.models;

import javax.persistence.*;

@Entity
@Table(name="competence")
public class Competence {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) // ID is auto-increment
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    public Competence(String name) {
        this.name = name;
    }

    public Competence() {

    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

}
