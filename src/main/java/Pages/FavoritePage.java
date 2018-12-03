package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FavoritePage extends ParentPage {
    public FavoritePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void isFilmAddedToFavourite (String film){
        Assert.assertEquals("Film "+film+" is not added to Favourite", true, workWithPageElements.isElementExist(By.xpath("//img[@alt='"+film+"']")));
    }

}
