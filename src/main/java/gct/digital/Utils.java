package gct.digital;

public class Utils {
	public static String showHelpInfo(){
		String helpInfo = "welcome to Distributed System, here are the commands you can execute:\n"
				+ "1)  Start ElB with default Random Load Balance Rule\n"
				+ "2)  Start 3 EAS instances with AppEngine configured\n"
				+ "3)  Kill one EAS instance randomly(this is called Monkey in chaos Engineering)\n"
				+ "4)  Statr one new EAS instance \n"
				+ "5)  Change Load Balance Rule of ELB\n"
				+ "6)  Show Status of ELB and available EAS Servers\n"
				+ "7)  send a /customer request to ELB,and display the output from AppEngine\n"
				+ "8)  Exit the system.\n";
				
		return helpInfo;
	}
}
