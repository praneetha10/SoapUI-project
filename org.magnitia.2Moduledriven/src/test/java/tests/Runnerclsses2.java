package tests;

import java.util.Scanner;

import classes.ReusableMethods;
public class Runnerclsses2 {

	public static void main(String[] args) throws Exception
	{
		//Take testdata from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("enter environment(local/cloud)");
		String env=sc.nextLine();
		System.out.println("enter browser name");
		String bn=sc.nextLine();
		String v=null;
		String os=null;
		if(env.equalsIgnoreCase("cloud"))
		{
			System.out.println("enter browser version");
			v=sc.nextLine();
			System.out.println("enter os(windows/mac/linux)");
			os=sc.nextLine();
		}
		System.out.println("enter url");
		String u=sc.nextLine();
		
		System.out.println("enter userid");
		String uid=sc.nextLine();
		
		System.out.println("enter userid criteria");
		String uidc=sc.nextLine();
		String pwd=null;
		String pwdc=null;
		if(uidc.equalsIgnoreCase("vaild"))
		{
			System.out.println("enter password");
			pwd=sc.nextLine();
			System.out.println("enter password criteria");
			pwd=sc.nextLine();
		}
		//create object to ReusebleMethods class
		ReusableMethods obj;
		if(env.equalsIgnoreCase("local"))
		{
			obj=new ReusableMethods(bn);
		}
		else
		{
			obj=new ReusableMethods(bn,v,os);
		}
		obj.launchsite(u);
		obj.FillAndValidateLogin(uid,uidc,pwd, pwdc);
		obj.closesite();
		
		

	}

}
