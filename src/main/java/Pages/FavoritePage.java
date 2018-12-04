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
        wait2 =  new WebDriverWait(webDriver, 2);
    }

    @FindBy(xpath = "//div[@class = 'post favpost']")
    List<WebElement> listOfFilms;

    public void isFilmAddedToFavourite(String film) {
        Assert.assertEquals("Film " + film + " is not added to Favourite", true, workWithPageElements.isElementExist(By.xpath("//img[@alt='" + film + "']")));
    }

    public void deleteFromFavorite(String film) {
        int count = 1;
        boolean indicator = true;
        while (count<=listOfFilms.size()&&indicator){
            if(workWithPageElements.findAndReturnElementOnPage(By.xpath("//div[@class = 'post favpost']["+count+"]//span")).getText().equals(film)){
                workWithPageElements.clickOnElement(workWithPageElements.findAndReturnElementOnPage(By.xpath("(//a[@class='favdel added favListItem'])["+ count+ "]")));
                wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//a[@class='favdel added favListItem'])["+ count+ "]")));
                indicator = false;
            }
            count++;
        }
    }
}
