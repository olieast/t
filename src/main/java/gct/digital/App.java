package gct.digital;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class App {
	public static void main(String[] args) throws FileNotFoundException {

		Scanner scan = new Scanner(System.in);
		System.out.print(Utils.showHelpInfo());

		ELB elb = new ELB();
		Map<String, String> serverMap = elb.serverMap;

		while (true) {
			int num = scan.nextInt();
			if (num == 1) {
				System.out.println("ELB starts, Random is used as Load Banlancer Rule");
				Rule rule = new Rule();
				rule.random(serverMap);
				System.out.println("The number of instances are in service: " + serverMap.size());

			} else if (num == 2) {
				System.out.println("Start 3 elb instances with AppEngine configured");
				ArrayList<String> srvListAll = elb.getAllServers();
				for (String s : srvListAll) {
					elb.register(s);
				}
				System.out.println("The number of instances are in service: " + serverMap.size());

			} else if (num == 3) {
				System.out.println("Kill one elb instance randomly");
				if (serverMap.size() == 0) {
					System.out.println("No instance is in service");
				}
				ArrayList<String> srvList = new ArrayList<String>();
				srvList.addAll(serverMap.keySet());
				Random random = new Random();
				int rdm = random.nextInt(srvList.size());
				String server = srvList.get(rdm);
				elb.deRegister(server);
				System.out.println("The number of instances are in service: " + serverMap.size());

			} else if (num == 4) {
				System.out.println("Statr one new elb instance");
				ArrayList<String> srvListAll = elb.getAllServers();
				ArrayList<String> srvListCur = new ArrayList<String>();
				ArrayList<String> srvList = new ArrayList<String>();
				srvListCur.addAll(serverMap.keySet());
				for (int i = 0; i < srvListAll.size(); i++) {
					if (!srvListCur.contains(srvListAll.get(i))) {
						srvList.add(srvListAll.get(i));
					}
				}
				// note to process size later
				Random random = new Random();
				int rdm = random.nextInt(srvList.size());
				String server = srvList.get(rdm);
				System.out.println(server);
				elb.register(server);
				System.out.println("The number of instances are in service: " + serverMap.size());

			} else if (num == 5) {
				System.out.println("Change Load Balance Rule of ELB");

			} else if (num == 6) {
				System.out.println("Show Status of ELB and available eas Servers");
//				later add health check
				if (elb == null) {
					System.out.println("ELB not started...");
				} else {
					System.out.println("ELB is in service...");
					System.out.println("The number of instances are in service: " + serverMap.size());
				}

			} else if (num == 7) {
				System.out.println("send a /customer request to ELB,and display the output from AppEngine");
				// random rule
				Rule rule = new Rule();
				String eas_in_service = rule.random(serverMap);
				System.out.println(eas_in_service);
				// to do other rule

			} else if (num == 8) {
				System.out.println("Exit System succeed");
				break;

			} else {
				System.out.print(Utils.showHelpInfo());

			}
		}

	}
}
