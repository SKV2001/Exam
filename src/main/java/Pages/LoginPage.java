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

    public void openLoginPage() {
        try {
            webDriver.get("https://gidonline.in/login/");
            logger.info("Login page was opened");
        } catch (Exception e) {
            logger.error("Page is not opened " + e);
        }

    }

    public void openAndLogin (){
        openLoginPage();
        enterLogin("gidonline555");
        enterPassword("DuyJXZ3hW7tRvc");
        clickVoytiButton();
    }

    public void enterLogin(String login) {
        workWithPageElements.enterTextInToElement(login, workWithPageElements.findElementOnPage(By.xpath("//input[@id='user_login']")));
       // workWithPageElements.enterTextInToElement(login, webDriver.findElement(By.xpath("//input[@id='user_login']")));
        //workWithPageElements.enterTextInToElement(login, inputLogin);
    }

    public void enterPassword(String password) {
        workWithPageElements.enterTextInToElement(password, workWithPageElements.findElementOnPage(By.id("user_pass")));
        //workWithPageElements.enterTextInToElement(password, webDriver.findElement(By.id("user_pass")));
        //workWithPageElements.enterTextInToElement(password, inputPassword);
    }

    public void clickVoytiButton() {
        workWithPageElements.clickOnElement(workWithPageElements.findElementOnPage(By.id("wp-submit")));
        //workWithPageElements.clickOnElement(webDriver.findElement(By.id("wp-submit")));
        //workWithPageElements.clickOnElement(vhodButton);
    }
}
