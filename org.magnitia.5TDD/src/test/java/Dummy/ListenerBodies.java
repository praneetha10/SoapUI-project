package Dummy;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import UtilityClasses.TestUtility;

public class ListenerBodies implements ITestListener
{
	@Override
	public void onFinish(ITestContext Result)
	{
		Reporter.log("Thank you");
	}
	@Override
	public void onStart(ITestContext Result)
	{
		System.out.println("please go to reports");
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult Result)
	{
		Reporter.log("testpassed within expected sucesspercentage");
	}
	@Override
	public void onTestFailure(ITestResult Result)
	{
		try
		{
			TestUtility tu=new TestUtility();
			String fp=tu.captureScreenShort();
			Reporter.log(Result.getName()+"TestFailed");
			Reporter.log("<a href=\""+fp+"\"><img src=\""+fp+"\"height=\"100\"width=\"100\"/></a>");
		}
		catch(Exception ex)
		{
			Reporter.log(Result.getName()+"Test failed but an issue in exception");
		}
	}
	@Override
	public void onTestSkipped(ITestResult Result)
	{
		Reporter.log("The name of the testcase skipped is"+Result.getName());
	}
	@Override
	public void onTestStart(ITestResult Result)
	{
		Reporter.log(Result.getName()+"testcase started");
	}
	@Override
	public void onTestSuccess(ITestResult Result)
	{
		Reporter.log("The name of the testcase is passed"+Result.getTestName());
	}
	

}
