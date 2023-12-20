package isty.phase2.server;

import isty.phase2.Groupe.GroupeImplementation;
import isty.phase2.server.ServerConfig;

import java.util.logging.Logger;
import com.sun.net.httpserver.HttpServer;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONObject;

//branche louis
public class MainServer {
	private static Logger logger = Logger.getLogger(MainServer.class.getSimpleName());

	private static GroupeImplementation sess = new GroupeImplementation();
	private static HttpServer server;

	public static void main(String[] args) {
		MainServer mainServer = new MainServer();
		mainServer.startServer();
	}

	private void startServer() {
		ServerConfig.configCheck();
		ServerConfig serverConf = ServerConfig.loadConfig();
		URI baseUri = UriBuilder.fromUri(serverConf.getAdress()).port(serverConf.getPort()).build();
		ResourceConfig config = new ResourceConfig(HelloWorldResource.class, EleveResource.class, SujetResource.class,
				GroupeResource.class, UEResource.class);
		server = JdkHttpServerFactory.createHttpServer(baseUri, config);
		logger.info("Server started at " + serverConf.getURL());

		initDatabase(sess);
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			logger.info("Fermeture du serveur...");
			server.stop(0);
			logger.info("Serveur fermé.");
		}));
	}

	public void initDatabase(GroupeImplementation sess) {
		try {
			Class.forName("org.sqlite.JDBC");

			sess.initDatabase();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			// Handle the exception (e.g., log the error or terminate the program)
			return;
		}

	}

	@Path("/hello")
	public static class HelloWorldResource {
		@GET
		public String getHello() {
			return "Hello, world!";
		}
	}

	@Path("/Eleve")
	public static class EleveResource {
		@GET
		@Path("/list")
		public static String getEleveList() {
			String ls = sess.listEleve();
			return ls;
		}

        @POST
		@Path("/create")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.APPLICATION_JSON)
		public static String createEleve(@FormParam("prenom") String p, @FormParam("nom") String n,
				@FormParam("id") String id) {

			// Convertissez le nombre en une chaîne

			JSONObject obj = new JSONObject();
			obj.put("id", id);
			obj.put("prenom", p);
			obj.put("nom", n);

			String ls = sess.createEleve(obj.toString());
			return ls;
		}

        @POST
        @Path("/search")
        @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
        @Produces(MediaType.APPLICATION_JSON)
        public static String getUE(@FormParam("id") String id) {
            JSONObject infos = new JSONObject();
            infos.put("id", id);
            String ls = sess.getUE(infos.toString());
            return ls;
        }

        
        @POST
        @Path("/delete")
        @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
        @Produces(MediaType.APPLICATION_JSON)
        public static String deleteEleve(@FormParam("id") String id) {
            JSONObject infos = new JSONObject();
            infos.put("UUID", id);
            String ls = sess.deleteEleve(infos.toString());
            return ls;
        }

    }

    @Path("/Sujet")
    public static class SujetResource {
        @GET
        @Path("/list")
        public static String getSujetList() {
            	String ls = sess.listSujet();
                return ls;
        }

        @POST
		@Path("/create")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.APPLICATION_JSON)
		public static String createGroupe(@FormParam("id") String id, @FormParam("titre") String tit,
				@FormParam("fin") String fi, @FormParam("jour") String jo) {

			// Convertissez le nombre en une chaîne

			JSONObject obj = new JSONObject();
			obj.put("id", id);
			obj.put("titre", tit);
			obj.put("fin", fi);
			obj.put("jour", jo);

			String ls = sess.createSujet(obj.toString());
			return ls;
		}

        @POST
        @Path("/search")
        @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
        @Produces(MediaType.APPLICATION_JSON)
        public static String getEleve(@FormParam("id") String id) {
            JSONObject infos = new JSONObject();
            infos.put("id", id);
            String ls = sess.getEleve(infos.toString());
            return ls;
        }

        
        @POST
        @Path("/delete")
        @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
        @Produces(MediaType.APPLICATION_JSON)
        public static String deleteSujet(@FormParam("id") String id) {
            JSONObject infos = new JSONObject();
            infos.put("UUID", id);
            String ls = sess.deleteSujet(infos.toString());
            return ls;
        }
    }

    @Path("/Groupe")
    public static class GroupeResource {
        @GET
        @Path("/list")
        public static String getGroupesList() {
            	String ls = sess.listGroupe();
                return ls;
        }

        @POST
        @Path("/search")
        @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
        @Produces(MediaType.APPLICATION_JSON)
        public static String getGroupe(@FormParam("id") String id) {
            JSONObject infos = new JSONObject();
            infos.put("id", id);
            String ls = sess.getGroupe(infos.toString());
            return ls;
        }

        @POST
        @Path("/create")
        @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
        @Produces(MediaType.APPLICATION_JSON)
        public static String createGroupe(@FormParam("id") String id,@FormParam("iEU") String iue, @FormParam("iEleve") String iel,@FormParam("iSujet") String isu ) {
                
                // Convertissez le nombre en une chaîne
                
                JSONObject obj = new JSONObject();
                obj.put("id", id);
                obj.put("ueID", iue);
                obj.put("eleveID", iel);
                obj.put("sujetID", isu);

                String ls = sess.createGroupe(obj.toString());
                return ls;
        }

        @POST
        @Path("/delete")
        @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
        @Produces(MediaType.APPLICATION_JSON)
        public static String deleteGroupe(@FormParam("id") String id) {
            JSONObject infos = new JSONObject();
            infos.put("UUID", id);
            String ls = sess.deleteGroupe(infos.toString());
            return ls;
        }
    }
  
    @Path("/UE")
    public static class UEResource {
        @GET
        @Path("/list")
        public static String getUEList() {
            	String ls = sess.listEU();
                return ls;
        }
        @POST
		@Path("/create")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.APPLICATION_JSON)
		public static String createUE(@FormParam("id") String id, @FormParam("code") String co,
				@FormParam("intitule") String inti, @FormParam("cours") String cou, @FormParam("td") String TD,
				@FormParam("tp") String TP, @FormParam("valeur") String val) {

			// Convertissez le nombre en une chaîne

			JSONObject obj = new JSONObject();
			obj.put("id", id);
			obj.put("code", co);
			obj.put("intitule", inti);
			obj.put("cours", cou);
			obj.put("td", TD);
			obj.put("tp", TP);
			obj.put("valeur", val);

			String ls = sess.createEU(obj.toString());
			return ls;
		}

        @POST
        @Path("/search")
        @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
        @Produces(MediaType.APPLICATION_JSON)
        public static String getUE(@FormParam("id") String id) {
            JSONObject infos = new JSONObject();
            infos.put("id", id);
            String ls = sess.getUE(infos.toString());
            return ls;
        }

        @POST
        @Path("/delete")
        @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
        @Produces(MediaType.APPLICATION_JSON)
        public static String deleteUE(@FormParam("id") String id) {
            JSONObject infos = new JSONObject();
            infos.put("UUID", id);
            String ls = sess.deleteEU(infos.toString());
            return ls;
        }
    }
}