package Pages;

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
}
