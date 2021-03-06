package icanwin.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import icanwin.page.PasteBinHomePage;

public class WebDriverPasteTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "Just a script to create a new paste")
    public void createNewPasta() {

        boolean check–°reationNewPasta = new PasteBinHomePage(driver)
                .openPage()
                .pasteTextBin("Hello from WebDriver")
                .selectExpiration()
                .pasteExpiration("10 Minutes")
                .pasteInputNameTitle("helloweb")
                .createNewBin()
                .checkNewBin();

        Assert.assertTrue(check–°reationNewPasta, "New Pasta not generated!");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver=null;
    }
}