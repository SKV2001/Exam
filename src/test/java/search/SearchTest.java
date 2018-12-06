package search;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)

public class SearchTest extends ParentTest {

    String valueForSearch;
    String searchResults;

    public SearchTest(String valueForSearch, String searchResults) {
        this.valueForSearch = valueForSearch;
        this.searchResults = searchResults;
    }

    @Parameterized.Parameters (name= "Searching  for {0} and expected results {1}")
    public static Collection testData(){
        return Arrays.asList(new Object[][]{
                {"Судный","Супермен: Судный день,Судный день,Терминатор 2: Судный день"},
                {"Супермен: Судный день","Супермен: Судный день"}
        });
    }

    @Before
    public void mainPageOpen() {
        loginPage.openAndLogin();
        profilePage.gidOnlineImageClick();
    }

    @Test
    public void validSearch() {

//        String valueForSearch = "Судный";
//        String[] searchResults = {"Супермен: Судный день", "Судный день", "Терминатор 2: Судный день"};

        mainPage.inputValueInSearchField(valueForSearch);
        mainPage.searchButtonClick();
        searchResultPage.searchResult(searchResults);
    }

    @After
    public void logout(){
        mainPage.userButtonClick();
        profilePage.logOutButtonClick();
    }
}
