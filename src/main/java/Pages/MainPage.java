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
     * Method compare expected search results with actual
     * @param searchResults  - contains set of search results
     */
    public void searchResult(String searchResults) {
        String[] searchResultsArray = searchResults.split(",");
        for (int i = 0; i < searchResultsArray.length; i++) {
            Assert.assertTrue("'"+searchResultsArray[i]+"' фильм не найден", workWithPageElements.isElementExist(By.xpath("//img[@alt='"+searchResultsArray[i]+"']")));
        }
    }

    public void clickOnFilm(String filmName){
        workWithPageElements.clickOnElement(workWithPageElements.findAndReturnElementOnPage(By.xpath("//img[@alt='"+filmName+"']")));

    }

    public void userButtonClick(){
        workWithPageElements.clickOnElement(userButton);
    }
}
