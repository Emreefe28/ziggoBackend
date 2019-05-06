//package hva.ewa.service.impl;
//
//import java.util.ArrayList;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//
//import hva.ewa.model.Category;
//import hva.ewa.model.Question;
//import hva.ewa.service.QuestionnaireRepositoryService;
//
///**
// *
// * A simple implementation of the repository service
// * using memory. Some predefined cards are added
// * during class loading.
// *
// * @author marciofk
// */
//public class QuestionnaireRepositoryServiceImpl implements QuestionnaireRepositoryService {
//
//    // A singleton reference
//    private static QuestionnaireRepositoryServiceImpl instance;
//
//    // An instance of the service is created and during class initialisation
//    static {
//        instance = new QuestionnaireRepositoryServiceImpl();
//    }
//
//    //  Method to get a reference to the instance (singleton)
//    public static QuestionnaireRepositoryService getInstance() {
//        return instance;
//    }
//
//    // An attribute that stores all cards (in memory)
//    private Map<Integer, Category> elements;
//
//    private QuestionnaireRepositoryServiceImpl() {
//
//        elements = new LinkedHashMap<>();
//    }
//
//    public List<Category> getAllFlashCards() {
//
//        return new ArrayList<>(elements.values());
//    }
//
//
//    public void addFlashCard(Category card) {
//        elements.put(card.getId(), card);
//    }
//
//
//    public Category getFlashCardFromId(int id) {
//        return elements.get(id);
//    }
//
//    public List<Question> getQuestionsOfFlashCard(Category category) {
//        return category.getQuestions();
//    }
//
//    public Question getQuestionOfFlashCard(Category category, int questionId) {
//        List<Question> questions = getQuestionsOfFlashCard(category);
//
//        if (questions == null) {
//            return null;
//        }
//
//        Question found = null;
//        for (Question q : questions) {
//            if (q.getId() == questionId) {
//                found = q;
//                break;
//            }
//        }
//        return found;
//    }
//
//    @Override
//    public void setResponce(String test) {
//
//    }
//
//    @Override
//    public List<Category> getAllCategorie() {
//        return null;
//    }
//
//    @Override
//    public List<Question> getAllQuestion() {
//        return null;
//    }
//
//    @Override
//    public Question getQuestionFromId(int questionId) {
//        return null;
//    }
//
//    @Override
//    public Category getCategorieFromId(int categorieId) {
//        return null;
//    }
//
//    @Override
//    public void addCategorie(Category cat) {
//
//    }
//
//    @Override
//    public void setResponce(Question question) {
//
//    }
//
//    @Override
//    public void deleteQuestion() {
//
//    }
//
//    @Override
//    public boolean addQuestion(Category card, Question question) {
//
//        return card.addQuestion(question);
//    }
//
//    @Override
//    public List<Question> getQuestionsOfCategorie(Category card) {
//        return null;
//    }
//
//    @Override
//    public Question getQuestionOfCategorie(Category category, int questionId) {
//        return null;
//    }
//
//
//    }
//
//
//
