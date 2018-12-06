package Pages;

import org.openqa.selenium.By;
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

    /**
     * Method opens Login page
     */
    public void openLoginPage() {
        try {
            webDriver.get("https://gidonline.in/login/");
            logger.info("Login page was opened");
        } catch (Exception e) {
            logger.error("Page is not opened " + e);
        }

    }

    /**
     * Method opens login page, enters login and password on it and click button to submit this information
     */
    public void openAndLogin (){
        openLoginPage();
        enterLogin("gidonline555");
        enterPassword("DuyJXZ3hW7tRvc");
        clickVoytiButton();
    }

    /**
     * Method enters specified login in login editbox
     * @param login
     */
    public void enterLogin(String login) {

        //workWithPageElements.enterTextInToElement(login, workWithPageElements.findElementOnPage(By.xpath("//input[@id='user_login']")));
        workWithPageElements.enterTextInToElement(login, inputLogin);
    }

    /**
     * Method enters specified password in password editbox
     * @param password
     */
    public void enterPassword(String password) {
        //workWithPageElements.enterTextInToElement(password, workWithPageElements.findElementOnPage(By.id("user_pass")));
        workWithPageElements.enterTextInToElement(password, inputPassword);
    }

    /**
     * Method clicks button "Войти"
     */
    public void clickVoytiButton() {
       // workWithPageElements.clickOnElement(workWithPageElements.findElementOnPage(By.id("wp-submit")));
        workWithPageElements.clickOnElement(vhodButton);
    }
}
