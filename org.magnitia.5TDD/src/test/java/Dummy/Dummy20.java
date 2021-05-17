package Dummy;

import java.util.Objects;

import org.testng.annotations.Factory;

public class Dummy20 
{
	@Factory()
	public Object[] Multiclass()
	{
		Dummy1 obj1=new Dummy1();
		Dummy2 obj2=new Dummy2();
		Object[] tests=new Objects[2];
		tests[0]=obj1;
		tests[1]=obj2;
		return(tests);
		
	}

}
