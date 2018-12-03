package search;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import parentTest.ParentTest;


public class SearchTest extends ParentTest {

    @Before
    public void mainPageOpen() {
        loginPage.openAndLogin();
        profilePage.gidOnlineImageClick();
    }

    @Test
    public void validSearch() {

        String valueForSearch = "Судный";
        String[] searchResults = {"Супермен: Судный день", "Судный день", "Терминатор 2: Судный день"};

        mainPage.inputValueInSearchField(valueForSearch);
        mainPage.searchButtonClick();
        mainPage.searchResult(searchResults);
    }

    @After
    public void logout(){
        mainPage.userButtonClick();
        profilePage.logOutButtonClick();
    }
}
