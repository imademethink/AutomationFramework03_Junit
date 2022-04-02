package pkg_stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.concurrent.TimeUnit;

public class StepDef_Login {

    WebDriver Driver    = null;
    String    sUrlLogin = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

    @Given("^User navigates to login screen$")
    public void User_navigates_to_login_screen(){
        String sChromeBinary=System.getProperty("user.dir") + "\\src\\browserDriver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", sChromeBinary);
        System.setProperty("webdriver.chrome.silentOutput", "true");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1400,800");
        options.addArguments("disable-infobars"); // disabling infobars
        options.addArguments("--disable-extensions"); // disabling extensions
        options.addArguments("--no-sandbox"); // Bypass OS security model
        options.setExperimentalOption("useAutomationExtension", false);

        Driver = new ChromeDriver(options);

        System.out.println("Log: Navigating to " + sUrlLogin);
        Driver.get(sUrlLogin);
        Driver.manage().timeouts().implicitlyWait(8000, TimeUnit.MILLISECONDS);
    }

    @When("^User attempts to login with valid credentials$")
    public void User_attempts_to_login_with_valid_credentials(){
        System.out.println("Log: Attempting to login with valid credentials");
        Driver.findElement(By.id("email")).sendKeys("creativity2020@mailinator.com");
        Driver.findElement(By.id("passwd")).sendKeys("creativity2020@@");
        Driver.findElement(By.cssSelector("i[class='icon-lock left']")).click();
        Driver.manage().timeouts().implicitlyWait(8000, TimeUnit.MILLISECONDS);
    }

    @Then("^Login should be successful$")
    public void Login_should_be_successful(){
        boolean bLoginSuccess = false;
        if(Driver.findElements(By.cssSelector("a[title='Log me out']")).size() > 0){
            bLoginSuccess = true;
        }
        Driver.quit();

        if(bLoginSuccess){
            System.out.println("Log: Login is successful");
        }
        else{
            Assert.fail("Log: Login is NOT successful");
        }
    }







    @Given("^User navigates to login screen empty$")
    public void User_navigates_to_login_screen_empty(){
        System.out.println("Log: Navigating to " + sUrlLogin);
    }

    @When("^User attempts to login with valid credentials empty$")
    public void User_attempts_to_login_with_valid_credentials_empty(){
        System.out.println("Log: Attempting to login with valid credentials empty");
    }

    @Then("^Login should be successful empty$")
    public void Login_should_be_successful_empty(){
        System.out.println("Log: Login is successful empty");
    }




    @Given("^This is empty2$")
    public void This_is_empty2(){
        System.out.println("Log: This is empty2");
    }
    @Given("^This is empty3$")
    public void This_is_empty3(){
        System.out.println("Log: This is empty3");
    }

}