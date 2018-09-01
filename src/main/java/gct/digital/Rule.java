package gct.digital;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class Rule {
   public String random(Map<String,Integer> serverMap) {
       ArrayList<String> srvIdList = new ArrayList<String>();
       srvIdList.addAll(serverMap.keySet());
       Random random = new Random();
       int rdm = random.nextInt(srvIdList.size());
       String server = srvIdList.get(rdm);
       return server;
   }
   
}
