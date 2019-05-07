package hva.ewa.service;

import hva.ewa.model.Category;
import hva.ewa.model.Question;
import hva.ewa.model.Questionnaire;

import java.util.List;


public interface QuestionnaireRepositoryService {

    List<Category> getAllCategorie();

    List<Question> getAllQuestion();

    Question getQuestionFromId(int questionId);


    void addCategory(Category cat);

    void setResponce(Question question);

    void deleteQuestion(int questionId);

    void addQuestion(Question question);


    List<Question> getQuestionsOfQuestionnaire(Questionnaire questionnaire);

    Question getQuestionOfQuestionnaire(Questionnaire questionnaire, int questionId);

    Questionnaire getQuestionnaire(int id);

    Category getCategory(int id);

    void addQuestionnaire(Questionnaire questionnaire);

    void setResponce(String test);

}
