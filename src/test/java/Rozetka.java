import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Rozetka {

    WebDriver driver;

    @BeforeTest
    public void openChrome()  throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://rozetka.com.ua/";
        driver.get(url);

    }

    @AfterTest
    public void closeChrome(){
        driver.quit();
    }

    @Test
    public void test2() throws InterruptedException{
        Thread.sleep(1000);

        WebElement searchBox = driver.findElement(By.xpath("//*[@id='rz-search']/form/div[1]/div[2]/input"));
        searchBox.sendKeys("iphone");
        searchBox.submit();

        Thread.sleep(1000);

        List<WebElement> catalogGoodBlock = driver.findElements(By.xpath(".//*[@id='catalog_goods_block']//*[@class='g-i-tile-i-title clearfix']//a"));
        WebElement firstElementOnPage = catalogGoodBlock.get(0);

        String textOfFirstElement  = firstElementOnPage.getText();
        //System.out.println(textOfFirstElement);

        String toCheck = "Apple iPhone";

        Assert.assertTrue(textOfFirstElement.contains(toCheck));

    }
}
