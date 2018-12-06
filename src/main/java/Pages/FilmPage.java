package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FilmPage extends MainPage{


    public FilmPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//span[@id='fav_but_add']")
    WebElement addToFavoriteButton;

    /**
     * Method click button which leads to Favourite page
     */
    public void addToFavoriteButtonClick(){
        workWithPageElements.clickOnElement(addToFavoriteButton);
    }

}
