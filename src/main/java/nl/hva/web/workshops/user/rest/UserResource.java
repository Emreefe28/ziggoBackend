package nl.hva.web.workshops.user.rest;

import nl.hva.web.workshops.user.rest.model.ClientError;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import nl.hva.web.workshops.user.model.User;
import nl.hva.web.workshops.user.service.impl.RepositoryServiceImpl;
import nl.hva.web.workshops.user.service.RepositoryService;


/**
 * The flash card REST resource
 * 
 * @author Emre Efe
 */
@Path("users")
public class UserResource {
    
    /** a reference to the repository service */
    private RepositoryService service;
    
    public UserResource() {
        service = RepositoryServiceImpl.getInstance();
    }
    
    /**
     * Get all flash cards
     * @return a JSON representation of a list of cards
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllCards() {

        return service.getAllUsers();
    }
    
    /**
     * Getting a specific flash card
     * @param id
     * @return 
     */
    @GET
    @Path("/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("userId") int id) {
        
        User fc = service.getUserFromId(id);
        
        if(fc == null) {
            return Response.status(Response.Status.NOT_FOUND).
                    entity(new ClientError("resource not found for id " + id)).build();
        } else {
            return Response.status(Response.Status.OK).entity(fc).build();
        }        
    }

    @POST
    @Path("/adduser/{userName}/{password}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(
            @PathParam("userName") String username,
            @PathParam("password") String password) {

        User user = new User(username, password);
        service.addUser(user);

        return Response.status(Response.Status.CREATED).build();

    }



}
