package hva.ewa.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Question implements Serializable {
    
    private int id;
    private String title;
    private String question;
    
    public Question() {}
    
    public Question(int id, String title, String question) {
        setId(id);
        setTitle(title);
        setQuestion(question);
    }

    public int getId() {
        return id;
    }

    public final void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public final void setTitle(String title) {
        this.title = title;
    }

    public String getQuestion() {
        return question;
    }

    public final void setQuestion(String question) {
        this.question = question;
    }

    
}
