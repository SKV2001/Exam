package navigator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import parentTest.ParentTest;

public class NavigatorTest extends ParentTest {

    @Before
    public void mainPageOpen() {
        loginPage.openAndLogin();
        profilePage.gidOnlineImageClick();
    }

    String genre = "комедия";
    String year = "1994";
    String country = "США";
    String actor = "Джим Керри";
    String producer = "Чак Рассел";
    String navigatorResult = "Маска";


    @Test
    public void navigatorUseForFilmSearching() {
        mainPage.navigatorButtonClick();
        navigationPage.filmGenreButtonClick();
        navigationPage.selectFromGenreDropdown(genre);
        navigationPage.filmYearButtonClick();
        navigationPage.selectFromYearDropdown(year);
        navigationPage.filmCountryButtonClick();
        navigationPage.selectFromCountryDropdown(country);
        navigationPage.filmActorButtonClick();
        navigationPage.selectFromActorDropdown(actor);
        navigationPage.filmProducerButtonClick();
        navigationPage.selectFromProducerDropdown(producer);
        navigationPage.findFilmsButtonClick();
        navigationPage.checkFoundFilm(navigatorResult);
    }

    @After
    public void logout(){
        navigationPage.userButtonClick();
        profilePage.logOutButtonClick();
    }
}
