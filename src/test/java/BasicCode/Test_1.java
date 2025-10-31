package BasicCode;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Test_1 {

    @Test
    public void ChekBoxAndRadioButton() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/samplepagetest/#contact-form-2599-2-1");

        Thread.sleep(2000);

        WebElement RidoButton = driver.findElement(By.xpath("(//input[contains(@class,'radio ')])[2]"));
        RidoButton.click();

        Thread.sleep(2000);

        WebElement Chekbox = driver.findElement(By.xpath("(//input[contains(@class,'checkbox-multiple ')])[2]"));
        if (!Chekbox.isSelected())
            Chekbox.click();

        Thread.sleep(2000);

        driver.close();


    }

    @Test
    public void DropDownMenu() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
        WebElement Dropdown = driver.findElement(By.tagName("select"));
        Select select = new Select(Dropdown);
        select.selectByVisibleText("Jordan");
        List<WebElement> options = select.getOptions();
        System.out.println(options.size());


        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void Alret() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/samplepagetest/#contact-form-2599");
        WebElement Alert = driver.findElement(By.xpath("//button[text()='Alert Box : Click Here']"));
        Alert.click();
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

        WebElement About = driver.findElement(By.xpath("(//a[@href='https://www.globalsqa.com/about/'])[1]"));
        About.click();
        Thread.sleep(5000);
        driver.close();
    }

    @Test
    public void Overhover() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/demo-site/frames-and-windows/#iFrame");
        WebElement Book = driver.findElement(By.xpath("(//a[@class='no_border'])[1]"));
        Actions NewBook = new Actions(driver);
        NewBook.moveToElement(Book).perform();
        Thread.sleep(5000);
        driver.close();
    }

    @Test
    public void DragAndDrop() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
        WebElement Frame = driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(Frame);
        WebElement Source = driver.findElement(By.xpath("(//h5[@class='ui-widget-header'])[1]"));
        WebElement Target = driver.findElement(By.id("trash"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(Source, Target).perform();
        Thread.sleep(5000);
        driver.close();


    }

    @Test
    public void Dublelick() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
        WebElement Frame = driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(Frame);
        WebElement Duble = driver.findElement(By.xpath("//p[text()='You can view larger image by clicking the zoom icon. Selenium Practice dialog widget is used for the modal window.']"));
        Actions actions = new Actions(driver);
        actions.doubleClick(Duble);
        Thread.sleep(5000);
        driver.close();


    }

    @Test
    public void RitghClick() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
        WebElement Frame = driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(Frame);
        WebElement Ritgh = driver.findElement(By.xpath("//p[text()='You can view larger image by clicking the zoom icon. Selenium Practice dialog widget is used for the modal window.']"));
        Actions actions = new Actions(driver);
        actions.contextClick(Ritgh);
        Thread.sleep(5000);
        driver.close();


    }

    @Test
    public void KeyBoardEvent() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://globalsqa.com/angularJs-protractor/registration-login-example/#/login");
        Thread.sleep(2000);
        WebElement Name = driver.findElement(By.id("username"));
        Name.sendKeys("mohammad");
        WebElement Password = driver.findElement(By.id("password"));
        Password.sendKeys("123456");
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
    public void SelctMutipleItems() throws InterruptedException {
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

