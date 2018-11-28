package login;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
        mainPage.searchResult();
    }
}
