package isty.phase2.Groupe;

import java.util.logging.Logger;

import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriBuilderException;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;

public class ClientConfig {
	static final String configDir = "clientConfig";
	static final String configFile = "clientConfig.json";
	private static Logger logger = Logger.getLogger(ClientConfig.class.getSimpleName());
	private int port;
	private String adress;

	public ClientConfig(String adress, int port) {
		this.adress = adress;
		this.port = port;
	}

	public static void configCheck() {
		Path currentPath = Paths.get("");
		Path configDirPath = currentPath.resolve(configDir);
		if (Files.exists(configDirPath) && Files.isDirectory(configDirPath)) {
		} else {
			try {
				Files.createDirectory(configDirPath);
				logger.info("Create client configurtion folder");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Path configFilePath = configDirPath.resolve(configFile);
		if (Files.exists(configFilePath) && Files.isReadable(configFilePath)) {
			logger.info("Find client configurtion file");
		} else {
			try {
				Files.createFile(configFilePath);
				initJSON(configFilePath);
			} catch (IOException e) {
				e.printStackTrace();
			}
			logger.info("Create a default client configurtion file");
		}
	}

	public static ClientConfig loadConfig() {
		ClientConfig config = readJSON(Paths.get("").resolve(configDir).resolve(configFile));
		if (config.getPort() < 0 || config.getPort() > 65535) {
			throw new IllegalArgumentException("Bad port number");
		}
		return config;
	}

	public static void initJSON(Path filePath) {
		ClientConfig conf = new ClientConfig("http://localhost/", 8080);
		Gson gson = new Gson();
		String jsonString = gson.toJson(conf);
		try (FileWriter writer = new FileWriter(filePath.toAbsolutePath().toString())) {
			writer.write(jsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static ClientConfig readJSON(Path filePath) {
		ClientConfig conf = new ClientConfig("http://localhost/", 8080);
		try (FileReader reader = new FileReader(filePath.toAbsolutePath().toString())) {
			Gson gson = new Gson();
			conf = gson.fromJson(reader, ClientConfig.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return conf;
	}
	
	public String getURL()
	{
		try {
			return UriBuilder.fromUri(adress).port(port).build().toString();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (UriBuilderException e) {
			e.printStackTrace();
		}
		return adress + port;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

}
