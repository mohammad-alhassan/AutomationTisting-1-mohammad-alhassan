package Pages;

import Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Elemats extends TestBase {
    public Elemats(WebDriver driver) {
      this.driver = driver;
    }
    private By userName = By.id("user-name");
    private By password = By.id("password");
    private By loginButton = By.id("login-button");


    private void userName(String userName) {
        driver.findElement(this.userName).sendKeys(userName);
    }
    private void password(String password) {
        driver.findElement(this.password).sendKeys(password);
    }
    private void loginButton() {
        driver.findElement(this.loginButton).click();
    }




    public void logIn(String userName, String password) {
        userName(userName);
        password(password);
        loginButton();
    }

}
