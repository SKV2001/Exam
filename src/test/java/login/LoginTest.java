package login;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.FindBy;
import parentTest.ParentTest;

public class LoginTest extends ParentTest {


    @Test
    public void validLogin() throws InterruptedException {
        loginPage.openLoginPage();
//        Thread.sleep(3000);
        loginPage.switchToFrame();
        loginPage.enterLogin("gidonline555");
        loginPage.enterPassword("DuyJXZ3hW7tRvc");
        loginPage.clickVoyti();

        Assert.assertEquals("Вход на ГидОнлайн", profilePage.getTitle());

    }

}
