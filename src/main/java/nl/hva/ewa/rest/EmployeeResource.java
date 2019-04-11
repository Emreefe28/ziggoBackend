package nl.hva.ewa.rest;

import nl.hva.ewa.services.UserRepository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

@Path("/employee") //http://localhost:8080/VodafoneZiggoAPI-1.0/rest/employee
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeResource {
    private UserRepository employees;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployees() {
        employees = new UserRepository();
        if (employees.getAllEmployees().isEmpty()) {
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.OK).entity(employees.getAllEmployees()).build();
        }
    }
}
