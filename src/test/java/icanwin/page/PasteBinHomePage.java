package icanwin.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import waits.CustomConditions;

public class PasteBinHomePage {

    private static final String HOME_PAGE_URL = "http://pastebin.com";
    private WebDriver driver;

    @FindBy (id = "postform-text")
            private WebElement pasteTextArea;

    @FindBy (xpath = "//span[@data-select2-id='3']")
            private WebElement searchExpirationSelect;

    @FindBy (id = "postform-name")
            private WebElement pasteTitleName;

    @FindBy (xpath = "//button[text()='Create New Paste']")
            private WebElement createNewPaste;


    public PasteBinHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PasteBinHomePage openPage(){
        driver.get(HOME_PAGE_URL);
        new WebDriverWait(driver, 10)
                .until(CustomConditions.jQueryAJAXsCompleted());
        return this;
    }

    public PasteBinHomePage pasteTextBin(String text){
        pasteTextArea.sendKeys(text);
        return this;
    }

    public PasteBinHomePage selectExpiration(){
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(searchExpirationSelect));
        searchExpirationSelect.click();
        return this;
    }

    public PasteBinHomePage pasteExpiration(String time){
        String locatorExpirationSelect= String.format("//li[text()='%s']", time);
        WebElement searchExpirationSelect =new WebDriverWait(driver, 30)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorExpirationSelect)));
        searchExpirationSelect.click();
        return this;
    }

    public PasteBinHomePage pasteInputNameTitle(String titleName){
        pasteTitleName.sendKeys(titleName);
        return this;
    }

    public CheckResultPasteBinHomePage createNewBin(){
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(createNewPaste));
        createNewPaste.click();
        return new CheckResultPasteBinHomePage(driver);
    }
}
