package Runners;
import java.util.Scanner;

import  Framworks.ReuseableMethods;

public class Runner1 {

	public static void main(String[] args) throws Exception
	{
		//Run in local host
		//Take test data from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter browser name");
		String bn=sc.nextLine();
		System.out.println("enter the url");
		String u=sc.nextLine();
		System.out.println("enter userid");
		String uid=sc.nextLine();
		System.out.println("enter userid criteria");
		String uidc=sc.nextLine();
		String pwd=null;
		String pwdc=null;
		if(uidc.equalsIgnoreCase("vaild"))
		{
			System.out.println("Enter password");
			pwd=sc.nextLine();
			System.out.println("Enter password criteria");
			pwdc=sc.nextLine();
			sc.close();
			//create object to ReuseableMethods class and call methods as per test scenario
			ReuseableMethods obj=new ReuseableMethods(bn);
			obj.launchsite(u);
			obj.fillandValidateLogin(uid,uidc,pwd,pwdc);
			obj.closeSite();
		}

	}

}
