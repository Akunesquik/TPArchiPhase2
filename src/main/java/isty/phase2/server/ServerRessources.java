package isty.phase2.server;

import isty.phase2.Groupe.Eleve;
import isty.phase2.server.ServerConfig;

import java.util.logging.Logger;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;


@ApplicationPath("/api")
public class ServerRessources extends ResourceConfig {
    public ServerRessources() {
        register(EleveRessource.class);
        isRegistered(EleveRessource.class);
    }
}
