package nl.hva.ewa.rest;

import nl.hva.ewa.config.Database;
import nl.hva.ewa.models.ClientError;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/competences")
@Produces(MediaType.APPLICATION_JSON)
public class CompetenceServlet {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCompetences() {
        List allCompetences = returnCompetences();
        if (allCompetences != null) {
            return Response.status(Response.Status.OK).entity(returnCompetences()).build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).entity(new ClientError("No competences exist",
                    ClientError.NO_COMPETENCES_FOUND)).build();
        }
    }

    public static List returnCompetences() {
        EntityManager em =  new Database().getFactory().createEntityManager();
        Query query = em.createQuery("SELECT c FROM Competence c");
        List list = query.getResultList();
        if (!list.isEmpty()) {
            return list;
        } else {
            return null;
        }
    }


}

