package gct.digital;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class EAS {

	public String register(String server) throws FileNotFoundException {
		Yaml yaml = new Yaml();
		File f = new File(server);
		Object result = yaml.load(new FileInputStream(f));
		
		System.out.println(result.getClass());
		System.out.println(result);
		return "server";
	}
}
