package isty.phase2.server;

import isty.phase2.Groupe.GroupeImplementation;
import isty.phase2.server.ServerConfig;

import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
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
        ResourceConfig config = new ResourceConfig(EleveResource.class);
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
    }

}
