package hardcore.page;

import hardcore.resources.GooglePageResources;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import waits.CustomConditions;

import java.util.ArrayList;

public class EmailEstimatePage {
    WebDriver driver;
    GooglePageResources data;
    private static final String HOME_PAGE_URL = "https://10minutemail.com";

//    @FindBy(xpath = "//*[@id='listeliens']/a")
//            private WebElement linkRandomAddress;

    @FindBy(id= "copy_address")//span[text()='Скопировать в буфер обмена']
            private WebElement linkCopyRandomAddress;

//    @FindBy(xpath = "//span[text()='Проверить почту']")
//            private WebElement linkCheckEmail;
    @FindBy(xpath = "//*[@id='mail_messages_content']//span[text()='Google Cloud Platform Price Estimate']")
    private WebElement linkCheckEmail;

//    @FindBy(id = "//*[@class='yscrollbar']//td/h2")
//            private WebElement letterField;

    @FindBy(xpath = "//*[@id='mobilepadding']//td[2]/h3")
    private WebElement letterField;//fieldTotalPriceEstimateBill

    EmailEstimatePage(WebDriver driver, GooglePageResources data){
        this.driver = driver;
        this.data = data;
        PageFactory.initElements(driver, this);
    }

    public EmailEstimatePage openEmail(){
        driver.get(HOME_PAGE_URL);
        new WebDriverWait(driver, 15)
                .until(CustomConditions.jsLoadCompleted());

//        new WebDriverWait(driver, 15)
//                .until(ExpectedConditions.elementToBeClickable(linkRandomAddress));
//        linkRandomAddress.click();

        return this;
    }

    public EmailEstimatePage copyEmailAddress(){
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.elementToBeClickable(linkCopyRandomAddress));
        linkCopyRandomAddress.click();
        return this;
    }

    public CheckResultCalculator comeBackToCalculator(){
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));

        return new CheckResultCalculator(driver, data);
    }

    public EmailEstimatePage pressCheckMailButton(){
        new WebDriverWait(driver, 40)
            .until(d -> ((JavascriptExecutor)d).executeScript("return document.readyState")
                    .equals("complete"));

        new  WebDriverWait(driver, 15)
                .until(ExpectedConditions.elementToBeClickable(linkCheckEmail));
        linkCheckEmail.click();



        return this;
    }

    public boolean comparisonResultsReceivedEmailWithDataSite(){
        new WebDriverWait(driver, 20)
                .until(d -> ((JavascriptExecutor)d).executeScript("return document.readyState")
                        .equals("complete"));
        String priceReceivedEmail = letterField.getText();
        String priceCalculator = data.getResultPriceCalculator();



        return priceCalculator.contains(priceReceivedEmail);
    }


}
