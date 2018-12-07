package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends MainPage {
    public SearchResultPage(WebDriver webDriver) {
        super(webDriver);
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

    /**
     * Method clicks on specified film
     * @param filmName
     */

    public void clickOnFilm(String filmName){
        workWithPageElements.clickOnElement(By.xpath("//img[@alt='"+filmName+"']"));

    }
}
