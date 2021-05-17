package tests;

import java.util.Scanner;

import classes.ReusableMethods;

public class Runnerclasses {

	public static void main(String[] args) throws Exception 
	{
		//Run in local host
		//Take testdata fromkeyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("enter browser name");
		String bn=sc.nextLine();
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
			pwdc=sc.nextLine();
		}
		
		ReusableMethods obj=new ReusableMethods(bn);
		obj.launchsite(u);
		obj.FillAndValidateLogin(uid, uidc,pwd,pwdc);
		obj.closesite();
		
		
	}

}
