package Pages;

import org.openqa.selenium.By;
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
       // workWithPageElements.clickOnElement(workWithPageElements.findAndReturnElementOnPage(By.xpath("//a[@id='b_logout']")));
          workWithPageElements.clickOnElement(logOutButton);
        //  workWithPageElements.clickOnElement(logOutButton,frame1);

    }

    /**
     * Method click on image-link which leads to main page
     */
    public void gidOnlineImageClick(){
        //workWithPageElements.clickOnElement(workWithPageElements.findAndReturnElementOnPage(By.xpath("//img[@src='/im/gidonline.png']")));
        workWithPageElements.clickOnElement(gidOnlineImg);
       // workWithPageElements.clickOnElement(gidOnlineImg, defFrame);
    }
}
