package Dummy;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import UtilityClasses.TestUtility;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class Dummy23 
{
	public TestUtility tu;
	public ATUTestRecorder recorder;
	public String vp;
	@BeforeMethod
	public void method1(Method m) throws Exception
	{
		SimpleDateFormat sf=new SimpleDateFormat("dd-MMM-yyyy-hh-mm-ss");
		Date dt=new Date();
		vp= "target\\"+m.getName()+"_"+sf.format(dt);
		recorder=new ATUTestRecorder(vp,false);
		recorder.start();
	}
	@Test(priority=1)
	public void method2()throws Exception
	{
		tu=new TestUtility();
		tu.OpenBrower("chrome");
		tu.launchsite("https://www.magnitia.com");
		Thread.sleep(5000);
		tu.closeSite();
	}
	@Test(priority=2)
	public void method3() throws Exception
	{
		recorder.stop();
		tu=new TestUtility();
		tu.OpenBrower("edge");
		tu.launchsite("https://www.gmail.com");
		Thread.sleep(5000);
		tu.closeSite();
	}
	@AfterMethod
	public void method4() throws ATUTestRecorderException
	{
		recorder.stop();
		
	}
	

}
