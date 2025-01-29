package inspage;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ins_page {
WebDriver driver;
	
	By getquote =By.xpath("//body/main[@id='app']/section[1]/div[1]/span[1]/a[1]");

	By carMakeDropdown = By.xpath("1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/span[1]/div[1]/div[1]/input[1]"); 
   By carModelDropdown = By.id("react-autowhatever-Motor-capturedData-carInformation-VehicleMakeModelTrimEngineFlexdata--item-22"); 
    By manufactureYearDropdown = By.xpath("//*[contains(@id, 'VehicleYearNewFlexdata')]/div/select\""); 
    By yesoption=By.xpath("\"//label[text()='Yes");
    
By emaratesdrop=By.id("sk-Motor-capturedData-carInformation-placeOfRegistration");
By emarated=By.xpath("//*[@id=\"sk-Motor-capturedData-carInformation-placeOfRegistration\"]/div[2]/div/div/div[1]/div[1]");
    By registrationdate = By.id("//*[@id='registrationDateElement']\")"); 
    By vehicleUsageDropdown = By.id("vehicleUsage"); 
    By submitButton = By.id("submitQuote");


public ins_page (WebDriver driver)
{
	this.driver=driver;
	
    PageFactory.initElements(driver, this);
}
public void firstpage()
{
	driver.findElement(getquote).click();
	
}

public void selectCarMake(String make) 
{
   Select select = new Select(driver.findElement(carMakeDropdown));
    select.selectByVisibleText(make);
}

public void selectCarModel(String model) {
   Select select = new Select(driver.findElement(carModelDropdown));
    select.selectByVisibleText(model);
}
public void selectManufactureYear(String year) {
    Select select = new Select(driver.findElement(manufactureYearDropdown));
    select.selectByVisibleText(year);
}
public void selectoption(String type)
{
	Select select=new Select(driver.findElement(yesoption));
	select.selectByVisibleText(type);
	driver.findElement(yesoption).click();
	
}
public void selectEmarates()
{
	
	driver.findElement(emaratesdrop).click();
	
	
}
public void selectEmarate(String emar)
{
	Select select=new Select(driver.findElement(emarated));
	select.selectByVisibleText(emar);
	
	
}

//public void enterRegistrationdate(String regNumber) {
    //driver.findElement(registrationdate).sendKeys(regNumber);
//}
public String selecteddate(String string) {
    String registrationDateText = ((WebElement) registrationdate).getText();

    // Print the raw extracted date (for debugging purposes)
    System.out.println("Raw Registration Date: " + registrationDateText);

    // Assuming the extracted date is in "dd/MM/yyyy" format (Adjust based on actual format)
    try {
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = inputFormat.parse(registrationDateText);

        // Format the date to "MM-yyyy"
        SimpleDateFormat outputFormat = new SimpleDateFormat("MM-yyyy");
        return outputFormat.format(date);
    } catch (Exception e) {
        e.printStackTrace();
        return "Invalid Date Format";  // Return error message in case of exception
    }
}

public void selectVehicleUsage(String usage) {
    Select select = new Select(driver.findElement(vehicleUsageDropdown));
    select.selectByVisibleText(usage);
}

public void clickSubmit() {
    driver.findElement(submitButton).click();
}
}