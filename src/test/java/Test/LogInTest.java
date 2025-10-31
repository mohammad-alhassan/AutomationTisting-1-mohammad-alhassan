package Test;

import Pages.Elemats;
import Utilities.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LogInTest extends TestBase {
    Elemats elemats;

    @Test
    public void logIn() throws InterruptedException {
        elemats = new Elemats(driver);
        elemats.logIn("standard_user", "secret_sauce");
        Thread.sleep(2000);


    }

}
