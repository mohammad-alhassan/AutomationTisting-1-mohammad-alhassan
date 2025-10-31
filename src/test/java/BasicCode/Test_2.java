package BasicCode;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
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
    @Test
    public void FindElements() throws InterruptedException {

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
        List<WebElement> products =
                driver.findElements(By.className("inventory_item_name"));
        products.get(3).click();
    }

    @Test
    public void Implicit_Wait() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/demo-site/progress-bar/");
      //  Thread.sleep(3000);

        WebElement iframeElement = driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(iframeElement);

driver.findElement(By.id("downloadButton")).click();
        System.out.println("Download status:"+driver.findElement(By.xpath("//div[text()='Complete!']")).getText());
    }

    @Test
    public void Explicit()  {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/demo-site/progress-bar/");

        WebElement iframeElement = driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(iframeElement);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement downloadBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("downloadButton")));
        downloadBtn.click();
        WebElement element_Complete = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Complete!']"))
        );
        System.out.println("Download status:"+element_Complete.getText());
    driver.quit();
    }

    @Test
    public void Fluent_Wait()  {
        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/demo-site/progress-bar/");
        WebElement iframeElement = driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(iframeElement);

        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20)) // max time to wait
                .pollingEvery(Duration.ofMillis(500)) // check for element every 500ms
                .ignoring(NoSuchElementException.class) // skip this exception
                .ignoring(ElementNotInteractableException.class);

        WebElement element = fluentWait.until(driver -> driver.findElement(By.id("downloadButton")));
        element.click(); // bad code

        WebElement element_Complete = fluentWait.until(
                d -> d.findElement(By.xpath("//div[text()='Complete!']")));

        System.out.println("Download status:"+element_Complete.getText());
    driver.quit();
    }


}
