package Pages;

import org.openqa.selenium.WebDriver;

public class LoginPage extends ParentPage {
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openLoginPage(){
        try {
            webDriver.get("https://gidonline.in/login/");
            logger.info("Login page was opened");
        }catch(Exception e){
            logger.error("Page is not opened "+e);
        }

    }
}
