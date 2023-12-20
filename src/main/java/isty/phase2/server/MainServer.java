package isty.phase2.server;

import isty.phase2.Groupe.GroupeImplementation;
import isty.phase2.server.ServerConfig;

import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONObject;

public class MainServer {

    private static GroupeImplementation sess = new GroupeImplementation();

    public static void main(String[] args) {
        MainServer mainServer = new MainServer();
        mainServer.startServer();
    }

    private void startServer(){
    	ServerConfig.configCheck();
    	ServerConfig conf = ServerConfig.loadConfig();
        URI baseUri = UriBuilder.fromUri(conf.getAdress()).port(conf.getPort()).build();
        ResourceConfig config = new ResourceConfig(HelloWorldResource.class,EleveResource.class,SujetResource.class,GroupeResource.class,UEResource.class);
        JdkHttpServerFactory.createHttpServer(baseUri, config);
        System.out.println("Server started at " + baseUri);

        initDatabase(sess);
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
        public static String createEleve(@FormParam("prenom") String p, @FormParam("nom") String n,@FormParam("id") String id ) {
            	
                // Convertissez le nombre en une chaîne
				
				JSONObject obj = new JSONObject();
				obj.put("id", id);
				obj.put("prenom", p);
				obj.put("nom", n);

                String ls = sess.createEleve(obj.toString());
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
        @Path("/create")
        @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
        @Produces(MediaType.APPLICATION_JSON)
        public static String createGroupe(@FormParam("prenom") String p, @FormParam("nom") String n,@FormParam("id") String id ) {
            	
                // Convertissez le nombre en une chaîne
				
				JSONObject obj = new JSONObject();
				obj.put("id", id);
				obj.put("prenom", p);
				obj.put("nom", n);

                String ls = sess.createEleve(obj.toString());
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
    }

}
