package ma.emsi.samih.tp3samih.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import ma.emsi.samih.tp3samih.llm.GuideTouristiqueService;

@Path("/guide")
public class GuideTouristiquResource {

    @Inject
    private GuideTouristiqueService guideService;

    @GET
    @Path("lieu/{ville_ou_pays}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getLieux(@PathParam("ville_ou_pays") String villeOuPays, @QueryParam("nb") int nb) {
        return guideService.guide(villeOuPays, nb);
    }
}
