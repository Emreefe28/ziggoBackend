package hva.ewa.rest;

import hva.ewa.model.Chat;
import hva.ewa.service.ChatRepositoryService;
import hva.ewa.service.impl.ChatRepositoryServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 * The chat REST resource
 *
 * @author José Niemel
 */
@Path("chat") // http://localhost:8080/VodafoneZiggoApi-1.2/services/rest/chat
public class ChatResource {

    private ChatRepositoryService service;

    public ChatResource() {
        service = ChatRepositoryServiceImpl.getInstance();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveChat(Chat chat) {
        service.saveChat(chat);
        return Response.status(Response.Status.OK).entity(chat).build();
    }

}
