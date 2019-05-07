package hva.ewa.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import hva.ewa.model.Category;
import hva.ewa.model.Customer;
import hva.ewa.model.Question;
import hva.ewa.model.Questionnaire;
import hva.ewa.service.QuestionnaireRepositoryService;
import hva.ewa.service.RepositoryService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * A simple implementation of the repository service
 * using memory. Some predefined cards are added
 * during class loading.
 *
 * @author marciofk
 */
public class QuestionnaireRepositoryServiceImpl extends RepositoryService implements QuestionnaireRepositoryService {

    private static QuestionnaireRepositoryService instance = new QuestionnaireRepositoryServiceImpl();


    public static QuestionnaireRepositoryService getInstance() {
        return instance;
    }

    private EntityManagerFactory entityManagerFactory;


    @Override
    public List<Category> getAllCategorie() {
        return null;
    }

    //geeft nullpointer
        @Override
        public List<Question> getAllQuestion() {

            EntityManager em = entityManagerFactory.createEntityManager();

            List<Question> questions =
                    em.createQuery("SELECT q FROM Question q WHERE id is not null ").getResultList();

            em.close();

            return questions;
        }


    @Override
    public Question getQuestionFromId(int questionId) {
        EntityManager em = getEntityManager();
        System.out.println("GET QUESTION BITCH");
        System.out.println(em.find(Question.class, questionId));
        return em.find(Question.class, questionId);
    }



    @Override
    public void addCategory(Category cat) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(cat);
        em.getTransaction().commit();

        em.close();
    }

    @Override
    public void setResponce(Question question) {

    }

    @Override
    public void deleteQuestion(int questionId) {

    }

    @Override
    public void addQuestion(Question question) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(question);
        em.getTransaction().commit();

        em.close();
    }

    @Override
    public List<Question> getQuestionsOfQuestionnaire(Questionnaire questionnaire) {
        return null;
    }

    @Override
    public Question getQuestionOfQuestionnaire(Questionnaire questionnaire, int questionId) {
        return null;
    }

    @Override
    public Questionnaire getQuestionnaire(int id) {
        EntityManager em = getEntityManager();
        System.out.println("GET QUESTIONNAIRE");
        System.out.println(em.find(Questionnaire.class, id));
        return em.find(Questionnaire.class, id);
    }

    @Override
    public Category getCategory(int id) {
        EntityManager em = getEntityManager();
        System.out.println("GET QUESTION BITCH");
        System.out.println(em.find(Category.class, id));
        return em.find(Category.class, id);
    }

    @Override
    public void addQuestionnaire(Questionnaire questionnaire) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(questionnaire);
        em.getTransaction().commit();

        em.close();
    }

    @Override
    public void setResponce(String test) {

    }
}



