package stepDefinitions;


import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class stepDefinition {
	public WebDriver driver;
	
    @Given("^Open the browser and type the application URL$")
    public void open_the_browser_and_type_the_application_url() throws Throwable {
       System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chromedriver.exe");
       driver=new ChromeDriver();
       driver.get("https://opensource-demo.orangehrmlive.com/");
       System.out.println("OPENED THE BROWSER");
    }

    @When("^Give the valid credential$")
    public void give_the_valid_credential() throws Throwable {
       driver.findElement(By.id("txtUsername")).sendKeys("Admin");
       driver.findElement(By.id("txtPassword")).sendKeys("admin123");
       driver.findElement(By.id("btnLogin")).submit();
       System.out.println("CREDENTIAL PROVIDED FOR INPUT");
         
    }

    @Then("^Logged in succesfully$")
    public void logged_in_succesfully() throws Throwable {
    	
       System.out.println("hurray!! logged in");
       driver.findElement(By.id("welcome")).click();
       driver.findElement(By.id("aboutDisplayLink")).click();
       Thread.sleep(7000);
       driver.findElement(By.xpath("//a[@class='close'][1]")).click();
       Thread.sleep(7000);
       driver.findElement(By.id("welcome")).click();
       
       driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
       System.out.println("bye");
       driver.quit();
    }

}