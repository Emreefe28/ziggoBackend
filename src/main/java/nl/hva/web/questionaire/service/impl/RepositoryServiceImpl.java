package nl.hva.web.questionaire.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import nl.hva.web.questionaire.model.Categorie;
import nl.hva.web.questionaire.model.Question;
import nl.hva.web.questionaire.service.RepositoryService;

/**
 *
 * A simple implementation of the repository service
 * using memory. Some predefined cards are added 
 * during class loading. 
 * 
 * @author marciofk
 */
public class RepositoryServiceImpl implements RepositoryService {

    // A singleton reference
    private static RepositoryServiceImpl instance;

    // An instance of the service is created and during class initialisation
    static {
        instance = new RepositoryServiceImpl();
    }

    //  Method to get a reference to the instance (singleton)
    public static RepositoryService getInstance() {
        return instance;
    }

    // An attribute that stores all cards (in memory)
    private Map<Integer, Categorie> elements;

    private RepositoryServiceImpl() {

        elements = new LinkedHashMap<>();
    }

    public List<Categorie> getAllFlashCards() {

        return new ArrayList<>(elements.values());
    }


    public void addFlashCard(Categorie card) {
        elements.put(card.getId(), card);
    }


    public Categorie getFlashCardFromId(int id) {
        return elements.get(id);
    }

    public List<Question> getQuestionsOfFlashCard(Categorie categorie) {
        return categorie.getQuestions();
    }

    public Question getQuestionOfFlashCard(Categorie categorie, int questionId) {
        List<Question> questions = getQuestionsOfFlashCard(categorie);

        if (questions == null) {
            return null;
        }

        Question found = null;
        for (Question q : questions) {
            if (q.getId() == questionId) {
                found = q;
                break;
            }
        }
        return found;
    }

    @Override
    public void setResponce(String test) {

    }

    @Override
    public List<Categorie> getAllCategorie() {
        return null;
    }

    @Override
    public List<Question> getAllQuestion() {
        return null;
    }

    @Override
    public Question getQuestionFromId(int questionId) {
        return null;
    }

    @Override
    public Categorie getCategorieFromId(int categorieId) {
        return null;
    }

    @Override
    public void addCategorie(Categorie cat) {

    }

    @Override
    public void setResponce(Question question) {

    }

    @Override
    public void deleteQuestion() {

    }

    @Override
    public boolean addQuestion(Categorie card, Question question) {
        
        return card.addQuestion(question);       
    }

    @Override
    public List<Question> getQuestionsOfCategorie(Categorie card) {
        return null;
    }

    @Override
    public Question getQuestionOfCategorie(Categorie categorie, int questionId) {
        return null;
    }

        
    }



