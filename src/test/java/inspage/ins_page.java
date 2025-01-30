
package inspage;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class ins_page {
    WebDriver driver;

    By getquote = By.xpath("//body/main[@id='app']/section[1]/div[1]/span[1]/a[1]");
    By carMakeInput = By.xpath("//*[@id='sk-Motor-capturedData-carInformation-VehicleMakeModelTrimEngineFlexdata']/div[2]/span/div/div[1]/input");
    By carModelInput = By.xpath("//*[@id='sk-navigation-CreateMotorQuoteProcessVehicleUIDef-FieldsetGroup1-car1']");
    By manufactureYearDropdown = By.xpath("//*[contains(@id, 'VehicleYearNewFlexdata')]/div/select");
    By yesOption = By.xpath("//*[@id='sk-Motor-capturedData-carInformation-isCarGccSpecAndNonModified']/div[2]/div/span[1]/label/div");
    By emaratesDropdown = By.id("sk-Motor-capturedData-carInformation-placeOfRegistration");
    By emiratesOption = By.xpath("//*[@id='sk-Motor-capturedData-carInformation-placeOfRegistration']/div[2]/div/div/div[1]/div[1]");
    By registrationDate = By.id("registrationDateElement");
    By vehicleUsageDropdown = By.id("vehicleUsage");
    By submitButton = By.id("submitQuote");

    public ins_page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void firstpage() {
        driver.findElement(getquote).click();
    }

    public void selectCarMake(String make) {
        WebElement carMake = driver.findElement(carMakeInput);
        carMake.sendKeys(make);
    }

   /* public void selectCarModel(String model) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement carModel = wait.until(ExpectedConditions.elementToBeClickable(carModelInput));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", carModel);
        carModel.sendKeys(model);
        System.out.println("Entered Car Model: " + model);

        WebElement carModelOption = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'dropdown-item') and text()='" + model + "']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", carModelOption);
        System.out.println("Selected Car Model from dropdown: " + model);
    }*/
   /* public void selectCarModel(String model) throws Exception  {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        try {
            // Click to open dropdown
            WebElement carModelField = driver.findElement(carModelInput);
            carModelField.click();
            Thread.sleep(2000);  // Small wait to allow dropdown to load

            // Type the model name to filter results
            carModelField.sendKeys(model);
            Thread.sleep(2000);  

            // Wait for the model option to appear
            WebElement carModelOption = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[contains(@class,'dropdown-item') and contains(text(),'" + model + "')]")
            ));

            // Scroll to the option and click
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", carModelOption);
            carModelOption.click();

            System.out.println("Selected Car Model: " + model);
        } catch (Exception e) {
            System.out.println("Error selecting car model: " + e.getMessage());
            throw e;  
        }
    }*/
 // Method to select car model
    public void selectCarModel(String model) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // Wait for the dropdown to be visible and clickable
        WebElement carModelDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sk-navigation-CreateMotorQuoteProcessVehicleUIDef-FieldsetGroup1-car1']"))); // Replace with actual XPath
        
        // Scroll the element into view if it's not already in view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", carModelDropdown);

        // Now try to interact with the element
        try {
            carModelDropdown.sendKeys(model);
            System.out.println("Car model selected: " + model);
        } catch (Exception e) {
            System.out.println("Error selecting car model: " + e.getMessage());
        }
    }

    public void selectManufactureYear(String year) {
        WebElement yearDropdown = driver.findElement(manufactureYearDropdown);
        yearDropdown.sendKeys(year);
    }

    public void selectoption(String type) {
        if (type.equalsIgnoreCase("yes")) {
            driver.findElement(yesOption).click();
        }
    }

    public void selectEmarates() {
        driver.findElement(emaratesDropdown).click();
    }

    public void selectEmarate(String emirate) {
        WebElement emirateOption = driver.findElement(By.xpath("//div[text()='" + emirate + "']"));
        emirateOption.click();
    }

    public void enterRegistrationdate(String regNumber) {
        WebElement regDateField = driver.findElement(registrationDate);
        regDateField.sendKeys(regNumber);
    }

    public String selecteddate(String string) {
        WebElement regDateField = driver.findElement(registrationDate);
        String registrationDateText = regDateField.getAttribute("value");
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = inputFormat.parse(registrationDateText);
            SimpleDateFormat outputFormat = new SimpleDateFormat("MM-yyyy");
            return outputFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return "Invalid Date Format";
        }
    }

    public void selectVehicleUsage(String usage) {
        WebElement usageDropdown = driver.findElement(vehicleUsageDropdown);
        usageDropdown.sendKeys(usage);
    }

    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }
}
