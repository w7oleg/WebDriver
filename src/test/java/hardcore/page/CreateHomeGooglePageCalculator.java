package hardcore.page;

import hardcore.resources.GooglePageResources;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import waits.CustomConditions;

import java.util.ArrayList;
import java.util.List;

public class CreateHomeGooglePageCalculator {

    private GooglePageResources data;
    private WebDriver driver;

    @FindBy(css = "#cloud-site > devsite-iframe > iframe")
    private WebElement iFrame;

    @FindBy(css = "#myFrame")
    private WebElement iFrameCalculatorAfterIFrame;

    @FindBy(xpath = "//md-tab-item/div[@title='Compute Engine' and @class='tab-holder compute']")
    private WebElement tabComputerEngine;


    @FindBy(id = "input_68")
    private WebElement inputNumberInstances;

    @FindBy(id = "select_value_label_61")
    private WebElement locatorOperatingSystem;

    @FindBy(id = "select_value_label_62")
    private WebElement locatorMachineClass;

    @FindBy(id = "select_value_label_64")
    private WebElement locatorSeries;

    @FindBy(id = "select_value_label_65")
    private WebElement locatorMachineType;

    @FindBy(xpath = "//h2[contains(text(),'Instances')]/..//md-checkbox[@aria-label='Add GPUs']")
    private WebElement locatorAddGPUs;

    @FindBy(xpath = "//h2[contains(text(),'Instances')]/..//md-select[@placeholder='Number of GPUs']")
    private WebElement locatorNumberGPUs;

    @FindBy(xpath = "//h2[contains(text(),'Instances')]/..//md-select[@placeholder='GPU type']")
    private WebElement locatorTypeGPUs;

    @FindBy(xpath = "//*[@id='select_393']")
    private WebElement locatorLocalSSD;

    @FindBy(id = "select_value_label_66")
    private WebElement locatorDatacenter;

    @FindBy(id = "select_option_219")
    private WebElement locatorFrankfurt;

    @FindBy(id = "select_value_label_67")
    private WebElement locatorCommittedUsage;

    @FindBy(xpath = "//h2[contains(text(),'Instances')]/..//button[@aria-label='Add to Estimate']")
    private WebElement locatorAddEstimate;

    @FindBy(xpath = "//md-card-content[@id='resultBlock']//b[contains(text(), 'Total Estimated Cost:')]")
    private List<WebElement> result;

    @FindBy(xpath = "//button[@aria-label= 'Email Estimate']")
    private WebElement locatorButtonEmail;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement locatorButtonSendEmail;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement inputEmail;

    public CreateHomeGooglePageCalculator(WebDriver driver, GooglePageResources data){
        this.driver = driver;
        this.data =data;
        PageFactory.initElements(driver, this);    }

