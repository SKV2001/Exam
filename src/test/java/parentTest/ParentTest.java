package parentTest;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {
        WebDriver webdriver;
        @Before
        public void setup(){
                File file = new File("./src/drivers/chromedriver.exe");
                System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
                webdriver = new ChromeDriver();
                webdriver.manage().window().maximize();
                webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        }
        @After
        public void tearDown(){
                webdriver.quit();
        }

}
