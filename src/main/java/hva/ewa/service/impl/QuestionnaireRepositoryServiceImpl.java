package hva.ewa.service.impl;

import java.util.*;

import hva.ewa.model.*;
import hva.ewa.service.QuestionnaireRepositoryService;
import hva.ewa.service.RepositoryService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

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

            EntityManager em = getEntityManager();
            Query query = em.createQuery("SELECT q FROM Question q");
            return query.getResultList();

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
    public Collection<Question> getQuestionsOfQuestionnaire(int questionnaireId) {

       Questionnaire questionnaire=getQuestionnaire(questionnaireId);
       return questionnaire.getQuestions();


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
    public Collection<Questionnaire> getQuestionnairesFromUser(int userId) {

        CustomerRepositoryServiceImpl instance = new CustomerRepositoryServiceImpl();
        Customer customer= instance.getCustomer(userId);

        return customer.getIssues();


    }

    @Override
    public Questionnaire getQuestionnaireFromUser(int userId, int questionId) {
        return null;
    }

    @Override
    public void addQuestionnaire(int categoryId, Questionnaire questionnaire) {

        questionnaire.setCategory(getCategory(categoryId));

        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        em.persist(questionnaire);

        em.getTransaction().commit();

        em.close();
    }

    @Override
    public void addQuestionToQuestionnaire(int questionnaireId, int questionId) {

        //retrieve het questionnaire object van database, voeg er een question aan toe en persist t
        Questionnaire questionnaire = getQuestionnaire(questionnaireId);
        Question question = getQuestionFromId(questionId);


        questionnaire.addQuestion(question);
        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        em.merge(questionnaire);

        em.getTransaction().commit();

        em.close();

    }

    @Override
    public void addQuestionnaireToCustomer(int user, int questionnaireId) {


        CustomerRepositoryServiceImpl instance = new CustomerRepositoryServiceImpl();
        Customer customer = instance.getCustomer(user);
        Questionnaire questionnaire = getQuestionnaire(questionnaireId);


        System.out.println("--------------DIT IS DE LINE VAN CUSTOMER:"+customer.getAdres()+"--------------");
        System.out.println("--------------DIT IS DE LINE VAN QUESTIONNAIRE"+questionnaire.getId()+"-------------");
        customer.addIssues(questionnaire);


        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        em.merge(customer);

        em.getTransaction().commit();

        em.close();
    }


    @Override
    public void setResponce(String test) {

    }
}



