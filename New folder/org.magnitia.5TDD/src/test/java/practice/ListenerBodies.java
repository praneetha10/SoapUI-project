package practice;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import utilities.TestUtility;

public class ListenerBodies implements ITestListener
{
	@Override //do not develop another method with same name		
    public void onFinish(ITestContext Result) 					
    {		
		Reporter.log("Thank you");
    }		
	
    @Override		
    public void onStart(ITestContext Result)					
    {		
    	System.out.println("Welcome, please go to reports");
    }
    
    @Override		
    public void onTestFailedButWithinSuccessPercentage(ITestResult Result)			
    {	
    	Reporter.log("Test passed within expected success percentage");
    }		

    @Override		
    public void onTestFailure(ITestResult Result)				
    {		
    	try
    	{
    		TestUtility tu=new TestUtility();
    		String fp=tu.captureScreenshot();
    		Reporter.log(Result.getName()+" Test failed");
    		Reporter.log(
				"<a href=\""+fp+"\"><img src=\""+fp+"\" height=\"100\" width=\"100\"/></a>"); 
    	}
    	catch(Exception ex)
    	{
    		Reporter.log(Result.getName()+" Test failed but an issue in screenshot capture");
    	}
    }		
    
    @Override		
    public void onTestSkipped(ITestResult Result)					
    {		
    	Reporter.log("The name of the testcase Skipped is :"+Result.getName());			
    }		

    @Override		
    public void onTestStart(ITestResult Result)					
    {		
    	Reporter.log(Result.getName()+" test case started");					
    }		
	
    @Override		
    public void onTestSuccess(ITestResult Result)					
    {		
    	Reporter.log("The name of the testcase passed is :"+Result.getName());			
    }		
}
