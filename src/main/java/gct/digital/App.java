package gct.digital;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws FileNotFoundException
    {
    	Map<String, Integer> easWeightMap = new HashMap<String, Integer>();
    	 EAS eas = new EAS();
    	 String srv = eas.register("src/main/resources/server1.yaml");
    	 easWeightMap.put(srv, 1);
    	Rule rule = new Rule();
		String srvId = rule.random(easWeightMap);
	    System.out.println(srvId);
    }
}
