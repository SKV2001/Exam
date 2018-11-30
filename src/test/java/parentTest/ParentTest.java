package parentTest;

import Libs.WorkWithPageElements;
import Pages.LoginPage;
import Pages.MainPage;
import Pages.ProfilePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {

        WebDriver webDriver;
        protected LoginPage loginPage;
        protected ProfilePage profilePage;
        protected MainPage mainPage;
        protected WorkWithPageElements workWithPageElements;

        @Before
        public void setup(){
                File file = new File("./src/drivers/chromedriver.exe");
                System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
                webDriver = new ChromeDriver();
                webDriver.manage().window().maximize();
                webDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
                loginPage = new LoginPage(webDriver);
                profilePage = new ProfilePage(webDriver);
                mainPage = new MainPage(webDriver);
        }
        @After
        public void tearDown(){
                webDriver.quit();
        }

        public void checkExpectedResult(String message, boolean actualResult, boolean expectedResult) {
                Assert.assertEquals(message, expectedResult, actualResult);
        }

        public void checkExpectedResult(String message, boolean actualResult) {
                Assert.assertEquals(message, true, actualResult);
        }


}
