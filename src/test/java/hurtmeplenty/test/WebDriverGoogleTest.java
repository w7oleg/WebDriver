package hurtmeplenty.test;

import hurtmeplenty.page.HomePageGoogle;
import hurtmeplenty.resources.PasteCodForGoogle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverGoogleTest {
    private WebDriver driver;
    private PasteCodForGoogle data;

    @BeforeMethod(alwaysRun = true)

    public void browserSetup(){
        data= new PasteCodForGoogle();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "We check the consistency of the entered data and received")

    public void checkReceivedData(){
       boolean checkingFillingFieldsWellWorkCalculator = new HomePageGoogle(driver, data)
               .openPage()
               .fillSearchInput()
               .openCalculator(data.getChoiceCalculator())
               .activationComputeEngine()
               .choiceNumberOfInstances(data.getChoiceNumberOfInstances())
               .choiceOperationSystem(data.getChoiceOperationSystem())
               .choiceMachineClass(data.getChoiceMachineClass())
               .choiceSeries(data.getChoiceSeries())
               .choiceMachineType(data.getChoiceMachineType())
               .addGPUs()
               .choiceNumberGPUs(data.getChoiceNumberGPUs())
               .choiceTypeGPU(data.getChoiceTypeGPU())
               .choiceLocalSSD(data.getChoiceLocalSSD())
               .choiceDatacenterLocation(data.getChoiceDataCenter())
               .choiceCommittedUsage(data.getChoiceCommittedUsage())
               .pressAddToEstimate()
                .verificationOfEnteredData(
                        PasteCodForGoogle.vmClassField, PasteCodForGoogle.instanceTypeField, PasteCodForGoogle.regionField,
                        PasteCodForGoogle.localSSDField, PasteCodForGoogle.commitmentTermField);
        Assert.assertTrue(checkingFillingFieldsWellWorkCalculator, "the data obtained after processing" +
                " by the calculator does not correspond to the entered data");
    }

    @Test(description = "check if the payment amount received during test automatic input matches the amount" +
            " received during manual input")

    public void checkTotalEstimateCost(){
        boolean totalEstimateCost = new HomePageGoogle(driver, data)
                .openPage()
                .fillSearchInput()
                .openCalculator(data.getChoiceCalculator())
                .activationComputeEngine()
                .choiceNumberOfInstances(data.getChoiceNumberOfInstances())
                .choiceOperationSystem(data.getChoiceOperationSystem())
                .choiceMachineClass(data.getChoiceMachineClass())
                .choiceSeries(data.getChoiceSeries())
                .choiceMachineType(data.getChoiceMachineType())
                .addGPUs()
                .choiceNumberGPUs(data.getChoiceNumberGPUs())
                .choiceTypeGPU(data.getChoiceTypeGPU())
                .choiceLocalSSD(data.getChoiceLocalSSD())
                .choiceDatacenterLocation(data.getChoiceDataCenter())
                .choiceCommittedUsage(data.getChoiceCommittedUsage())
                .pressAddToEstimate()
                .comparisonResultsManualAndMachineInput(data.getResultManualTest());
        Assert.assertTrue(totalEstimateCost, "Machine test value is not the same as manual test");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver=null;
    }
}
