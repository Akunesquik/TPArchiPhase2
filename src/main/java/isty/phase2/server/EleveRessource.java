package isty.phase2.server;

import isty.phase2.Groupe.Eleve;

import com.google.gson.Gson;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/eleve")
public class EleveRessource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getEleve() {
    	Eleve e = new Eleve("65387", "Jhone", "Doe");
    	Gson gson = new Gson();
		String jsonString = gson.toJson(e);
    	return jsonString;
    }
}