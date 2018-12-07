package sortingByRating;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import parentTest.ParentTest;

public class SortingByRating extends ParentTest {


    @Before
    public void filmsPageOpening(){
        loginPage.openAndLogin();
        profilePage.gidOnlineImageClick();
    }

    @Test
    public void sortingFilmsByRate(){

            String actor ="Ален Делон";
        
            filmsPage.clickOnActorsButton();
            filmsPage.selectFromActorsDropdown(actor);
            filmsPage.clickOnSortByRatingStar();
            checkExpectedResult("Sorting films by rating is failed", filmsPage.verifySortByRating());

    }

    @After
    public void logout(){
        filmsPage.userButtonClick();
        profilePage.logOutButtonClick();
    }
}
