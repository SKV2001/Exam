package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends ParentPage {

    @FindBy(xpath = "//input[@id='btnSearch']")
    private WebElement searchButton;

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }
    @FindBy(xpath = "//input[@id='s']")
    WebElement searchField;



    public void inputValueInSearchField (String text){
        workWithPageElements.enterTextInToElement(text, searchField);
    }

    public  void searchButtonClick(){
        workWithPageElements.clickOnElement(searchButton);
    }

    public void searchResult() {
        Assert.assertTrue("Search is not found films", workWithPageElements.isElementExist(By.xpath("//img[@alt='Супермен: Судный день']")));
    }
}
