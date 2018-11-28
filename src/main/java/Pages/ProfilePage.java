package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends ParentPage {
    @FindBy(xpath = "//a[@id='b_logout']")
    WebElement logOutButton;

    public ProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void logOutButtonClick() {
        //workWithPageElements.clickOnElement(webDriver.findElement(By.xpath("//a[@id='b_logout']")));
        workWithPageElements.clickOnElement(logOutButton);
    }
}
