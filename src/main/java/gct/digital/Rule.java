package gct.digital;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;


public class Rule {
	

   public String random(Map<String,String> serverMap) {
	   System.out.println("Random Rule in use");
	   if(serverMap.size() == 0){
		   return "0";
	   }
       ArrayList<String> srvIdList = new ArrayList<String>();
       srvIdList.addAll(serverMap.keySet());
       Random random = new Random();
       int rdm = random.nextInt(srvIdList.size());
       String server = srvIdList.get(rdm);
       return serverMap.get(server);
       
   }

   public String roundRobin(Map<String,Integer> serverMap, Integer pos) {
	   String server = null;
       ArrayList<String> srvIdList = new ArrayList<String>();
       srvIdList.addAll(serverMap.keySet());
       synchronized(pos){
           if (pos>=srvIdList.size()){
               return "out";
           }
           server=srvIdList.get(pos);
       }
       return server;
   }
   

  public String weightRobin(Map<String,Integer> serverMap, Integer pos){
	  String server = null;
      Set<String> serverSet=serverMap.keySet();
      Iterator<String> serverIterator=serverSet.iterator();
      ArrayList<String> srvIdList=new ArrayList<String>();
      while (serverIterator.hasNext()){
          String serverName=serverIterator.next();
          Integer weight=serverMap.get(serverName);
          for (int i = 0;i < weight ;i++){
        	  srvIdList.add(serverName);
          }
      }
      if (pos>=srvIdList.size()){
    	  return "out";
      }
      server=srvIdList.get(pos);
      
      return  server;
  }
   
}
