package hurtmeplenty.page;


import hardcore.resources.GooglePageResources;

import hurtmeplenty.resources.PasteCodForGoogle;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateGoogleHomePage {
    private PasteCodForGoogle data;
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

    @FindBy(xpath = "//md-list[@class='cartitem ng-scope']/md-list-item/div")
    private List<WebElement> createdEstimate;

    public CreateGoogleHomePage(WebDriver driver, PasteCodForGoogle data){
        this.driver = driver;
        this.data =data;
        PageFactory.initElements(driver, this);    }

    public CreateGoogleHomePage activationComputeEngine() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(iFrame));

        driver.switchTo().frame(iFrame);
        driver.switchTo().frame(iFrameCalculatorAfterIFrame);
        tabComputerEngine.click();

        return this;
    }

    public CreateGoogleHomePage choiceNumberOfInstances(String number){
//        new WebDriverWait(driver, 35)
//                .until(ExpectedConditions.elementToBeClickable(inputNumberInstances));
        inputNumberInstances.click();
        inputNumberInstances.sendKeys(number);
        return this;
    }

    public CreateGoogleHomePage choiceOperationSystem(String operationSystem){
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

    public CreateGoogleHomePage choiceMachineClass(String mashineClass){
//        new WebDriverWait(driver, 15)
//                .until(ExpectedConditions.elementToBeClickable(locatorMachineClass));
        locatorMachineClass.click();
        String locaterMashine = String.format("//*[@id='select_option_83']/div[1]", mashineClass);

        WebElement chooseMashine = new WebDriverWait(driver, 15)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(locaterMashine)));
        chooseMashine.click();
        return this;
    }

    public CreateGoogleHomePage choiceSeries(String series){
//     choiceSeriesMashing
        locatorSeries.click();

        String fulfills = String.format("//*[@id='select_option_202']", series);

        WebElement chooseSeriesMachines = new WebDriverWait(driver, 15)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(fulfills)));
        chooseSeriesMachines.click();
        return this;
    }

    public CreateGoogleHomePage choiceMachineType(String type){
//        new WebDriverWait(driver, 15)
//                .until(ExpectedConditions.elementToBeClickable(locatorMachineType));
        locatorMachineType.click();
        String locatorMachine=String.format("//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']/div[1]", type);

        WebElement choiceMachine = new WebDriverWait(driver, 15)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorMachine)));
        choiceMachine.click();
        return this;
    }

    public CreateGoogleHomePage addGPUs(){
        locatorAddGPUs.click();
        return this;
    }

    public CreateGoogleHomePage choiceNumberGPUs(String number){
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.elementToBeClickable(locatorNumberGPUs));
        locatorNumberGPUs.click();
        String locatorNumber = String.format("//*[@id='select_option_439']", number);

        WebElement choiceNumber = new WebDriverWait(driver, 15)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorNumber)));
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

    public CreateGoogleHomePage choiceDatacenterLocation(String center){
//        new WebDriverWait(driver, 15)
//                .until(ExpectedConditions.elementToBeClickable(locatorDatacenter));
        locatorDatacenter.click();
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.elementToBeClickable(locatorFrankfurt));
        locatorFrankfurt.click();

        return this;
    }

    public CreateGoogleHomePage choiceCommittedUsage(String period){
//        new WebDriverWait(driver, 15)
//                .until(ExpectedConditions.elementToBeClickable(locatorCommittedUsage));
        locatorCommittedUsage.click();

        String locatorUsage = String.format("//*[@id='select_option_102']/div[1]", period);

        WebElement choicePeriod = new WebDriverWait(driver, 15)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorUsage)));
        choicePeriod.click();
        return this;
    }

    public CreateGoogleHomePage pressAddToEstimate(){
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.elementToBeClickable(locatorAddEstimate));
        locatorAddEstimate.click();
        return this;
    }

    public boolean verificationOfEnteredData(String field1, String field2, String field3, String field4, String field5){
        List<String> fields = new ArrayList<>(Arrays.asList(field1, field2, field3, field4, field5));
        return getResultComparingFieldsWithCommonData(fields);
    }

    private boolean getResultComparingFieldsWithCommonData(List<String> fields) {

        List<String> lines = new ArrayList<>();

        createdEstimate.forEach(x ->fields.add(x.getText()));

        for (int i = 0; i < lines.size(); i++) {
            for (int j = 0; j < fields.size(); j++) {
                if (lines.get(i).contains(fields.get(j))) {
                    if (!findResultInFields(lines.get(i), fields.get(j))) {
                        return false;
                    }
                    break;
                }
            }
        }
        return true;
    }

    private boolean findResultInFields(String line, String field) {
        switch (field) {
            case PasteCodForGoogle.vmClassField:
                return line.toLowerCase().endsWith(data.getChoiceMachineClass().toLowerCase());
            case PasteCodForGoogle.instanceTypeField:
                return line.toLowerCase().endsWith(data.getChoiceMachineType().toLowerCase());
            case PasteCodForGoogle.regionField:
                return line.toLowerCase().endsWith(data.getChoiceDataCenter().toLowerCase());
            case PasteCodForGoogle.localSSDField:
                return line.toLowerCase().endsWith(data.getChoiceLocalSSD().toLowerCase());
            case PasteCodForGoogle.commitmentTermField:
                return line.toLowerCase().endsWith(data.getChoiceCommittedUsage().toLowerCase());
            default:
                return false;
        }
    }

    public boolean comparisonResultsManualAndMachineInput(String manualValue){
        return createdEstimate.stream().filter(x -> x.getText()
                .contains(data.getCostStringDescription()))
                .anyMatch(z -> z.getText().contains(manualValue));
    }



}
