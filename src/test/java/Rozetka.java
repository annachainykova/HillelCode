import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Rozetka {

    WebDriver driver;

    @BeforeTest
    public void openChrome()  throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
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

        WebElement submitSearch = driver.findElement(By.xpath(".//*[@id='rz-search']/form/span/span/button"));
        submitSearch.click();

        Thread.sleep(1000);

        WebElement firstElementOnPage = driver.findElement(By.xpath(".//*[@id='catalog_goods_block']/div/div[1]/div[1]/div/div[1]/div/div[4]/a"));
        String textOfFirstElement  = firstElementOnPage.getText();

        String toCheck = "Apple iPhone 6 32GB Space Gray";

        Assert.assertTrue(textOfFirstElement.equals(toCheck));
    }
}
