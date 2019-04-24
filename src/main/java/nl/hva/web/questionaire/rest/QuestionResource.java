/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hva.web.questionaire.rest;

import nl.hva.web.questionaire.model.Categorie;
import nl.hva.web.questionaire.model.Question;
import nl.hva.web.questionaire.service.RepositoryService;
import nl.hva.web.questionaire.service.impl.RepositoryServiceImpl;
import nl.hva.web.questionaire.rest.model.ClientError;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

public class QuestionResource {
    
    /** A reference to the repository service */
    private RepositoryService service;

    public QuestionResource() {
        service = RepositoryServiceImpl.getInstance();
    }    

    @GET
    @Path("/")
    @Produces(APPLICATION_JSON)
    public Response getAllQuestions(
            @PathParam("categorieId") int categorieId) {

        Categorie categorie = service.getCategorieFromId(categorieId);
        
        if(categorie == null) {
            return Response.status(Response.Status.NOT_FOUND).
                    entity(new ClientError("Categorie not found for id " + categorieId)).build();
        }
        List<Question> questions = service.getQuestionsOfCategorie(categorie);
        
        return Response.status(Response.Status.OK).
                    entity(questions).build();
    }
    

    @GET
    @Path("/{questionId}")
    @Produces(APPLICATION_JSON)
    public Response getQuestion(
                @PathParam("categorieId") int categorieId,
                @PathParam("questionId") int questionId) {
                
        Response resp;

        Categorie categorie = service.getCategorieFromId(categorieId);
        
        if(categorie == null) {
            return Response.status(Response.Status.NOT_FOUND).
                    entity(new ClientError("Question not found for id " + categorieId)).build();
        }            

        Question question = service.getQuestionOfCategorie(categorie, questionId);
        
        if(question == null) {
            resp = Response.status(Response.Status.NOT_FOUND).
                    entity(new ClientError("Resource not found for question id " + questionId)).build();
        } else {
            resp = Response.status(Response.Status.OK).
                    entity(question).build();
            
        }
        
        return resp;        
    }

    @DELETE
    @Path("/question/{id}")
    @Produces(APPLICATION_JSON)
    public Response deleteQuestion(@PathParam("id") String id){
        Question question = new Question();
        try{
            service.deleteQuestion();
            service.setResponce("Succes");
        }
        catch (Exception e){
            service.setResponce("Failed");
            e.printStackTrace();
        }
        return Response.status(200).entity(question).build();
    }

    @PUT
    @Path("/customers/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateQuestion(@PathParam("id") int id,
                                   Question updateQuestion) {

        Question quest = service.getQuestionFromId(id);
        if (quest == null) {
            throw new WebApplicationException("Cannot find question", 404);
        }

        quest.setTitle(updateQuestion.getTitle());
        quest.setQuestion(updateQuestion.getQuestion());


        return Response.noContent().build();
    }


    @POST
    @Path("/")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response addQuestion(
            @PathParam("questionId") int questionId,
            Question question) {

        Categorie card = service.getCategorieFromId(questionId);
        
        if(card == null) {
            return Response.status(Response.Status.NOT_FOUND).
                        entity(new ClientError("Question not found for id " + questionId)).build();
        }

        boolean created = service.addQuestion(card, question);
        
        if(created) {
            return Response.status(Response.Status.CREATED).build();            
        } else {
            return Response.status(Response.Status.BAD_REQUEST).
                        entity(new ClientError("Question already exists for id " + question.getId())).build();

        }

    }

    
}
