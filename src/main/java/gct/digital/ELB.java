package gct.digital;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class ELB {

	Map<String, String> serverMap = new HashMap<String, String>();

	public String register(String server) throws FileNotFoundException {
		Yaml yaml = new Yaml();
		File f = new File(server);
		Map<String, String> result = (Map<String, String>) yaml.load(new FileInputStream(f));
		serverMap.put(server, result.toString());
		return result.toString();

	}

	public String deRegister(String server) throws FileNotFoundException {
		serverMap.remove(server);
		return server;

	}

	public ArrayList<String> getAllServers() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("src/main/resources/server1.yaml");
		list.add("src/main/resources/server2.yaml");
		list.add("src/main/resources/server3.yaml");
		return list;
	}
}
