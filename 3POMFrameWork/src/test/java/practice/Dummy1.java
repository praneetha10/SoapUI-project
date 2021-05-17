package practice;

import java.io.File;
import java.io.FileInputStream;

import java.util.Map;
import java.util.Properties;

public class Dummy1 {

	public static void main(String[] args) throws Exception 
	{
		//Get OS properties(System properties) info
		System.out.println(System.getProperty("user dir"));//working directory
		System.out.println(System.getProperty("os.name"));//Operating system
		//Get environment variables info at system or user
		System.out.println(System.getenv("JAVA-HOME"));
		ProcessBuilder pb=new ProcessBuilder();
		Map<String,String>envMap=pb.environment();
		for(Map.Entry<String,String>e:envMap.entrySet())
		{
			System.out.println(e.getKey()+"<=>"+e.getValue());
		}
		//Get properties info in our properties file
		File f=new File(System.getProperty("user.dir") +"\\src\\test\\resources\\config.Properties");
		FileInputStream fi=new FileInputStream(f);
		Properties p=new Properties();
		p.load(fi);
		System.out.println(p.getProperty("maxwait"));
		System.out.println(p.getProperty("uri"));
	}

}