    public CreateHomeGooglePageCalculator activationComputeEngine() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(iFrame));

        driver.switchTo().frame(iFrame);
        driver.switchTo().frame(iFrameCalculatorAfterIFrame);
        tabComputerEngine.click();

        return this;
    }

    public CreateHomeGooglePageCalculator choiceNumberOfInstances(String number){
//        new WebDriverWait(driver, 35)
//                .until(ExpectedConditions.elementToBeClickable(inputNumberInstances));
        inputNumberInstances.click();
        inputNumberInstances.sendKeys(number);
        return this;
    }

    public CreateHomeGooglePageCalculator choiceOperationSystem(String operationSystem){
        String partLocator = "//md-option[@value='free']";

        locatorOperatingSystem.click();
        String locatorSystem = String.format(partLocator, operationSystem);

        WebElement chooseSystem = new WebDriverWait(driver,15)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorSystem)));

        WebElement position =new WebDriverWait(driver, 15)
                .until(ExpectedConditions.elementToBeClickable(chooseSystem));

        position.click();

        return this;
    }

    public CreateHomeGooglePageCalculator choiceMachineClass(String mashineClass){
//        new WebDriverWait(driver, 15)
//                .until(ExpectedConditions.elementToBeClickable(locatorMachineClass));
        locatorMachineClass.click();
        String locaterMashine = String.format("//*[@id='select_option_83']/div[1]", mashineClass);

        WebElement chooseMashine = new WebDriverWait(driver, 15)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(locaterMashine)));
        chooseMashine.click();
        return this;
    }

    public CreateHomeGooglePageCalculator choiceSeries(String series){
//     choiceSeriesMashing
        locatorSeries.click();

        String fulfills = String.format("//*[@id='select_option_202']", series);

        WebElement chooseSeriesMachines = new WebDriverWait(driver, 15)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(fulfills)));
        chooseSeriesMachines.click();
        return this;
    }

    public CreateHomeGooglePageCalculator choiceMachineType(String type){
//        new WebDriverWait(driver, 15)
//                .until(ExpectedConditions.elementToBeClickable(locatorMachineType));
        locatorMachineType.click();
        String locatorMachine=String.format("//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']/div[1]", type);

        WebElement choiceMachine = new WebDriverWait(driver, 15)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorMachine)));
        choiceMachine.click();
        return this;
    }

    public CreateHomeGooglePageCalculator addGPUs(){
        locatorAddGPUs.click();
        return this;
    }

    public CreateHomeGooglePageCalculator choiceNumberGPUs(String number){
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.elementToBeClickable(locatorNumberGPUs));
        locatorNumberGPUs.click();
        String locatorNumber = String.format("//*[@id='select_option_439']", number);

        WebElement choiceNumber = new WebDriverWait(driver, 15)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorNumber)));
        choiceNumber.click();
        return this;
    }

    public CreateHomeGooglePageCalculator choiceTypeGPU(String type){
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.elementToBeClickable(locatorTypeGPUs));
        locatorTypeGPUs.click();
        String locatorType = String.format("//md-option[@value='NVIDIA_TESLA_V100']", type);
        WebElement choiceType = new WebDriverWait(driver, 15)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorType)));
        choiceType.click();
        return this;
    }

    public CreateHomeGooglePageCalculator choiceLocalSSD(String local){
        String locatorSSD = String.format("//*[@id='select_option_419']/div[1]", local);

        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.elementToBeClickable(locatorLocalSSD));
        locatorLocalSSD.click();


        WebElement choiceSSD = new WebDriverWait(driver, 15)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorSSD)));

        WebElement position =new WebDriverWait(driver, 15)
                .until(ExpectedConditions.elementToBeClickable(choiceSSD));

        position.click();
        return this;
    }

    public CreateHomeGooglePageCalculator choiceDatacenterLocation(String center){
//        new WebDriverWait(driver, 15)
//                .until(ExpectedConditions.elementToBeClickable(locatorDatacenter));
        locatorDatacenter.click();
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.elementToBeClickable(locatorFrankfurt));
        locatorFrankfurt.click();

        return this;
    }

    public CreateHomeGooglePageCalculator choiceCommittedUsage(String period){
//        new WebDriverWait(driver, 15)
//                .until(ExpectedConditions.elementToBeClickable(locatorCommittedUsage));
        locatorCommittedUsage.click();

        String locatorUsage = String.format("//*[@id='select_option_102']/div[1]", period);

        WebElement choicePeriod = new WebDriverWait(driver, 15)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorUsage)));
        choicePeriod.click();
        return this;
    }

    public CreateHomeGooglePageCalculator pressAddToEstimate(){
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.elementToBeClickable(locatorAddEstimate));
        locatorAddEstimate.click();
        return this;
    }

    public CreateHomeGooglePageCalculator saveResultEstimate(){
        for (WebElement price: result){
            if (price.getText().contains(data.getCostStringDescription())){
                data.setResultPriceCalculator(price.getText());
            }
        }
        return this;
    }

    public CreateHomeGooglePageCalculator pressButtonEmailEstimate(){
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

    public CreateHomeGooglePageCalculator enterEmail(){
        driver.switchTo().frame(iFrame);
        driver.switchTo().frame(iFrameCalculatorAfterIFrame);
        inputEmail.sendKeys(Keys.LEFT_CONTROL, "v");
        new WebDriverWait(driver, 20)
                .until(d -> ((JavascriptExecutor)d).executeScript("return document.readyState")
                        .equals("complete"));
        return this;
    }

    public CreateHomeGooglePageCalculator pressButtonSendEmail(){
        locatorButtonSendEmail.click();
        return this;
    }

    public EmailEstimatePage returnToPageEmail(){
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        return new EmailEstimatePage(driver, data);
    }
}
