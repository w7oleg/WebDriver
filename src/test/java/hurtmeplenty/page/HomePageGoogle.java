package hurtmeplenty.page;



import hurtmeplenty.resources.PasteCodForGoogle;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import waits.CustomConditions;

public class HomePageGoogle {


    private static final String HOME_PAGE_URL = "https://cloud.google.com/";
    private PasteCodForGoogle data;
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='devsite-searchbox']/input")
    private WebElement searchInput;

    public HomePageGoogle(WebDriver driver, PasteCodForGoogle data){
        this.driver = driver;
        this.data =data;
        PageFactory.initElements(driver, this);
    }

    public HomePageGoogle openPage(){
        driver.get(HOME_PAGE_URL);

        new WebDriverWait(driver, 15)
                .until(CustomConditions.jsLoadCompleted());

        return this;
    }

    public SearchingResultPage fillSearchInput(){
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.visibilityOf(searchInput));
        searchInput.click();
        searchInput.sendKeys("Google Cloud Platform Pricing Calculator");
        searchInput.sendKeys(Keys.ENTER);

        return new SearchingResultPage(driver, data);
    }
}
