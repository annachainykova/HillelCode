
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Selenium {
    static public void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "http://random.org/integers/";
        driver.get(url);
        WebElement getNumbersButton = driver.findElement(By.cssSelector("input[value='Get Numbers']"));

        getNumbersButton.click();
        WebElement generatedNumbers = driver.findElement(By.cssSelector("pre[class='data']"));

        String numbers = generatedNumbers.getText();
        System.out.println(numbers);
        Assert.assertTrue(numbers.length()>0);
        driver.quit();
    }
}
