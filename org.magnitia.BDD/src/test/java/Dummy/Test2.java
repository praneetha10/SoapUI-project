package Dummy;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test2 {

	public static void main(String[] args) throws Exception 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.gmail.com");
		driver.findElement(By.name("identifier")).sendKeys("magnitia251@gmail.com");
		driver.findElement(By.xpath("//span[text()='Next']/parent::button")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.name("password")).sendKeys("Magnit251");
		driver.findElement(By.xpath("//span[text()='Next']/parent::button")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//div[text()='Compose']")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("to")).sendKeys("praneetha.mullapudi@gmail.com");
		driver.findElement(By.name("subjectbox")).sendKeys("hi");
		driver.findElement(By.xpath("//div[@aria-label='Message Body']")).sendKeys("wishes");
		driver.findElement(By.xpath("//input[@type='file' and @name='Filedata']")).sendKeys("E:\\Samplepictures\\lavender.jpg");

	}

}
