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


    private static CustomerRepositoryServiceImpl customerRepositoryService =  new CustomerRepositoryServiceImpl();


    public static QuestionnaireRepositoryService getInstance() {
        return instance;
    }

    EntityManager questionnaireManager = getEntityManager();



    @Override
    public List<Category> getAllCategorie() {
        return null;
    }

    //geeft nullpointer
        @Override
        public List<Question> getAllQuestion() {

            EntityManager em = getEntityManager();
            Query query = em.createQuery("SELECT q FROM Question q");


            List<Question> questions= query.getResultList();

            em.close();
            return questions;

        }

    @Override
    public List<Questionnaire> getAllQuestionnaire() {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT q FROM Questionnaire q");

        List<Questionnaire> questionnaires= query.getResultList();

        em.close();
        return questionnaires;
    }



    public List<Question> getAllSolvedQuestion() {

        EntityManager em = getEntityManager();
        Query query = em.createQuery("select count(q) from Question q where solved is TRUE");
        List<Question> solvedQuestions=query.getResultList();
        em.close();
        return solvedQuestions;
    }


    @Override
    public Question getQuestionFromId(int questionId) {
        EntityManager em = getEntityManager();
        System.out.println("vindbaretext de question id is: "+questionId);
        System.out.println(em.find(Question.class, questionId));


        Question question= em.find(Question.class, questionId);
        em.close();
        return question;

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
    public Questionnaire setActiveQuestionnaire(Questionnaire questionnaire) {

        int category = questionnaire.getCategory().getId();

        EntityManager em = getEntityManager();
        Query query = em.createQuery("select q from Questionnaire q where q.active = true and q.category.id = '" + category + "'");
        Questionnaire questionnaireNew= (Questionnaire) query.getSingleResult();

        questionnaireNew.setActive(false);
        questionnaire.setActive(true);

        em.getTransaction().begin();
        em.merge(questionnaireNew);
        em.getTransaction().commit();


        em.getTransaction().begin();
        em.merge(questionnaire);
        em.getTransaction().commit();


        em.close();
        return questionnaireNew;



    }

    @Override
    public Collection<Question> getQuestionsOfQuestionnaire(int questionnaireId) {

       Questionnaire questionnaire=getQuestionnaire(questionnaireId);

       Collection<Question> questions = questionnaire.getQuestions();
       return questions;


    }

    @Override
    public Question getQuestionOfQuestionnaire(Questionnaire questionnaire, int questionId) {
        return null;
    }

    @Override
    public Questionnaire getQuestionnaire(int id) {
//        Questionnaire questionnaire= questionnaireManager.find(Questionnaire.class, id);

        return  questionnaireManager.find(Questionnaire.class, id);
    }

    @Override
    public Questionnaire getActiveQuestionnaire(int categoryId) {


        EntityManager em = getEntityManager();
        Query query = em.createQuery("select q from Questionnaire q where q.active = true and q.category.id = '" + categoryId + "'");
        Questionnaire questionnaireNew= (Questionnaire) query.getSingleResult();

        em.close();
        return questionnaireNew;

    }

    @Override
    public Collection<Question> getActiveQuestionnaireQuestions(int categoryId) {


        EntityManager em = getEntityManager();
        Query query = em.createQuery("select q from Questionnaire q where q.active = true and q.category.id = '" + categoryId + "'");
        Questionnaire questionnaireNew= (Questionnaire) query.getSingleResult();

        em.close();

        Collection<Question> questions = getQuestionsOfQuestionnaire(questionnaireNew.getId());

        return questions;

    }


    @Override
    public Category getCategory(int id) {
        EntityManager em = getEntityManager();
        System.out.println("GET QUESTION BITCH");
        System.out.println(em.find(Category.class, id));


        Category cat= em.find(Category.class, id);
        em.close();
        return cat;



    }

    @Override
    public Collection<Questionnaire> getQuestionnairesFromUser(int userId) {

        Customer customer= customerRepositoryService.getCustomer(userId);

        Collection<Questionnaire> questionnaires = customer.getIssues();

        return customer.getIssues();


    }

    @Override
    public Collection<CategoryAndDate> getCategoriesFromQuestionnaireFromUser(int userId) {
        Customer customer= customerRepositoryService.getCustomer(userId);

        Collection<Questionnaire> questionnaires = customer.getIssues();

        ArrayList<CategoryAndDate> categoryArrayList= new ArrayList<CategoryAndDate>();

        for (Questionnaire questionnaire: questionnaires) {
            CategoryAndDate categoryAndDate = new CategoryAndDate(questionnaire.getCategory().getName(),questionnaire.getCreated());


                    categoryArrayList.add(categoryAndDate);
        }

        Collection<CategoryAndDate> categories = categoryArrayList;


        return categories;



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


        EntityManager em = getEntityManager();

        Question question = em.find(Question.class,questionId);

        Questionnaire questionnaire =  em.find(Questionnaire.class, questionnaireId);

        questionnaire.addQuestion(question);


        em.getTransaction().begin();
        em.merge(questionnaire);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public void addQuestionnaireToCustomer(int user, int questionnaireId) {


        Customer customer = customerRepositoryService.getCustomer(user);
        Questionnaire questionnaire = getQuestionnaire(questionnaireId);

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



