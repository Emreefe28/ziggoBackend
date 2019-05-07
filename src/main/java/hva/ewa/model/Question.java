package hva.ewa.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Question implements Serializable {

    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "question")
    private String question;
//
//    @Basic
//    @Column(name = "answer")
//    private boolean answer;


    public Question() {}
    
    public Question(int id, String title, String question) {
        setId(id);
        setTitle(title);
        setQuestion(question);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
