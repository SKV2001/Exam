package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FilmPage extends ParentPage {


    public FilmPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//span[@id='fav_but_add']")
    WebElement addToFavoriteButton;

    @FindBy(xpath = "//a[@id='user_button']")
    WebElement userButton;

    @FindBy(xpath = "//span[@id='fav_button_txt']")
    WebElement goToFavoriteButton;

    public void addToFavoriteButtonClick(){
        workWithPageElements.clickOnElement(addToFavoriteButton);
    }

    public void goToFavoriteButtonClick(){
        workWithPageElements.clickOnElement(goToFavoriteButton);
    }
    public void userButtonClick(){
        workWithPageElements.clickOnElement(userButton);
    }


}
