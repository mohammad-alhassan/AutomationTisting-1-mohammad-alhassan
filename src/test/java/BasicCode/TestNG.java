package BasicCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG {
    WebDriver driver;
@Parameters("browser")
    @BeforeMethod(groups = {"regression","login","chekout"})
    public void setup()  {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod(groups = {"regression","login","chekout"})
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }


    @Test (priority = 1, groups ={"regression","login"})
    public void  basicLogIN () throws InterruptedException {
        Thread.sleep(3000);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(3000);

        String logo = driver.findElement(By.className("app_logo")).getText();

        Assert.assertEquals(logo, "Swag Labs", "Logo is not right");

    }
    @Test (priority = 4, groups ={"regression","chekout"})
    public void  chekout () throws InterruptedException {
        Thread.sleep(3000);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
      driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);
driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
Thread.sleep(2000);
driver.findElement(By.id("shopping_cart_container")).click();
driver.findElement(By.id("checkout")).click();
driver.findElement(By.id("first-name")).sendKeys("mohammad");
driver.findElement(By.id("last-name")).sendKeys("alhassan");
driver.findElement(By.id("postal-code")).sendKeys("123456");
Thread.sleep(2000);
driver.findElement(By.id("continue")).click();
driver.findElement(By.id("finish")).click();
Thread.sleep(2000);
driver.findElement(By.id("back-to-products")).click();

    }
    @Test (priority = 2, groups ={"regression","login"})
    public void  openCart () throws InterruptedException {
        Thread.sleep(3000);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
      driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);
driver.findElement(By.id("shopping_cart_container")).click();
Thread.sleep(2000);
    }
    @Test (priority = 3, groups ={"regression","login"})
    public void  addItem () throws InterruptedException {
        Thread.sleep(3000);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
      driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);
driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
Thread.sleep(3000);
driver.findElement(By.id("shopping_cart_container")).click();
Thread.sleep(2000);
    }

    @Test
    public void dependsOnMethods () {
        System.out.println("tiis moethd 1 is not call ");

    }
    @Test(dependsOnMethods = "dependsOnMethods")
    public void dependsOnMethods2 () {
        System.out.println("tiis moethd are call ");

    }

}
