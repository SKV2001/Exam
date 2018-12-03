package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends ParentPage {

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//input[@id='btnSearch']")
    WebElement searchButton;

    @FindBy(xpath = "//input[@id='s']")
    WebElement searchField;

    @FindBy(xpath = "//a[@id='user_button']")
    WebElement userButton;



    public void inputValueInSearchField (String text){
        workWithPageElements.enterTextInToElement(text, searchField);
    }

    /**
     * Search button click method
     */
    public  void searchButtonClick(){
        workWithPageElements.clickOnElement(searchButton);
    }

    /**
     * Method verify search results
     * @param searchResults array of films search return
     */
    public void searchResult(String[] searchResults) {
        for (int i = 0; i < searchResults.length; i++) {
            Assert.assertTrue("'"+searchResults[i]+"' фильм не найден", workWithPageElements.isElementExist(By.xpath("//img[@alt='"+searchResults[i]+"']")));
        }
    }

    public void userButtonClick(){
        workWithPageElements.clickOnElement(userButton);
    }
}
