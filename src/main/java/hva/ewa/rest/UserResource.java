package hva.ewa.rest;

import hva.ewa.model.User;
import hva.ewa.rest.model.WebToken;
import hva.ewa.service.UserRepositoryService;
import hva.ewa.service.impl.UserRepositoryServiceImpl;
import hva.ewa.rest.model.ClientError;
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
    public List<User> getAllUsers() {

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
    @Path("/adduser")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(@QueryParam("userName") String username,
                            @QueryParam("password") String password) {

        User user = service.getUserFromUsername(username);

        if (user != null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            User newUser = new User(username, password);
            service.addUser(newUser);
            return Response.status(Response.Status.CREATED).entity(newUser).build();
        }
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkUser(@QueryParam("userName") String username,
                              @QueryParam("password") String password) {

        User user = service.checkCredentials(username, password);

        if(user != null) {
            return Response.status(Response.Status.CREATED).entity(user).build();
        }
        else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }

    @GET
    @Path("/jwt/{jwtToken}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkJWT(@PathParam("jwtToken") String jwtToken) {

        WebToken jwt = new WebToken();

        User user = jwt.validateToken(jwtToken);

        return Response.status(Response.Status.OK).entity(user).build();


    }

}