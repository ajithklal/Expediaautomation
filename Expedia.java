package testng;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Expedia {

	WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
		
	}
	@BeforeMethod
	public void loading()
	{
		driver.get("https://www.expedia.com/");
		driver.manage().window().maximize();;
	}
	@Test
	public void test()
	{
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//*[@id=\"wizardMainRegionV2\"]/div/div/div/div/ul/li[2]/a/span")).click();
		driver.findElement(By.xpath("//*[@id=\"uitk-tabs-button-container\"]/div[1]/li[2]/a")).click();
		
		
		driver.findElement(By.xpath("//*[@id=\"location-field-leg1-origin-menu\"]/div[1]/div[1]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"location-field-leg1-origin\"]")).sendKeys("Brussels",Keys.ENTER);
        
		driver.findElement(By.xpath("//*[@id=\"location-field-leg1-destination-menu\"]/div[1]/div[1]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"location-field-leg1-destination\"]")).sendKeys("Newyork",Keys.ENTER);
		driver.findElement(By.xpath("//*[@id=\"adaptive-menu\"]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"adaptive-menu\"]/div/div/div/div[2]/section/div[1]/div[2]/div/button[2]")).click();
		Select age=new Select(driver.findElement(By.xpath("//*[@id=\"child-age-input-0-0\"]")));
		age.selectByValue("3");
		driver.findElement(By.xpath("//*[@id=\"adaptive-menu\"]/div/div/div/div[3]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"d1-btn\"]")).click();
		
		
		while(true)
		{
			WebElement month=driver.findElement(By.xpath("//*[@id=\"wizard-flight-tab-oneway\"]/div[2]/div[2]/div/div/div/div/div[2]/div/div[1]/div[2]/div[1]/h2"));
			
			String month1 = month.getText();
			
			if(month1.contains("April 2023"))
			{
			System.out.println(month1);
		     break;
			}
			
			else
			{
				driver.findElement(By.xpath("//*[@id=\"wizard-flight-tab-oneway\"]/div[2]/div[2]/div/div/div/div/div[2]/div/div[1]/div[1]/button[2]")).click();
			}
			
			
		}
		
		List <WebElement> dates = driver.findElements(By.xpath("//*[@id=\"wizard-flight-tab-oneway\"]/div[2]/div[2]/div/div/div/div/div[2]/div/div[1]/div[2]/div[1]/table/tbody/tr/td/button"));
		for(WebElement dateelement:dates)
		{
			String date=dateelement.getAttribute("data-day");
			
			if(date.equals("18"))
			{
				dateelement.click();
				System.out.println(date);
				System.out.println("date selected");
			}
			
			
		}
		driver.findElement(By.xpath("//*[@id=\"wizard-flight-tab-oneway\"]/div[2]/div[2]/div/div/div/div/div[2]/div/div[2]/div/button")).click();
		driver.findElement(By.xpath("//*[@id=\"wizard-flight-pwa-1\"]/div[3]/div[2]/button")).click();
		
	}
	
		
	
}
