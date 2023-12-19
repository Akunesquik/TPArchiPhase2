package isty.phase2.server;

import isty.phase2.Groupe.Eleve;
import isty.phase2.server.ServerConfig;

import java.util.logging.Logger;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

public class MainServer {
	private static Logger logger = Logger.getLogger(MainServer.class.getSimpleName());
	
    public static void main(String[] args) {
    	ServerConfig.configCheck();
    	ServerConfig serverConf = ServerConfig.loadConfig();
        URI baseUri = UriBuilder.fromUri(serverConf.getAdress()).port(serverConf.getPort()).build();
        ResourceConfig config = new ServerRessources();
        JdkHttpServerFactory.createHttpServer(baseUri, config);
        logger.info("Server started at " + baseUri);
    }

}
