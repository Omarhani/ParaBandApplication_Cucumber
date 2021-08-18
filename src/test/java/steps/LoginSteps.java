package steps;

import BaseUtils.Utils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSteps  {

//    private Utils utils;
    public String userFullName;
    private WebDriver driver;

//    public LoginSteps(Utils util){
//        this.utils = util;
//    }

    @Given("I am in login of ParaBank application")
    public void i_am_in_login_of_para_bank_application() {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }

    @When("I entre a valid {string} and {string} with {string}")
    public void i_entre_a_valid_credentials(String username,String password,String userFullName1) {

        userFullName = userFullName1;

        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @Then("I should be taken in Overview page")
    public void i_should_be_taken_in_overview_page(){
        driver.findElement(By.xpath("//h1[@class='title']")).isDisplayed();

        String actualUserFullName = driver.findElement(By.xpath("//p[@class='smallText']")).getText();
        System.out.println(actualUserFullName);

        driver.findElement(By.linkText("Log Out")).click();

    }
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
