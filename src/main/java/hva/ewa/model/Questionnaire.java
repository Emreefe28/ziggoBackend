package hva.ewa.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbTransient;
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
    @JsonDeserialize
    private String created;

    @ManyToOne
    @JoinColumn(name = "category", nullable = false)
    @JsonbTransient
    private Category category;

    @OneToMany
    @JsonbTransient
    private Collection<Question> questions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Collection<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Collection<Question> questions) {
        this.questions = questions;
    }


    public boolean addQuestion(Question q) {
        if (checkDuplicates(q)) {
            return false;
        }
        getQuestions().add(q);
        return true;
    }

    public Question getQuestionFromId(int id) {
        for (Question quest : questions) {
            if (quest.getId() == id) {
                return quest;
            }

        }
        Question nullo = new Question();
        return nullo;
    }


    private boolean checkDuplicates(Question q) {
        for(Question check : getQuestions()) {
            if(check.getId() == q.getId()) {
                return true;
            }
        }
        return false;
    }
}
