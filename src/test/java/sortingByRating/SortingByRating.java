package sortingByRating;

import org.junit.Before;
import org.junit.Test;
import parentTest.ParentTest;

public class SortingByRating extends ParentTest {


    @Before
    public void filmsPageOpening(){
        loginPage.openAndLogin();
        profilePage.gidOnlineImageClick();
    }

    String actor ="Ален Делон";

    @Test
    public void sortingFilmsByRate(){
            filmsPage.clickOnActorsButton();
            filmsPage.selectFromActorsDropdown(actor);
            filmsPage.clickOnSortByRatingStar();
            filmsPage.verifySortByRating();

    }
}
