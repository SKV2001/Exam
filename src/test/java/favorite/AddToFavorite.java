package favorite;

import org.junit.Before;
import org.junit.Test;
import parentTest.ParentTest;

public class AddToFavorite extends ParentTest {

    @Before
    public void mainPageOpen() {
        loginPage.openAndLogin();
        profilePage.gidOnlineImageClick();
    }

    @Test
    public void addToFavorite() {
        String film = "Троя";
        mainPage.inputValueInSearchField(film);
        mainPage.searchButtonClick();
        mainPage.clickOnFilm(film);
        filmPage.addToFavoriteButtonClick();
        filmPage.goToFavoriteButtonClick();
        favoritePage.isFilmAddedToFavourite(film);
    }

}
