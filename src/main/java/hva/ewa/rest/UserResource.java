package hva.ewa.rest;

import hva.ewa.model.Customer;
import hva.ewa.model.Employee;
import hva.ewa.model.User;
import hva.ewa.rest.model.WebToken;
import hva.ewa.service.CustomerRepositoryService;
import hva.ewa.service.UserRepositoryService;
import hva.ewa.service.impl.CustomerRepositoryServiceImpl;
import hva.ewa.service.impl.EmployeeRespositoryServiceImpl;
import hva.ewa.service.impl.UserRepositoryServiceImpl;
import org.json.simple.JSONObject;

import java.security.Key;
import java.util.Date;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import static javax.ws.rs.core.HttpHeaders.AUTHORIZATION;
import static javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED;
import static javax.ws.rs.core.Response.Status.UNAUTHORIZED;


/**
 * The user REST resource
 *
 * @author Emre Efe
 */
@Path("users") // http://localhost:8080/VodafoneZiggoApi-1.2/services/rest/users
public class UserResource {

    /**
     * a reference to the repository service
     */
    private UserRepositoryService service;

    public UserResource() {
        service = UserRepositoryServiceImpl.getInstance();
    }

    /**
     * Get all users
     *
     * @return a JSON representation of a list of users
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsers() {

        return service.getAllUsers();
    }


    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(Customer user) {
        System.out.println(user);
            CustomerRepositoryService customerRepositoryService = CustomerRepositoryServiceImpl.getInstance();
            customerRepositoryService.addCustomer(user);
            return Response.status(Response.Status.CREATED).entity(user).build();
    }


    @GET
    @Path("/jwt/{jwtToken}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkJWT(@PathParam("jwtToken") String jwtToken) {
        WebToken jwt = new WebToken();
        User user = jwt.validateToken(jwtToken);
        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.status(Response.Status.OK).entity(user).build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePathParam(@PathParam("id") int id) {
        User user = service.getUserFromId(id);
        try {
            service.deleteUser(user);
        } catch (Exception e) {
            return Response.status(Response.Status.OK).entity(e).build();
        }
        return Response.status(Response.Status.OK).build();

    }

    @Path("/change")
    @Consumes({MediaType.APPLICATION_JSON})
    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    public Response changeUser(User user) {
        try {
            service.changeUser(user);
            return Response.status(Response.Status.OK).entity(user).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e).build();
        }

    }

    @GET
    @Path("/{id}/type")
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkUserType(@PathParam("id") int id) {
        User user = CustomerRepositoryServiceImpl.getInstance().getCustomer(id);
        String userType = "customer";
        JSONObject obj = new JSONObject();
        if (user == null) {
            Employee employee = EmployeeRespositoryServiceImpl.getInstance().getEmployee(id);
            userType = employee.getDepartment();

        }
        obj.put("role", userType);
        return Response.status(Response.Status.OK).entity(obj).build();
    }
}
