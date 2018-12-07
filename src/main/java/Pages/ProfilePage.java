package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends ParentPage {
    @FindBy(xpath = "//a[@id='b_logout']")
    WebElement logOutButton;
    @FindBy(xpath = "//img[@src='/im/gidonline.png']")
    WebElement gidOnlineImg;

    public ProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    /**
     * Method clicks Logout button
     */
    public void logOutButtonClick() {
       workWithPageElements.clickOnElement(logOutButton);
    }

    /**
     * Method click on image-link which leads to main page
     */
    public void gidOnlineImageClick(){
        workWithPageElements.clickOnElement(gidOnlineImg);
    }
}
