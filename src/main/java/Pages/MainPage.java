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

    @FindBy(xpath = "//span[@id='fav_button_txt']")
    WebElement goToFavoriteButton;


    public void inputValueInSearchField (String text){
        workWithPageElements.enterTextInToElement(text, searchField);
    }

    /**
     * Search button click method
     */
    public  void searchButtonClick(){
        workWithPageElements.clickOnElement(searchButton);
    }


    public void goToFavoriteButtonClick(){
        workWithPageElements.clickOnElement(goToFavoriteButton);
    }

    public void userButtonClick(){
        workWithPageElements.clickOnElement(userButton);
    }
}
