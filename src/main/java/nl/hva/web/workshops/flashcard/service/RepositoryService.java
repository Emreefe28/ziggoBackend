package nl.hva.web.workshops.flashcard.service;

import java.util.List;
import nl.hva.web.workshops.flashcard.model.Answer;
import nl.hva.web.workshops.flashcard.model.Categorie;
import nl.hva.web.workshops.flashcard.model.Question;

public interface RepositoryService {

    List<Categorie> getAllCategorie();

    List<Question> getAllQuestion();

    Question getQuestionFromId(int questionId);

    Categorie getCategorieFromId(int categorieId);

    void addCategorie(Categorie cat);

    void setResponce(Question question);

    void deleteQuestion();

    boolean addQuestion(Categorie cat, Question question);

    List<Question> getQuestionsOfCategorie(Categorie card);

    Question getQuestionOfCategorie(Categorie categorie, int questionId);

    List<Answer> getAllAnswersOfQuestion(Question question);    

    List<Answer> getCorrectAnswersOfQuestion(Question question);

    void setResponce(String test);
}
