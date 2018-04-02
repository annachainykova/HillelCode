import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RandomOrg {

    WebDriver driver;

    @BeforeTest
    public void openChrome()  throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://random.org/integers/";
        driver.get(url);

    }

    @AfterTest
    public void closeChrome(){
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {

        Thread.sleep(1500);

        WebElement minNumbers = driver.findElement(By.cssSelector("input[name='min']"));
        String minNumbersString = minNumbers.getAttribute("value");
        int min = Integer.parseInt(minNumbersString);

        WebElement maxNumbers = driver.findElement(By.cssSelector("input[name='max']"));
        String maxNumbersString = maxNumbers.getAttribute("value");
        int max = Integer.parseInt(maxNumbersString);

        WebElement number = driver.findElement(By.cssSelector("input[name='num']"));
        number.clear();
        number.sendKeys("1");

        WebElement getNumbersButton = driver.findElement(By.cssSelector("input[value='Get Numbers']"));

        getNumbersButton.click();

        Thread.sleep(1500);
        WebElement generatedNumbers = driver.findElement(By.cssSelector("pre[class='data']"));

        String oneNumberSt = generatedNumbers.getText();

        int oneNumber = Integer.parseInt(oneNumberSt.trim());

        Assert.assertTrue(oneNumber>=min && oneNumber <=max);
    }
}
