package nl.hva.ewa.rest;

import nl.hva.ewa.models.Chat;
import nl.hva.ewa.services.ChatRepository;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/chat") // http://localhost:8080/VodafoneZiggoAPI-1.0/rest/chat
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ChatResource {
    private ChatRepository chatDao;

    @POST
    public Response saveChat(Chat chat) {
        chatDao = new ChatRepository();
        chatDao.saveChat(chat);
        return Response.status(Response.Status.OK).entity(chat).build();
    }
}
