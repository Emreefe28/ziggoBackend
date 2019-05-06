package hva.ewa.service;

import hva.ewa.model.Category;
import hva.ewa.model.Question;

import java.util.List;


public interface QuestionnaireRepositoryService {

    List<Category> getAllCategorie();

    List<Question> getAllQuestion();

    Question getQuestionFromId(int questionId);

    Category getCategorieFromId(int categorieId);

    void addCategorie(Category cat);

    void setResponce(Question question);

    void deleteQuestion();

    boolean addQuestion(Category cat, Question question);

    List<Question> getQuestionsOfCategorie(Category card);

    Question getQuestionOfCategorie(Category category, int questionId);

    void setResponce(String test);
}
