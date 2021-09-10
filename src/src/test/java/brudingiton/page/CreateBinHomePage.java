package brudingiton.page;

import brudingiton.resources.PasteCod;
import icanwin.page.PasteBinHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import waits.CustomConditions;

import java.util.List;

public class CreateBinHomePage {
    private static final String HOME_PAGE_URL = "http://pastebin.com";
    private PasteCod data;
    private WebDriver driver;

    @FindBy(id = "postform-text")
    private WebElement pasteTextArea;

    @FindBy(xpath = "//span[@data-select2-id='1']")
    private WebElement selectSyntaxHighlighting;

    @FindBy(id = "select2-postform-format-container")
    private WebElement pasteSyntaxHighlighting;

    @FindBy(xpath = "//span[@data-select2-id='3']")
    private WebElement selectExpiration;

    @FindBy(id = "postform-name")
    private WebElement pasteInputTitleName;

    @FindBy(xpath = "//button[text()='Create New Paste']")
    private WebElement createNewPaste;

    public CreateBinHomePage(WebDriver driver, PasteCod data) {
        this.driver = driver;
        this.data = data;
        PageFactory.initElements(driver, this);
    }

    public CreateBinHomePage openPage() {
        driver.get(HOME_PAGE_URL);
        new WebDriverWait(driver, 10)
                .until(CustomConditions.jQueryAJAXsCompleted());
        return this;
    }

    public CreateBinHomePage pasteCodBin(List<String> pasteCodBin) {
        for (int i = 0; i < pasteCodBin.size(); i++) {
            if (!(pasteCodBin.size() - i == 1)) {
                pasteTextArea.sendKeys(pasteCodBin.get(i));
                pasteTextArea.sendKeys(Keys.RETURN);
            } else {
                pasteTextArea.sendKeys(pasteCodBin.get(i));
            }
        }
        return this;
    }

    public CreateBinHomePage selectSyntaxHighlighting(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(selectSyntaxHighlighting));
        selectSyntaxHighlighting.click();
        return this;
    }

    public CreateBinHomePage pasteSyntaxHighlighting(String textFormat) {

        String locatorSyntaxHighlighting = String.format("//li[text()='%s']", textFormat);
        WebElement pasteSyntaxHighlighting =new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorSyntaxHighlighting)));
        pasteSyntaxHighlighting.click();


        return this;
    }

    public CreateBinHomePage selectExpiration() {
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(selectExpiration));
        selectExpiration.click();
        return this;
    }

    public CreateBinHomePage pasteExpiration(String time) {
        String locatorExpirationSelect = String.format("//li[text()='%s']", time);
        WebElement selectExpiration = new WebDriverWait(driver, 30)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorExpirationSelect)));
        selectExpiration.click();
        return this;
    }

        public CreateBinHomePage pasteTitleName (String textTitle){
            pasteInputTitleName.sendKeys(textTitle);
            return this;
        }

        public ChekResultCreatingNewPage createNewBin () {
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.elementToBeClickable(createNewPaste));
            createNewPaste.click();
            return new ChekResultCreatingNewPage(driver, data);
        }


    }


