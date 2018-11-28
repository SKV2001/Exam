package login;

import org.junit.Before;
import org.junit.Test;
import parentTest.ParentTest;

public class SearchTest extends ParentTest {

    @Before
    public void mainPageOpen(){
        loginPage.openAndLogin();
       // profilePage.switchToFrame();
        profilePage.gidOnlineImageClick();
    }

    @Test
    public void validSearch(){
        mainPage.inputValueInSearchField("Судный");
        mainPage.searchButtonClick();
    }
}
