package practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(MyReporter.class)
public class Dummy19 
{
	@Test(priority=1,description="method1")
    public void method1()
    {
        //Pass test case
        Assert.assertTrue(true);

    }

    @Test(priority=2,description="method2")
    public void method2()
    {
        //Fail test case
        Assert.assertTrue(false);
    }
}

