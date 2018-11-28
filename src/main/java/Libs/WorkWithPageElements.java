package Libs;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WorkWithPageElements {
    WebDriver webdriver;
    Logger logger = Logger.getLogger(getClass());

    public WorkWithPageElements(WebDriver webdriver) {
        this.webdriver = webdriver;
    }

    public void enterTextInToElement(String text, WebElement element) {
        try {
            element.clear();
            element.sendKeys(text);
            logger.info(text + " entered into element " + element);
        } catch (Exception e) {
            logger.error("Text is not added because of " + e);
        }

    }

    public void clickOnElement(WebElement element) {
        try {
            element.click();
            logger.info(element + " was clicked");
        } catch (Exception e) {
           logger.error(element + " was not clicked because of "+ e);
        }
    }

}
