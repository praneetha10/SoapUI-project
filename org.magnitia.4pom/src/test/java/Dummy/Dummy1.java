package Dummy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Properties;

public class Dummy1 {

	public static void main(String[] args) throws Exception
	{
		//Get os Properties (System Properties)info g directory
		System.out.println(System.getProperty("os.name"));//Operating System name
		System.out.println(System.getProperty("user.dir"));
		//Get environment variable info at system or user
		/*System.out.println(System.getenv("JAVA_HOME"));
		ProcessBuilder pb= new ProcessBuilder();
	    Map<String,String>envmap=pb.environment();
	    for(Map.Entry<String,String>e:envmap.entrySet())
	    {
	    	System.out.println(e.getKey()+"<=>"+e.getValue());
	    }
	    //Get properties info in our properties file
	    File f=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
	    FileInputStream fi=new FileInputStream(f);
	    Properties p=new Properties();
	    p.load(fi);
	    System.out.println(p.getProperty("url"));
	    System.out.println(p.getProperty("maxwait"));
	    System.out.println(p.getProperty("uri"));*/
	    
	}

}
