import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class BoxCom {

    WebDriver driver;

    @BeforeTest
    public void openChrome()  throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        driver = new ChromeDriver();
        String boxUrl = "https://box.com/";
        driver.get(boxUrl);

        WebElement login = driver.findElement(By.linkText("Login"));
        login.click();
        Thread.sleep(2000);

        WebElement inputEmail = driver.findElement(By.cssSelector("input[name='login']"));
        inputEmail.sendKeys("michael.darra@mail.ru");

        WebElement nextEmail = driver.findElement(By.cssSelector("button[type='submit']"));
        nextEmail.click();

        Thread.sleep(2000);
        WebElement inputPassword = driver.findElement(By.cssSelector("input[type='password']"));
        inputPassword.sendKeys("1q2w3e4r5");

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
        //driver.manage().window().maximize();
    }
    //    @AfterTest
//    public void closeChrome(){
//        driver.quit();
//    }

    @Test
    public void test2() throws InterruptedException{

        String rozetkaUrl = "https://rozetka.com.ua/";
        driver.get(rozetkaUrl);

        Thread.sleep(1000);
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='rz-search']/form/div[1]/div[2]/input"));
        searchBox.sendKeys("iphone");

        Thread.sleep(1000);

        WebElement submitSearch = driver.findElement(By.xpath(".//*[@id='rz-search']/form/span/span/button"));
        submitSearch.click();

        WebElement firstElementOnPage = driver.findElement(By.xpath(".//*[@id='catalog_goods_block']/div/div[1]/div[1]/div/div[1]/div/div[4]/a"));
        String textOfFirstElement  = firstElementOnPage.getText();
        String toCheck = "Apple iPhone 6 32GB Space Gray";
        System.out.println(textOfFirstElement);
        Assert.assertTrue(textOfFirstElement.equals(toCheck));


    }

    //test na login i test na upload

    @Test
    public void box() throws InterruptedException {
        String boxUrl = "https://box.com/";
        driver.get(boxUrl);

        WebElement login = driver.findElement(By.linkText("Login"));
        login.click();
        Thread.sleep(2000);

        WebElement inputEmail = driver.findElement(By.cssSelector("input[name='login']"));
        inputEmail.sendKeys("michael.darra@mail.ru");

        WebElement nextEmail = driver.findElement(By.cssSelector("button[type='submit']"));
        nextEmail.click();

        Thread.sleep(2000);
        WebElement inputPassword = driver.findElement(By.cssSelector("input[type='password']"));
        inputPassword.sendKeys("1q2w3e4r5");

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();

        String urlToCheck = "https://app.box.com/folder/0";
        Thread.sleep(1000);


        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        Assert.assertTrue(currentUrl.equals(urlToCheck));


    }
    @Test

    public void boxUploadFile() throws InterruptedException {
        Thread.sleep(1000);

        WebElement uploadDropDown = driver.findElement(By.xpath("//*[@id=\"mod-action-bar-1\"]/div[2]/div[2]/div[2]/a/span[1]"));
        uploadDropDown.click();

        WebElement uploadFile = driver.findElement(By.xpath("//*[@id=\"upload-menu\"]/li[1]/label/input"));

        String path = "600.jpg";
        uploadFile.sendKeys(relativePathToAbsolute(path));

        Thread.sleep(5000); //file to be uploaded

        WebElement fileToCheck = driver.findElement(By.linkText(path));


        Assert.assertTrue(fileToCheck.isDisplayed());


    }

    public static String relativePathToAbsolute(String relativePath) {
        return System.getProperty("user.dir") + "\\" + relativePath;
    }







    //works on Windows only
    public static void robotUpload (String pathOfFile) throws AWTException {
        StringSelection ss = new StringSelection(pathOfFile);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

}


