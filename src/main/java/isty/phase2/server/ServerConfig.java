package isty.phase2.server;

import java.util.logging.Logger;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ServerConfig {
	static final String configDir = "serverConfig";
	static final String configFile = "serverConfig.json";
	private static Logger logger = Logger.getLogger(ServerConfig.class.getSimpleName());
	private int port;
	private String adress;

	public ServerConfig(String adress, int port) {
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
				logger.info("Create server configurtion folder");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Path configFilePath = configDirPath.resolve(configFile);
		if (Files.exists(configFilePath) && Files.isReadable(configFilePath)) {
			logger.info("Find server configurtion file");
		} else {
			try {
				Files.createFile(configFilePath);
				initJSON(configFilePath);
			} catch (IOException e) {
				e.printStackTrace();
			}
			logger.info("Create a default server configurtion file");
		}
	}

	public static ServerConfig loadConfig(){
		ServerConfig config = readJSON(Paths.get("").resolve(configDir).resolve(configFile));
		if(config.getPort() < 0 ||config.getPort() > 65535 )
		{
			throw new IllegalArgumentException("Bad port number");
		}
		return config;
	}

	public static void initJSON(Path filePath) {
		ServerConfig conf = new ServerConfig("http://localhost/", 8080);
		Gson gson = new Gson();
		String jsonString = gson.toJson(conf);
		try (FileWriter writer = new FileWriter(filePath.toAbsolutePath().toString())) {
			writer.write(jsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static ServerConfig readJSON(Path filePath) {
		ServerConfig conf = new ServerConfig("http://localhost/", 8080);
		try (FileReader reader = new FileReader(filePath.toAbsolutePath().toString())) {
			Gson gson = new Gson();
			conf = gson.fromJson(reader, ServerConfig.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return conf;
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
