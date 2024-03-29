package ohtu;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import java.util.*;
import ohtu.authentication.AuthenticationService;

public class Stepdefs {
    //WebDriver driver = new ChromeDriver();
    WebDriver driver = new HtmlUnitDriver();
    String baseUrl = "http://localhost:4567";
    UserDaoForTests dao = new UserDaoForTests();
    AuthenticationService auth = new AuthenticationService(dao);
     
    @Given("login is selected")
    public void loginIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click();   
    }  

    @Given("command new user is selected")
    public void commandNewSelected() throws Throwable {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click();   
    }  
    
    @When("correct username {string} and password {string} are given")
    public void correctUsernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }    
    
    @Then("user is logged in")
    public void userIsLoggedIn() {
        System.out.println(driver.getPageSource());
        pageHasContent("Ohtu Application main page");
    }    
 
    @When("correct username {string} and incorrect password {string} are given")
    public void correctUsernameAndIncorrectPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }    

    @When("incorrect username {string} and password {string} are given")
    public void incorrectUsernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }    

    @When("a valid username {string} and password {string} and matching password confirmation are entered")
    public void usernameAndPasswordAreEntered(String username, String password) {
        Random r = new Random();
        username = ("arto"+r.nextInt(100000));
        signUpWith(username, password, password);
    }

    @When("incorrect username {string} and password {string} and matching password confirmation are entered")
    public void incorrectUsernameAndPasswordAndMatchingPasswordConfirmationAreEntered(String username, String password) {
        signUpWith(username, password, password);
    }

    @When("a valid username {string} and password {string} and unmatching password confirmation are entered")
    public void aValidUsernameAndPasswordAndUnmatchingPasswordConfirmationAreEntered(String username, String password) {
        signUpWith(username, password, password+" ");
    }

    @When("user with username {string} with password {string} is successfully created")
    public void userWithUsernameAndPasswordIsSuccessfullyCreated(String username, String password) throws Throwable{
        commandNewSelected();
        signUpWith(username, password, password);
    }

    @When("user with username {string} and password {string} is tried to be created")
    public void userWithUsernameAndPasswordIsTriedToBeCreated(String username, String password) {
        auth.createUser(username, password, password);
    }

    
    @Then("user is not created and error {string} is reported")
    public void userIsNotCreatedAndErrorIsReported(String error) {
        pageHasContent(error);
    }

    @Then("user is not logged in and error message is given")
    public void userIsNotLoggedInAndErrorMessageIsGiven() {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    }

    @Then("a new user is created")
    public void newUserIsCreated() {
        pageHasContent("Welcome to Ohtu Application!");
    }      
    
    @After
    public void tearDown(){
        driver.quit();
    }
        
    /* helper methods */
 
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }

    private void logInWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Give your credentials to login"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();  
    } 
        
    private void signUpWith(String username, String password, String passwordConfirmation) {
        assertTrue(driver.getPageSource().contains("Create username and give password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(passwordConfirmation);
        element = driver.findElement(By.name("signup"));
        element.submit();  
    } 
}
