package OneTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WebDriverPasteTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.MINUTES);
    }

    @Test(description = "Just a script to create a new paste")
    public void createNewPasta() throws InterruptedException {

        driver.get("https://pastebin.com");
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("postform-text")));

        WebElement searchTextArea = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("postform-text")));
        searchTextArea.sendKeys("Hello from WebDriver");

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("postform-name")));

        WebElement searchExpirationSelect= new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-select2-id='3']")));
        searchExpirationSelect.click();

        String locatorExpirationSelect= String.format("//li[text()='%s']", "10 Minutes");

        WebElement pasteExpirationSelect= new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorExpirationSelect)));
        pasteExpirationSelect.click();

        WebElement pasteInputName = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("postform-name")));
        pasteInputName.sendKeys("helloweb");

        WebElement createNewPaste = driver.findElement(By.xpath("//button[text()='Create New PasteCod']"));
        createNewPaste.click();

        Assert.assertTrue(createNewPaste.isEnabled(), "New Pasta not generated!");

    }
    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver=null;
    }
}
