package brudingiton.page;

import brudingiton.enums.BashColor;
import brudingiton.resources.PasteCod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class ChekResultCreatingNewPage {
    WebDriver driver;
    PasteCod data;

    @FindBy(xpath = "//h1")
    private WebElement resultTitleName;

    @FindBy(xpath = "// div[@class='left']/child:: a")
    private WebElement selectBashFromSyntax;

    @FindBy(xpath = "//div[@class='de1']")
    private List<WebElement> rawLinesCreatedBin;

    String locatorLine = "//div[@class='de1']/../../li";

    public ChekResultCreatingNewPage(WebDriver driver, PasteCod data){
        this.driver=driver;
        this.data=data;
        PageFactory.initElements(driver, this);
    }

    public boolean checkCreateTitleName(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(resultTitleName));
        return resultTitleName.getText().equals(new PasteCod().getTitleName());
    }

    public boolean checkCreateHighlighting(String textBash){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(selectBashFromSyntax));
       return selectBashFromSyntax.getText().equals(new PasteCod().getTextBash());
    }

    public boolean checkLighting(){

        List<WebElement> elements = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locatorLine)));
        for (int i = 0; i < elements.size(); i++) {
            List<WebElement> spanElementsInRawLine =
                    elements.get(i).findElements(By.xpath(buildLocatorForRawLine(i)));

            for (int j = 0; j < spanElementsInRawLine.size(); j++) {
                if (!checkColorSyntax(spanElementsInRawLine, j)) {
                    return false;
                }
            }
        }
        return true;
    }
    private String buildLocatorForRawLine(int numberRawLine) {
        return locatorLine + "[" + (numberRawLine + 1) + "]" + "//span";
    }

    private boolean checkColorSyntax(List<WebElement> part, int indexElement) {
        switch (part.get(indexElement).getAttribute("class")) {
            case BashColor.KW2:
                for (int k = 0; k < data.getCommandsGitBash().size(); k++) {
                    if (part.get(indexElement).getText().equals(data.getCommandsGitBash().get(k))) {
                        return true;
                    }
                }
                return false;

            case BashColor.BR0:
                for (int k = 0; k < data.getCharacterBashWrap().size(); k++) {
                    if (part.get(indexElement).getText().equals(data.getCharacterBashWrap().get(k))) {
                        return true;
                    }
                }
                return false;

            case BashColor.RE5:
                return part.get(indexElement).getText().startsWith("-") ||
                        part.get(indexElement).getText().startsWith("--");

            case BashColor.ST0:
                return part.get(indexElement).getText().startsWith("\"") &&
                        part.get(indexElement).getText().endsWith("\"");

            default:
                return false;
        }
    }

    public boolean checkTextCode(){
            List<String> lines = new ArrayList<>();

            new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfAllElements(rawLinesCreatedBin));

            for (WebElement element : rawLinesCreatedBin) {
                lines.add(element.getText());
            }
            return lines.containsAll(data.getTextCodes());
        }
    }


