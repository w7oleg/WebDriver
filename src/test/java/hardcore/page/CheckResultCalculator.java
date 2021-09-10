package hardcore.page;

import hardcore.resources.GooglePageResources;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class CheckResultCalculator {
    WebDriver driver;
    GooglePageResources data;

    @FindBy(xpath = "//md-list[@class='cartitem ng-scope']/md-list-item/div")
    private List<WebElement> result;

    @FindBy(xpath = "//button[@aria-label= 'Email Estimate']")
    private WebElement locatorButtonEmail;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement inputEmail;

    @FindBy(css = "#cloud-site > devsite-iframe > iframe")
    private WebElement iFrame;

    @FindBy(css = "#myFrame")
    private WebElement iFrameCalculatorAfterIFrame;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement locatorButtonSendEmail;


    CheckResultCalculator(WebDriver driver, GooglePageResources data){
        this.driver = driver;
        this.data = data;
        PageFactory.initElements(driver, this);
    }

    public CheckResultCalculator saveResultEstimate(){
        for (WebElement price: result){
            if (price.getText().contains(data.getCostStringDescription())){
                data.setResultPriceCalculator(price.getText());
            }
        }
        return this;
    }

    public CheckResultCalculator pressButtonEmailEstimate(){
        new WebDriverWait(driver, 15)
        .until(ExpectedConditions.elementToBeClickable(locatorButtonEmail));
        locatorButtonEmail.click();

        return this;
    }

    public EmailEstimatePage openNewTab(){
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        return new EmailEstimatePage(driver, data);
    }

    public CheckResultCalculator enterEmail(){
        driver.switchTo().frame(iFrame);
        driver.switchTo().frame(iFrameCalculatorAfterIFrame);
        inputEmail.sendKeys(Keys.LEFT_CONTROL, "v");
                new WebDriverWait(driver, 20)
                .until(d -> ((JavascriptExecutor)d).executeScript("return document.readyState")
                        .equals("complete"));
        return this;
    }

    public CheckResultCalculator pressButtonSendEmail(){
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.elementToBeClickable(locatorButtonSendEmail));
        locatorButtonSendEmail.click();

       new WebDriverWait(driver, 20)
                .until(d -> ((JavascriptExecutor)d).executeScript("return document.readyState")
                       .equals("complete"));

        return this;
    }

    public EmailEstimatePage returnToPageEmail(){
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        return new EmailEstimatePage(driver, data);
    }


}
