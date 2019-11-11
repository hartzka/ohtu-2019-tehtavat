package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import java.util.*;

public class Tester {

    public static void main(String[] args) {
        //WebDriver driver = new ChromeDriver();

        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://localhost:4567");
        // tulostetaan sivu konsoliin
        System.out.println(driver.getPageSource());
        
        sleep(2);
        
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("wrongpassword");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();

        WebElement element2 = driver.findElement(By.linkText("back to home"));
        element2.click();

        sleep(2);

        WebElement element3 = driver.findElement(By.linkText("register new user"));
        element3.click();

        Random r = new Random();
    
        element = driver.findElement(By.name("username"));
        element.sendKeys("arto"+r.nextInt(100000));

        element3 = driver.findElement(By.name("password"));
        element3.sendKeys("wrongpassword");
        element3 = driver.findElement(By.name("passwordConfirmation"));
        element3.sendKeys("wrongpassword");
        element3 = driver.findElement(By.name("signup"));
        element3.submit();

        sleep(3);
        System.out.println(driver.getPageSource());

        WebElement element4 = driver.findElement(By.linkText("continue to application mainpage"));
        element4.click();
        
        sleep(3);
        WebElement element5 = driver.findElement(By.linkText("logout"));
        element5.click();
        System.out.println(driver.getPageSource());
        driver.quit();
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
