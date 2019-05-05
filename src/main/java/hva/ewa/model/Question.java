package hva.ewa.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Question implements Serializable {

    @Id
    private int id;
    private String title;
    private String question;

    private boolean answer;
    public Question() {}
    
    public Question(int id, String title, String question) {
        setId(id);
        setTitle(title);
        setQuestion(question);
    }

    public Question(Question questie, boolean answer) {
        setId(questie.getId());
        setTitle(questie.getTitle());
        setQuestion(questie.getQuestion());
        setAnswer(answer);

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

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}
