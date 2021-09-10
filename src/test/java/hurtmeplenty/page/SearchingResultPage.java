package hurtmeplenty.page;



import hurtmeplenty.resources.PasteCodForGoogle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchingResultPage {

    private PasteCodForGoogle data;
    private WebDriver driver;

    private String partOfSearchQuery = "//a[@class='gs-title']/b[text()='%s']";

    public SearchingResultPage(WebDriver driver, PasteCodForGoogle data){
        this.driver = driver;
        this.data =data;
        PageFactory.initElements(driver, this);
    }

    public CreateGoogleHomePage openCalculator(String query){
        String locator = String.format(partOfSearchQuery, query);

        WebElement googleCalculator = new WebDriverWait(driver, 15)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
        googleCalculator.click();

        return new CreateGoogleHomePage(driver, data);
    }
}
