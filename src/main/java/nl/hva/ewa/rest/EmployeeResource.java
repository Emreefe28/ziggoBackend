package nl.hva.ewa.rest;

import nl.hva.ewa.models.User;
import nl.hva.ewa.services.UserRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

@Path("/employee") //http://localhost:8080/VodafoneZiggoAPI-1.0/rest/employee
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeResource {
    private UserRepository employeeDao;

    @GET
    public Response getEmployees() {
        employeeDao = new UserRepository();
        if (employeeDao.getAllEmployees().isEmpty()) {
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.OK).entity(employeeDao.getAllEmployees()).build();
        }
    }

    @POST
    public void createEmployee(User employee){
        System.out.println(employee);
        employeeDao = new UserRepository();
        employeeDao.saveEmployee(employee);

    }
}
