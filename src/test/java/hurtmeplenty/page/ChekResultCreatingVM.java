package hurtmeplenty.page;

import hurtmeplenty.resources.PasteCodForGoogle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChekResultCreatingVM {
    WebDriver driver;
    PasteCodForGoogle data;

    @FindBy(xpath = "//md-list[@class='cartitem ng-scope']/md-list-item/div")
    private List<WebElement> createdEstimate;

    ChekResultCreatingVM(WebDriver driver, PasteCodForGoogle data){
        this.driver = driver;
        this.data = data;
        PageFactory.initElements(driver, this);
    }

    public boolean verificationOfEnteredData(String field1, String field2, String field3, String field4, String field5){
        List<String> fields = new  ArrayList<>(Arrays.asList(field1, field2, field3, field4, field5));
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
                return line.toLowerCase().endsWith(data.getChoiceDatacentrLocacion().toLowerCase());
            case PasteCodForGoogle.localSSDField:
                return line.toLowerCase().endsWith(data.getChoiceLocalSSD().toLowerCase());
            case PasteCodForGoogle.commitmentTermField:
                return line.toLowerCase().endsWith(data.getChoiceCmmittedUsage().toLowerCase());
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
