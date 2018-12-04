package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class FilmsPage extends MainPage {
    public FilmsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//select[@id='actors-dropdown']")
    WebElement actorsDropdown;

    @FindBy(xpath = "//img[@title='Сортировать по рейтингу']")
    WebElement sortByRating;

    @FindBy(xpath = "//div[@id = 'posts']//a[@class='mainlink']")
    List<WebElement> listOfFilms;

    public void clickOnActorsButton() {
    workWithPageElements.clickOnElement(actorsDropdown);
    }

    public void selectFromActorsDropdown(String actor) {
        workWithPageElements.clickOnElement(workWithPageElements.findAndReturnElementOnPage(By.xpath("//select[@id='actors-dropdown']//option[text()='"+actor+"']")));
    }

    public void clickOnSortByRatingStar() {
        workWithPageElements.clickOnElement(sortByRating);
    }

    public boolean verifySortByRating(){

        String[] strWithRating;

        strWithRating = workWithPageElements.findAndReturnElementOnPage(By.xpath("//div[@id = 'posts']//a[1]//img[@class = 'post-ratings-image'][1]")).getAttribute("alt").split("\\s");

        for (int i = 0; i < strWithRating.length ; i++) {
            logger.info(strWithRating[i]);

        }

        return true;
        //        int ratingToCompare =
//        for (int i = 0; i < listOfFilms.size() ; i++) {
//
//        }

    }
}
