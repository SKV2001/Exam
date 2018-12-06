package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FavoritePage extends MainPage {
    WebDriverWait wait2;

    public FavoritePage(WebDriver webDriver) {
        super(webDriver);
        wait2 = new WebDriverWait(webDriver, 2);
    }

    @FindBy(xpath = "//div[@class = 'post favpost']")
    List<WebElement> listOfFilms;

    /**
     * Method check if film exist in Favourite list
     * @param film
     */
    public void isFilmAddedToFavourite(String film) {
        Assert.assertEquals("Film " + film + " is not added to Favourite", true, workWithPageElements.isElementExist(By.xpath("//img[@alt='" + film + "']")));
    }

    /**
     * Method delete film from Favourite list
     * @param film
     */
    public void deleteFromFavorite2(String film) {
        workWithPageElements.clickOnElement(workWithPageElements.findAndReturnElementOnPage(By.xpath("//div[@class='post favpost']//span[text()='" + film + "']//..//..//a[@class='favdel added favListItem']")));
        wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='post favpost']//span[text()='\" + film + \"']//..//..//a[@class='favdel added favListItem']")));
    }

    /**
     * Method seeking for specified film in Favourite list and then delete this film
     * @param film
     */

    @Deprecated
    public void deleteFromFavorite(String film) {
        int count = 1;
        boolean indicator = true;
        while (count <= listOfFilms.size() && indicator) {
            if (workWithPageElements.findAndReturnElementOnPage(By.xpath("//div[@class = 'post favpost'][" + count + "]//span")).getText().equals(film)) {
                workWithPageElements.clickOnElement(workWithPageElements.findAndReturnElementOnPage(By.xpath("(//a[@class='favdel added favListItem'])[" + count + "]")));
                wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//a[@class='favdel added favListItem'])[" + count + "]")));
                indicator = false;
            }
            count++;
        }
    }
}
