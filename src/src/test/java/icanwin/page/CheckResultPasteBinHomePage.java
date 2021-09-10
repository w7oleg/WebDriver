package icanwin.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CheckResultPasteBinHomePage {

    private WebDriver driver;

    public CheckResultPasteBinHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean checkNewBin(){
        List<WebElement> result =new WebDriverWait(driver,10).
                until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//li[@class='li1']")));
        return result.size() > 0;
    }

}
