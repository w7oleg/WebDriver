package brudingiton.test;

import brudingiton.page.CreateBinHomePage;
import brudingiton.resources.PasteCod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverPasteCodBinTest {
    private WebDriver driver;
    private PasteCod data;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        data = new PasteCod();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test (description = "Just a script to check create a Title Name")
    public void checkCreationNewTitle (){

        boolean checkCreationNewTitle = new CreateBinHomePage(driver, data)
        .openPage()
        .pasteCodBin(data.getTextCodes())
        .selectSyntaxHighlighting()
        .pasteSyntaxHighlighting("Bash")
        .selectExpiration()
        .pasteExpiration("10 Minutes")
        .pasteTitleName(data.getTitleName())
        .createNewBin()
        .checkCreateTitleName();
        Assert.assertTrue(checkCreationNewTitle, "New Title not generate Title/Name");
    }

    @Test (description = "Just a script to check create syntax highlighting check")
    public void syntaxHighlightingCheck (){

        boolean checkCreateHighlightingCheck = new CreateBinHomePage(driver, data)
                .openPage()
                .pasteCodBin(data.getTextCodes())
                .selectSyntaxHighlighting()
                .pasteSyntaxHighlighting("Bash")
                .selectExpiration()
                .pasteExpiration("10 Minutes")
                .pasteTitleName(data.getTitleName())
                .createNewBin()
                .checkCreateHighlighting(data.getTextBash());
        Assert.assertTrue(checkCreateHighlightingCheck, "New text not highlighting");
    }

    @Test (description = "Just a script to check create syntax highlighting check")
    public void checkBashLighting (){

        boolean checkCreateHighlighting = new CreateBinHomePage(driver, data)
                .openPage()
                .pasteCodBin(data.getTextCodes())
                .selectSyntaxHighlighting()
                .pasteSyntaxHighlighting("Bash")
                .selectExpiration()
                .pasteExpiration("10 Minutes")
                .pasteTitleName(data.getTitleName())
                .createNewBin()
                .checkLighting ();
        Assert.assertTrue(checkCreateHighlighting, "New text not highlighting");
    }

    @Test (description = "Just a script to check create code text")
    public void checkCodeText (){

        boolean checkCreateCodeText = new CreateBinHomePage(driver, data)
                .openPage()
                .pasteCodBin(data.getTextCodes())
                .selectSyntaxHighlighting()
                .pasteSyntaxHighlighting("Bash")
                .selectExpiration()
                .pasteExpiration("10 Minutes")
                .pasteTitleName(data.getTitleName())
                .createNewBin()
                .checkTextCode();
        Assert.assertTrue(checkCreateCodeText, "The new text does not match the previous one ");
    }
    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver=null;
    }
}
