package ewa.users.rest;

import ewa.users.model.User;
import ewa.users.service.UserRepositoryService;
import ewa.users.service.impl.UserRepositoryServiceImpl;
import ewa.users.rest.model.ClientError;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 * The user REST resource
 * 
 * @author Emre Efe
 */
@Path("users")
public class UserResource {
    
    /** a reference to the repository service */
    private UserRepositoryService service;
    
    public UserResource() {
        service = UserRepositoryServiceImpl.getInstance();
    }
    
    /**
     * Get all users
     * @return a JSON representation of a list of users
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllCards() {

        return service.getAllUsers();
    }
    
    /**
     * Getting a specific username
     * @param username
     * @return 
     */
    @GET
    @Path("/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("username") String username) {
        
        User user = service.getUserFromUsername(username);
        
        if(user == null) {
            return Response.status(Response.Status.NOT_FOUND).
                    entity(new ClientError("resource not found for username " + username)).build();
        } else {
            return Response.status(Response.Status.OK).entity(user).build();
        }        
    }

    @POST
    @Path("/adduser/{username}/{password}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(
            @PathParam("username") String username,
            @PathParam("password") String password) {

        User user = new User(username, password);
        service.addUser(user);

        return Response.status(Response.Status.CREATED).build();

    }



}
