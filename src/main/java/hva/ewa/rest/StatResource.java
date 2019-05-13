package hva.ewa.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import hva.ewa.service.ChatRepositoryService;
import hva.ewa.service.impl.ChatRepositoryServiceImpl;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/statistics") //http://localhost:8080/VodafoneZiggoApi-1.2/services/rest/statistics
public class StatResource {

    private ChatRepositoryService service;

    public StatResource() {
        service = ChatRepositoryServiceImpl.getInstance();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStatistics(){
        JsonObject jsonObject;
        try {
             jsonObject = Json.createObjectBuilder()
                    .add("satisfaction", service.getCustomerSatisfaction())
                     .add("totalChats", service.getAmountOfChats())
                     .add("chatsPerMonth", service.getAmountOfChats())
                    .build();
            return Response.status(Response.Status.OK).entity(jsonObject.toString()).build();
        } catch(NullPointerException nx){
            return Response.status(Response.Status.NO_CONTENT).build();
        }
    }
}
