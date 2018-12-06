package login;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

public class LoginTest extends ParentTest {


    @Test
    public void validLogin() {
        loginPage.openLoginPage();
        loginPage.enterLogin("gidonline555");
        loginPage.enterPassword("DuyJXZ3hW7tRvc");
        loginPage.clickVoytiButton();

        Assert.assertEquals("Login Failed!","Вход на ГидОнлайн", profilePage.getTitle());

    }

    @After
    public void logOut(){
       profilePage.logOutButtonClick();
    }
}
