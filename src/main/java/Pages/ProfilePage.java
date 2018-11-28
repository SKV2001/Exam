package Pages;

import org.openqa.selenium.WebDriver;

public class ProfilePage extends ParentPage {
    public ProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getTitle() {
        return webDriver.getTitle();
    }
}
