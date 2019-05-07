/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hva.ewa.rest;

import hva.ewa.model.Category;
import hva.ewa.model.Question;
import hva.ewa.model.Questionnaire;
import hva.ewa.rest.model.ClientError;
import hva.ewa.service.QuestionnaireRepositoryService;
import hva.ewa.service.impl.QuestionnaireRepositoryServiceImpl;
//import hva.ewa.service.impl.QuestionnaireRepositoryServiceImpl;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;


    //http://localhost:8080/VodafoneZiggoApi-1.2/services/rest/question

@Path("/question")
public class QuestionResource {

    /**
 * A reference to the repository service
 */
private QuestionnaireRepositoryService service;

    public QuestionResource() {
        service = QuestionnaireRepositoryServiceImpl.getInstance();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Question> getAllQuestion() {

        return service.getAllQuestion();
    }



    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getQuestion(@PathParam("id") int id) {
        Question question = service.getQuestionFromId(id);
        if (question != null) {
            return Response.status(Response.Status.OK).entity(question).build();
        } else {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/questionnaire/{id}")
    public Response getQuestionnaire(@PathParam("id") int id) {
        System.out.println("eerste gedeelte");
        Questionnaire questionnaire = service.getQuestionnaire(id);
        System.out.println("tweede gedeelte");
        if (questionnaire != null) {
            return Response.status(Response.Status.OK).entity(questionnaire).build();
        } else {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
    }

    @POST
    @Path("/addquestion")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addQuestion(Question question) {

        Question existingQuestion = service.getQuestionFromId(question.getId());

        if (existingQuestion == null) {
            service.addQuestion(question);
            return Response.status(Response.Status.CREATED).entity(question).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("question already exists").build();
        }
    }

    @POST
    @Path("/addquestionnaire")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addQuestionnaire(Questionnaire questionnaire) {

        Questionnaire existingQuestion = service.getQuestionnaire(questionnaire.getId());

        if (existingQuestion == null) {
            service.addQuestionnaire(questionnaire);
            return Response.status(Response.Status.CREATED).entity(questionnaire).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("user already exists").build();
        }
    }



    //
//    @GET
//    @Path("/{questionId}")
//    @Produces(APPLICATION_JSON)
//    public Response getQuestion(
//                @PathParam("categorieId") int categorieId,
//                @PathParam("questionId") int questionId) {
//        Response resp;
//        Category category = service.getCategorieFromId(categorieId);
//        if(category == null) {
//            return Response.status(Response.Status.NOT_FOUND).
//                    entity(new ClientError("Question not found for id " + categorieId)).build();
//        }
//
//        Question question = service.getQuestionOfCategorie(category, questionId);
//
//        if(question == null) {
//            resp = Response.status(Response.Status.NOT_FOUND).
//                    entity(new ClientError("Resource not found for question id " + questionId)).build();
//        } else {
//            resp = Response.status(Response.Status.OK).
//                    entity(question).build();
//
//        }
//
//        return resp;
//    }
//
//    @DELETE
//    @Path("categorie/question/{id}")
//    @Produces(APPLICATION_JSON)
//    public Response deleteQuestion(@PathParam("id") String id){
//        Question question = new Question();
//        try{
//            service.deleteQuestion();
//            service.setResponce("Succes");
//        }
//        catch (Exception e){
//            service.setResponce("Failed");
//            e.printStackTrace();
//        }
//        return Response.status(200).entity(question).build();
//    }
//
//    @PUT
//    @Path("/customers/{id}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response updateQuestion(@PathParam("id") int id,
//                                   Question updateQuestion) {
//
//        Question quest = service.getQuestionFromId(id);
//        if (quest == null) {
//            throw new WebApplicationException("Cannot find question", 404);
//        }
//
//        quest.setTitle(updateQuestion.getTitle());
//        quest.setQuestion(updateQuestion.getQuestion());
//
//
//        return Response.noContent().build();
//    }
//
//


}
