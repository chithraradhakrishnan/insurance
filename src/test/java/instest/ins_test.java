package instest;




import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import inspage.ins_page;




public class ins_test {
	WebDriver driver;
	@BeforeTest
	public void setup()
	{
		driver =new ChromeDriver();
		
	}
@BeforeMethod
public void openurl()
{
	driver.get("https://protego.ae/home-page.html");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

}
@Test
public void first()
{
	//object creation
	 ins_page ob=new ins_page(driver);
	 ob.firstpage();
	 ob.selectCarMake("Ford");
     ob.selectCarModel("FORD ECOSPORT TRENT 1.5L");
    ob.selectManufactureYear("2022");
   ob. selectoption("yes");
   ob.selectEmarates();
   ob.selectEmarate("sharja");
   
   String formattedDate = ob.selecteddate("27/01/2025");
   System.out.println("Formatted Registration Date (MM-yyyy): " + formattedDate);
  
 
     ob.selectVehicleUsage("Personal");

     // Submit the form
     ob.clickSubmit();

     //Verification (update the logic based on the actual website behavior)
    String currentURL = driver.getCurrentUrl();
   Assert.assertTrue(currentURL.contains("success"), "Quote submission failed!");
 }
 
 }	 
	
	


