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

    @POST
    @Path("/adduser")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(User user) {

        User existingUser = service.getUser(user);

        if (existingUser == null) {
            service.addUser(user);
            return Response.status(Response.Status.CREATED).entity(user).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("user already exists").build();
        }
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkUser(User user) {

        user = service.checkCredentials(user.getEmail(), user.getPassword());

        if(user != null) {
            return Response.status(Response.Status.CREATED).entity(user).build();
        }
        else{
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

    }

    @GET
    @Path("/jwt/{jwtToken}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkJWT(@PathParam("jwtToken") String jwtToken) {

        WebToken jwt = new WebToken();

        User user = jwt.validateToken(jwtToken);

        if(user==null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.status(Response.Status.OK).entity(user).build();


    }

}