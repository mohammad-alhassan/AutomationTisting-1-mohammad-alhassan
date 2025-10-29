import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Test_1 {

    @Test
    public void chekboxandridobutton() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/samplepagetest/#contact-form-2599-2-1");

        Thread.sleep(2000);

        WebElement ridoButton = driver.findElement(By.xpath("(//input[contains(@class,'radio ')])[2]"));
        ridoButton.click();

        Thread.sleep(5000);

        WebElement chekbox = driver.findElement(By.xpath("(//input[contains(@class,'checkbox-multiple ')])[2]"));
        if     (!chekbox.isSelected())
            chekbox.click();

        Thread.sleep(5000);

        driver.close();



    }
    @Test
    public void dropdown() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
        WebElement dropdown = driver.findElement(By.tagName("select"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Jordan");
        List<WebElement> options = select.getOptions();
            System.out.println(options.size());


        Thread.sleep(2000);
        driver.close();
    }
@Test
public void alret() throws InterruptedException {
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.globalsqa.com/samplepagetest/#contact-form-2599");
    WebElement alert = driver.findElement(By.xpath("//button[text()='Alert Box : Click Here']"));
    alert.click();
    Alert alert1 = driver.switchTo().alert();
    alert1.accept();




    Thread.sleep(5000);
    driver.close();
}
@Test
public void Ifream() throws InterruptedException {
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.globalsqa.com/demo-site/frames-and-windows/#iFrame");
   // WebElement confirm = driver.findElement(By.xpath("(//span[text()='Frames And Windows'])[2]"));
   // confirm.click();
//WebElement frame = driver.findElement(By.tagName("globalSqa"));
//frame.click();
Thread.sleep(2000);
driver.switchTo().frame("globalSqa");
WebElement Ifream = driver.findElement(By.xpath("//img[@class=' ls-is-cached lazyloaded']"));
Ifream.click();
driver.switchTo().defaultContent();

WebElement about = driver.findElement(By.xpath("(//a[@href='https://www.globalsqa.com/about/'])[1]"));
about.click();
    Thread.sleep(5000);
    driver.close();
}

@Test
public void overhover() throws InterruptedException {
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.globalsqa.com/demo-site/frames-and-windows/#iFrame");
WebElement book = driver.findElement(By.xpath("(//a[@class='no_border'])[1]"));
   Actions NewBook = new Actions(driver);
NewBook.moveToElement(book).perform();
Thread.sleep(5000);
driver.close();
}
@Test
public void dragAndDrop() throws InterruptedException {
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
    WebElement frame = driver.findElement(By.className("demo-frame"));
    driver.switchTo().frame(frame);
    WebElement source = driver.findElement(By.xpath("(//h5[@class='ui-widget-header'])[1]"));
    WebElement target = driver.findElement(By.id("trash"));
    Actions actions = new Actions(driver);
    actions.dragAndDrop(source, target).perform();
    Thread.sleep(5000);
    driver.close();


}

@Test
    public void Dubleclick() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
        WebElement frame = driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(frame);
        WebElement Duble = driver.findElement(By.xpath("//p[text()='You can view larger image by clicking the zoom icon. Selenium Practice dialog widget is used for the modal window.']"));
        Actions actions = new Actions(driver);
actions.doubleClick(Duble);
Thread.sleep(5000);
        driver.close();


    }
@Test
    public void Ritghclick() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
        WebElement frame = driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(frame);
        WebElement Ritgh = driver.findElement(By.xpath("//p[text()='You can view larger image by clicking the zoom icon. Selenium Practice dialog widget is used for the modal window.']"));
        Actions actions = new Actions(driver);
actions.contextClick(Ritgh);
Thread.sleep(5000);
        driver.close();


    }
    @Test
    public void login() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://globalsqa.com/angularJs-protractor/registration-login-example/#/login");
        Thread.sleep(2000);
        WebElement name = driver.findElement(By.id("username"));
        name.sendKeys("mohammad");
       WebElement password = driver.findElement(By.id("password"));
       password.sendKeys("123456");
       Actions Go = new Actions(driver);
       Go.sendKeys(Keys.ENTER).perform();
Thread.sleep(5000);
        driver.close();


    }

    @Test
    public void NewTab() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com");
        String originalWindow = driver.getWindowHandle();
        Thread.sleep(2000);
        System.out.println(driver.getTitle());
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://facebook.com");
        Thread.sleep(2000);
        System.out.println(driver.getTitle());
        driver.switchTo().window(originalWindow);
Thread.sleep(5000);
        driver.quit();


    }
    @Test
    public void NewWindow() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com");
        String originalWindow = driver.getWindowHandle();
        Thread.sleep(2000);
        System.out.println(driver.getTitle());
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://facebook.com");
        Thread.sleep(2000);
        System.out.println(driver.getTitle());
        driver.switchTo().window(originalWindow);
Thread.sleep(5000);
        driver.quit();
    }

@Test
public void FileUpload() throws InterruptedException {
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.globalsqa.com/samplepagetest/");
    Thread.sleep(2000);
    WebElement fileUpload = driver.findElement(By.xpath("//input[@class='wpcf7-form-control wpcf7-file']"));
    fileUpload.sendKeys("C:\\Users\\mralq\\OneDrive\\Pictures\\Untitled.png");
Thread.sleep(5000);
    driver.quit();
}
@Test
public void TakeScreenshot() throws InterruptedException {
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://google.com");
    Thread.sleep(2000);
    File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    try {
        FileUtils.copyFile(file, new File("screenshot.png"));
    } catch (IOException e) {
        e.printStackTrace();
    }
    Thread.sleep(5000);
    driver.quit();
}
@Test
    public void ElementScreenshot() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://web.facebook.com/login.php/?_rdc=1&_rdr#");
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.id("login_link"));
        File file = element.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread.sleep(5000);
        driver.quit();
    }
    @Test
    public void  SelctMutipleItems() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.globalsqa.com/demo-site/select-elements/");
        WebElement iframe = driver.findElement(By.cssSelector(".demo-frame"));
        driver.switchTo().frame(iframe);

        List<WebElement> items = driver.findElements(By.cssSelector("#selectable li"));
        System.out.println("Number for all item " + items.size());

        Actions actions = new Actions(driver);

        actions.keyDown(Keys.CONTROL).click(items.get(0)).click(items.get(1)).click(items.get(2))
                .keyUp(Keys.CONTROL).build().perform();

        Thread.sleep(5000);
        driver.quit();
    }

}

