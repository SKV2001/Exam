package favorite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import parentTest.ParentTest;

public class AddToFavorite extends ParentTest {
    String film = "Троя";

    @Before
    public void mainPageOpen() {
        loginPage.openAndLogin();
        profilePage.gidOnlineImageClick();
        mainPage.goToFavoriteButtonClick();
        favoritePage.deleteFromFavorite(film);

    }

    @Test
    public void addToFavorite(){
        favoritePage.inputValueInSearchField(film);
        favoritePage.searchButtonClick();
        searchResultPage.clickOnFilm(film);
        filmPage.addToFavoriteButtonClick();
        filmPage.goToFavoriteButtonClick();
        favoritePage.isFilmAddedToFavourite(film);
    }

    @After
    public void cleaningFavoriteAndLogout(){
        favoritePage.deleteFromFavorite(film);
    favoritePage.userButtonClick();
    profilePage.logOutButtonClick();
    }

}
