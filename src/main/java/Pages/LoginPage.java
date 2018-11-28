package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }


    @FindBy(xpath = "//input[@id='user_login']")
    WebElement inputLogin;
    @FindBy(id = "user_pass")
    WebElement inputPassword;
    @FindBy(id = "wp-submit")
    WebElement vhodButton;

    public void openLoginPage() {
        try {
            webDriver.get("https://gidonline.in/login/");
            logger.info("Login page was opened");
            switchToFrame();
        } catch (Exception e) {
            logger.error("Page is not opened " + e);
        }

    }

    public void switchToFrame() {
        webDriver.switchTo().frame(0);
    }

    public void enterLogin(String login) {
        workWithPageElements.enterTextInToElement(login, inputLogin);
    }

    public void enterPassword(String password) {
        workWithPageElements.enterTextInToElement(password, inputPassword);
    }

    public void clickVoytiButton() {
        workWithPageElements.clickOnElement(vhodButton);
    }
}
