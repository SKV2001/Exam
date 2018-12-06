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

    /**
     * Method click on button which opens Actor dropdown
     */
    public void clickOnActorsButton() {
        workWithPageElements.clickOnElement(actorsDropdown);
    }

    /**
     * Method select specified actor from dropdown
     * @param actor
     */
    public void selectFromActorsDropdown(String actor) {
        workWithPageElements.clickOnElement(workWithPageElements.findAndReturnElementOnPage(By.xpath("//select[@id='actors-dropdown']//option[text()='" + actor + "']")));
    }

    /**
     * Method click on star which sort films descending by rating
     */
    public void clickOnSortByRatingStar() {
        workWithPageElements.clickOnElement(sortByRating);
    }

    /**
     * Method get text with film rating from element attribute and parse it.
     * Then check if sorting by rating is correct and return true if it is. Otherwise return false.
     * @return
     */
    public boolean verifySortByRating() {

        String[] strWithRating;
        strWithRating = workWithPageElements.findAndReturnElementOnPage(By.xpath("//div[@id = 'posts']//a[1]//img[@class = 'post-ratings-image'][1]")).getAttribute("alt").split("\\s");

        double ratingToCompare = Double.parseDouble(strWithRating[3]);

        for (int i = 2; i <= listOfFilms.size(); i++) {
            strWithRating = workWithPageElements.findAndReturnElementOnPage(By.xpath("//div[@id = 'posts']//a[" + i + "]//img[@class = 'post-ratings-image'][1]")).getAttribute("alt").split("\\s");
            if (Double.parseDouble(strWithRating[3]) > ratingToCompare) {
                logger.error("Sort by rating results aren't correct");
                return false;
            }
            ratingToCompare = Double.parseDouble(strWithRating[3]);
        }
        return true;
    }
}
