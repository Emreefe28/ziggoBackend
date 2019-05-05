package hva.ewa.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Categorie implements Serializable {

    @Id
    private int id;
    private String name;


    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Question> questions;
    
    public Categorie() {}
    
    public Categorie(int id, String name) {
        setId(id);
        setName(name);
        setQuestions(new ArrayList<>());
    }

    public int getId() {
        return id;
    }

    public final void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public final void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
    
    public boolean addQuestion(Question q) {
        if(checkDuplicates(q)) {
            return false;
        }
        getQuestions().add(q);
        return true;
    }
    
    public boolean checkDuplicates(Question q) {
        for(Question check : getQuestions()) {
            if(check.getId() == q.getId()) {
                return true;
            }
        }
        return false;
    }
    
}
