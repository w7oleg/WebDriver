import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebDriverPasteTest {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.MINUTES);

        driver.get("https://pastebin.com");
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("postform-text")));

        WebElement searchTextArea = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("postform-text")));
        searchTextArea.sendKeys("Hello from WebDriver");

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("postform-name")));

        WebElement searchInput = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("postform-name")));
        searchInput.sendKeys("helloweb");

        WebElement createNewPaste = driver.findElement(By.xpath("//button[text()='Create New PasteCod']"));
        createNewPaste.click();

//        new WebDriverWait(driver, 10)
//                .until(ExpectedConditions.presenceOfElementLocated(By.id("//li[@class='li1'] and contains (.,'Hello from WebDriver'")));
//
//       List<WebElement> searchResult = driver.findElements(By.xpath("//li[@class='li1'] and contains (.,'Hello from WebDriver'"));
//        System.out.println(searchResult);



        driver.quit();
    }
}
