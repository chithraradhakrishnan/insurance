package instest;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import inspage.ins_page;

public class ins_test {
    WebDriver driver;
    ins_page ob; // Page Object instance

    @BeforeTest
    public void setup() {
        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            ob = new ins_page(driver); // Initialize Page Object
        } catch (Exception e) {
            System.out.println("Error in setup: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @BeforeMethod
    public void openurl() {
        try {
            driver.get("https://protego.ae/home-page.html");
        } catch (Exception e) {
            System.out.println("Error while opening the URL: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void testInsuranceForm() {
        try {
            System.out.println("Starting test: Insurance Quote Submission");

            // Click 'Get Quote'
            ob.firstpage();
            System.out.println("Clicked 'Get Quote' button.");

            // Select car details
            ob.selectCarMake("Ford");
            System.out.println("Entered Car Make: Ford");

            ob.selectCarModel("FORD B-MAX STANDARD 1.4 L");
            System.out.println("Selected Car Model: FORD B-MAX STANDARD 1.4 L");

            ob.selectManufactureYear("2022");
            System.out.println("Selected Manufacture Year: 2022");

            // Select GCC Spec
            ob.selectoption("yes");
            System.out.println("Selected GCC Spec: Yes");

            // Select Emirates
            ob.selectEmarates();
            ob.selectEmarate("Sharjah");
            System.out.println("Selected Emirates: Sharjah");
        

           // Enter and verify registration date
            String formattedDate = ob.selecteddate("27/01/2025");
            System.out.println("Formatted Registration Date (MM-yyyy): " + formattedDate);

            // Select vehicle usage
            ob.selectVehicleUsage("Personal");
            System.out.println("Selected Vehicle Usage: Personal");

            // Submit the form
            ob.clickSubmit();
            System.out.println("Clicked Submit button.");

            // Verification (Example: Check if the success message appears)
            String currentURL = driver.getCurrentUrl();
            Assert.assertTrue(currentURL.contains("success"), "Quote submission failed!");
            System.out.println("Test Passed: Quote submitted successfully.");
        } catch (Exception e) {
            System.out.println("Test execution failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @AfterTest
    public void teardown() {
        try {
            if (driver != null) {
                driver.quit();
                System.out.println("Browser closed.");
            }
        } catch (Exception e) {
            System.out.println("Error during teardown: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
    

