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

    @FindBy(xpath = "//a[text()='Навигатор']")
    WebElement navigatorButton;

    /**
     * Method enter text into Search editbox
     * @param text
     */
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
     * Method clicks button which to Favourite page
     */
    public void goToFavoriteButtonClick(){
        workWithPageElements.clickOnElement(goToFavoriteButton);
    }

    /**
     * Method click button which leads to user page
     */
    public void userButtonClick(){
        workWithPageElements.clickOnElement(userButton);
    }

    /**
     * Method clicks button which lead to Navigator page
     */
    public void navigatorButtonClick(){workWithPageElements.clickOnElement(navigatorButton);}
}
