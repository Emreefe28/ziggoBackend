package nl.hva.ewa.rest;

import nl.hva.ewa.models.Chat;
import nl.hva.ewa.services.ChatRepository;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/chat") // http://localhost:8080/VodafoneZiggoAPI-1.0/rest/chat
public class ChatResource {
    private ChatRepository chatDao;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveChat(Chat chat){
        System.out.println("CHAT CREATAED I GUESS ");
    }
}
