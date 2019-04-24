package nl.hva.web.questionaire.rest;

import nl.hva.web.questionaire.model.Categorie;
import nl.hva.web.questionaire.service.RepositoryService;
import nl.hva.web.questionaire.service.impl.RepositoryServiceImpl;
import nl.hva.web.questionaire.rest.model.ClientError;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("flashcards")
public class CategorieResource {
    
    /** a reference to the repository service */
    private RepositoryService service;
    
    public CategorieResource() {
        service = RepositoryServiceImpl.getInstance();
    }
    
    /**
     * Get all categories
     * @return a JSON representation of a list of cards
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Categorie> getAllCategorie() {
        return service.getAllCategorie();
    }
    
    /**
     * Getting a specific categorie
     * @param id
     * @return 
     */
    @GET
    @Path("/{categorieId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCategorie(@PathParam("categorieId") int id) {
        
        Categorie fc = service.getCategorieFromId(id);
        
        if(fc == null) {
            return Response.status(Response.Status.NOT_FOUND).
                    entity(new ClientError("resource not found for id " + id)).build();
        } else {
            return Response.status(Response.Status.OK).entity(fc).build();
        }        
    }
    
    /**
     * Getting the question sub-resource
     * @return 
     */
    @Path("/{categorieId}/questions")
    public QuestionResource getQuestionResource() {
        return new QuestionResource();
    }
        
}
