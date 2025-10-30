import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.util.List;
public class Test_2 {
    WebDriver   driver = new ChromeDriver();
    //@BeforeTest
    public void setup() {
    driver.manage().window().maximize();
    }
    @Test
    public void HardAssertion() throws InterruptedException {
driver.get("https://www.saucedemo.com/");
Thread.sleep(2000);
WebElement Username = driver.findElement(By.id("user-name"));
Username.sendKeys("standard_user");
WebElement Password = driver.findElement(By.id("password"));
Password.sendKeys("secret_sauce");
Thread.sleep(2000);
WebElement Login = driver.findElement(By.id("login-button"));
Login.click();
Thread.sleep(2000);

String logo = driver.findElement(By.className("app_logo")).getText();
//Assert.assertEquals(logo, "Swag Labs");
Assert.assertTrue(logo.contains("Swag Labs"));
driver.findElement(By.xpath("(//div[@class='inventory_item_name '])[1]")).click();
Thread.sleep(2000);
driver.quit();

    }
    @Test
    public void SoftAssertion() throws InterruptedException {

        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000);
        WebElement Username = driver.findElement(By.id("user-name"));
        Username.sendKeys("standard_user");
        WebElement Password = driver.findElement(By.id("password"));
        Password.sendKeys("secret_sauce");
        Thread.sleep(2000);
        WebElement Login = driver.findElement(By.id("login-button"));
        Login.click();
        Thread.sleep(2000);

        String logo = driver.findElement(By.className("app_logo")).getText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(logo.contains("Swag Labs"));

        driver.findElement(By.xpath("(//div[@class='inventory_item_name '])[1]")).click();
        Thread.sleep(2000);
        driver.quit();
        softAssert.assertAll();


    }
}
