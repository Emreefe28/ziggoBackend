package hva.ewa.service;

import hva.ewa.model.Categorie;
import hva.ewa.model.Question;

import java.util.List;


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

    void setResponce(String test);
}
