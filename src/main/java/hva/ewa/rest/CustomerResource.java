package hva.ewa.rest;

import hva.ewa.model.Customer;
import hva.ewa.model.User;
import hva.ewa.service.CustomerRepositoryService;
import hva.ewa.service.impl.CustomerRepositoryServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/customers") // http://localhost:8080/VodafoneZiggoApi-1.2/services/rest/customers
public class CustomerResource {
    private CustomerRepositoryService service;

    public CustomerResource() {
        service = CustomerRepositoryServiceImpl.getInstance();
    }



    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getCustomer(@PathParam("id") int id){
        Customer customer = service.getCustomer(id);
        if(customer != null){
            return Response.status(Response.Status.OK).entity(customer).build();
        }else {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
    }
}
