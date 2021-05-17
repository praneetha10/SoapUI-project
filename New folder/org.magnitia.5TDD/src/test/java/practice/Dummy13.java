package practice;

import org.testng.annotations.Factory;

public class Dummy13 
{
	@Factory()
	public Object[] multiClasses() 
	{
		//Create objects to runner classes
		Dummy1 obj1=new Dummy1();
		Dummy2 obj2=new Dummy2();
		//store runner classes objects into an array
		Object[] tests=new Object[2];
		tests[0]=obj1;
		tests[1]=obj2;
		//return that array to TestNG to run corresponding runner classes sequentially
		return(tests);
	}
}
