package hurtmeplenty.page;

import hurtmeplenty.resources.PasteCodForGoogle;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import waits.CustomConditions;

public class CreateGoogleHomePage {
    private static final String HOME_PAGE_URL = "https://cloud.google.com/";
    private PasteCodForGoogle data;
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='devsite-searchbox']/input")
    private WebElement searchInput;

    @FindBy(xpath = "//*[@id='gc-wrapper']//devsite-analytics-scope[1]/div[1]/a")
    private WebElement googleCalculatorLink;

    @FindBy(css = "#cloud-site > devsite-iframe > iframe")
    private WebElement iFrame;

    @FindBy(css = "#myFrame")
    private WebElement iFrameCalculatorAfterIFrame;

    @FindBy(xpath = "//md-tab-item/div[@title='Compute Engine' and @class='tab-holder compute']")
    private WebElement tabComputerEngine;


    @FindBy(id = "input_67")
    private WebElement inputNumberInstances;

    @FindBy(id = "select_value_label_60")
    private WebElement locatorOperatingSystem;

//    @FindBy(id = "select_option_69")
//    private WebElement selectOperatingSystem;

    @FindBy(id = "select_value_label_61")
    private WebElement locatorMachineClass;

    @FindBy(id = "select_value_label_63")
    private WebElement locatorSeries;

    @FindBy(id = "select_value_label_64")
    private WebElement locatorMachineType;

    @FindBy(xpath = "//h2[contains(text(),'Instances')]/..//md-checkbox[@aria-label='Add GPUs']")
    private WebElement locaterAddGPUs;

    @FindBy(xpath = "//h2[contains(text(),'Instances')]/..//md-select[@placeholder='Number of GPUs']")
    private WebElement locatorNumberGPUs;

    @FindBy(xpath = "//h2[contains(text(),'Instances')]/..//md-select[@placeholder='GPU type']")
    private WebElement locatorTypeGPUs;

    @FindBy(id = "select_value_label_391")
    private WebElement locatorLocalSSD;

    @FindBy(id = "select_value_label_65")
    private WebElement locatorDatacentr;

    @FindBy(id = "select_option_218")
    private WebElement locaterFrankfurt;

    @FindBy(id = "select_value_label_66")
    private WebElement locatorCommitedUsage;

    @FindBy(xpath = "//h2[contains(text(),'Instances')]/..//button[@aria-label='Add to Estimate']")
    private WebElement locatorAddEstimate;

    public CreateGoogleHomePage(WebDriver driver, PasteCodForGoogle data){
        this.driver = driver;
        this.data =data;
        PageFactory.initElements(driver, this);
    }

    public  CreateGoogleHomePage openPage(){
        driver.get(HOME_PAGE_URL);

        new WebDriverWait(driver, 15)
                .until(CustomConditions.jsLoadCompleted());

        return this;
    }

    public CreateGoogleHomePage fillSearchInput(){
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.visibilityOf(searchInput));
        searchInput.click();
        searchInput.sendKeys("Google Cloud Platform Pricing Calculator");
        searchInput.sendKeys(Keys.ENTER);

        return this;
    }

    public CreateGoogleHomePage openCalculator(){
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.elementToBeClickable(googleCalculatorLink));
        googleCalculatorLink.click();

        return this;
    }

    public CreateGoogleHomePage activationComputeEngine() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(iFrame));

        driver.switchTo().frame(iFrame);
        driver.switchTo().frame(iFrameCalculatorAfterIFrame);
        tabComputerEngine.click();

        return this;
    }



    public CreateGoogleHomePage choiceNumberOfIntances(String number){
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.elementToBeClickable(inputNumberInstances));
        inputNumberInstances.click();
        inputNumberInstances.sendKeys(number);
        return this;
    }

    public CreateGoogleHomePage choiceOperationSystem(String operationSystem){
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.elementToBeClickable(locatorOperatingSystem));
        locatorOperatingSystem.click();
        String locatorSystem = String.format("//*[@id='select_option_69']/div[1]", operationSystem);

        WebElement chooseSystem = new WebDriverWait(driver,15)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorSystem)));
        chooseSystem.click();
        return this;
    }

    public CreateGoogleHomePage choiceMachineClass(String mashineClass){
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.elementToBeClickable(locatorMachineClass));
        locatorMachineClass.click();
        String locaterMashine = String.format("//*[@id='select_option_82']/div[1]", mashineClass);

        WebElement chooseMashine = new WebDriverWait(driver, 15)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(locaterMashine)));
        chooseMashine.click();
        return this;
    }

    public CreateGoogleHomePage choiceSeries(String series){
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.elementToBeClickable(locatorSeries));
        locatorSeries.click();
        String locatorSeries = String.format("//*[@id='select_option_201']", series);

        WebElement choiseSeriesMashine = new WebDriverWait(driver, 15)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorSeries)));
        choiseSeriesMashine.click();
        return this;
    }

    public CreateGoogleHomePage choiceMachineType(String type){
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.elementToBeClickable(locatorMachineType));
        locatorMachineType.click();
        String locatorMachine=String.format("//*[@id='select_option_397']/div[1]", type);

        WebElement choiceMachine = new WebDriverWait(driver, 15)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorMachine)));
        choiceMachine.click();
        return this;
    }

    public CreateGoogleHomePage addGPUs(){
        locaterAddGPUs.click();
        return this;
    }

    public CreateGoogleHomePage choiceNumberGPUs(String number){
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.elementToBeClickable(locatorNumberGPUs));
        locatorNumberGPUs.click();
        String localorNumber = String.format("//*[@id='select_option_439']", number);

        WebElement choiceNumber = new WebDriverWait(driver, 15)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(localorNumber)));
        choiceNumber.click();
        return this;
    }

    public CreateGoogleHomePage choiceTypeGPU(String type){
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.elementToBeClickable(locatorTypeGPUs));
        locatorTypeGPUs.click();
        String locatorType = String.format("//md-option[@value='NVIDIA_TESLA_V100']", type);
        WebElement choiceType = new WebDriverWait(driver, 15)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorType)));
        choiceType.click();
        return this;
    }

    public CreateGoogleHomePage choiceLocalSSD(String local){
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.elementToBeClickable(locatorLocalSSD));
        locatorLocalSSD.click();
        String locatorSSD = String.format("//*[@id='select_option_418']", local);

        WebElement choiceSSD = new WebDriverWait(driver, 15)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorSSD)));
        choiceSSD.click();
        return this;
    }

    public CreateGoogleHomePage choiceDatacentrLocacion(String center){
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.elementToBeClickable(locatorDatacentr));
        locatorDatacentr.click();
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.elementToBeClickable(locaterFrankfurt));
        locaterFrankfurt.click();

        return this;
    }

    public CreateGoogleHomePage choiceCmmittedUsage(String period){
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.elementToBeClickable(locatorCommitedUsage));
        locatorCommitedUsage.click();

        String locatorUsage = String.format("//*[@id='select_option_101']", period);

        WebElement choicePeriod = new WebDriverWait(driver, 15)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorUsage)));
        choicePeriod.click();
        return this;
    }

    public ChekResultCreatingVM pressAddToEstimate(){
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.elementToBeClickable(locatorAddEstimate));
        locatorAddEstimate.click();
        return new ChekResultCreatingVM(driver, data);
    }






}
