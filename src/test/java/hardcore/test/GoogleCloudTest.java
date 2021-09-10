package hardcore.test;

import hardcore.page.CreateHomeGooglePageCalculator;
import hardcore.resources.GooglePageResources;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleCloudTest {
    private WebDriver driver;
    private GooglePageResources data;

    @BeforeMethod(alwaysRun = true)

    public void browserSetup(){
        data = new GooglePageResources();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "get a letter with the results of processing the request")

    public void checkEmailEstimate(){

        boolean verificationCalculationResultsReceivedEmail = new CreateHomeGooglePageCalculator(driver, data)
                .openPage()
                .fillSearchInput()
                .openCalculator()
                .activationComputeEngine()
                .choiceNumberOfIntances(data.getChoiceNumberOfIntances())
                .choiceOperationSystem(data.getChoiceOperationSystem())
                .choiceMachineClass(data.getChoiceMachineClass())
                .choiceSeries(data.getChoiceSeries())
                .choiceMachineType(data.getChoiceMachineType())
                .addGPUs()
                .choiceNumberGPUs(data.getChoiceNumberGPUs())
                .choiceTypeGPU(data.getChoiceTypeGPU())
                .choiceLocalSSD(data.getChoiceLocalSSD())
                .choiceDatacentrLocacion(data.getChoiceDatacentrLocacion())
                .choiceCmmittedUsage(data.getChoiceCmmittedUsage())
                .pressAddToEstimate()
                .saveResultEstimate()
                .pressButtonEmailEstimate()
                .openNewTab()
                .openEmail()
                .copyEmailAddress()
                .comeBackToCalculator()
                .enterEmail()
                .pressButtonSendEmail()
                .returnToPageEmail()
                .pressCheckMailButton()
                .comparisonResultsReceivedEmailWithDataSite();
        Assert.assertTrue(verificationCalculationResultsReceivedEmail, "the data received by mail does not" +
                " coincide with the data received in the calculator");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver=null;
    }
}
