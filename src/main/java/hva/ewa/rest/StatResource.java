package hva.ewa.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import hva.ewa.service.ChatRepositoryService;
import hva.ewa.service.impl.ChatRepositoryServiceImpl;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/statistics") //http://localhost:8080/VodafoneZiggoApi-1.2/services/rest/statistics
public class StatResource {

    private ChatRepositoryService service;

    public StatResource() {
        service = ChatRepositoryServiceImpl.getInstance();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStatistics() {
        JSONObject obj = new JSONObject();
        List<Long> chats = service.getAmountOfChatsByMonth();
        JSONArray chatsAmount = new JSONArray();
     chatsAmount.addAll(chats);
        try {
            obj.put("satisfaction", service.getCustomerSatisfaction());
            obj.put("totalChats", service.getAmountOfChats());
            obj.put("chatsPerMonth", chatsAmount);
            return Response.status(Response.Status.OK).entity(obj).build();
        } catch (NullPointerException nx) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
    }
}
