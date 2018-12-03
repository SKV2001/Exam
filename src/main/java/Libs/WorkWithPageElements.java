package Libs;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WorkWithPageElements {
    WebDriver webdriver;
    Logger logger = Logger.getLogger(getClass());

    public WorkWithPageElements(WebDriver webdriver) {
        this.webdriver = webdriver;
    }

    public boolean isElementExist(WebElement element) {
        try {
            return element.isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementExist(By by) {
        try {
            return findElementOnPage(by).isDisplayed();
        } catch (Exception e) {
            logger.error("Element " + by + " couldn't be found");
            return false;
        }

    }


    public WebElement findElementOnPage(By by) {
        try {
            return webdriver.findElement(by);
        } catch (Exception e) {
        }
        try {
            webdriver.switchTo().frame(0);
            return webdriver.findElement(by);
        } catch (Exception e) {
        }
        try {
            webdriver.switchTo().defaultContent();
            return webdriver.findElement(by);
        } catch (Exception e) {
            logger.error("Element " + by + " couldn't be found");
            return null;
        }
    }

    public void enterTextInToElement(String text, WebElement element) {
        try {
            if (isElementExist(element)) {
                element.clear();
                element.sendKeys(text);
                logger.info(text + " entered into element " + element);
            } else {
                try {
                    webdriver.switchTo().frame(0);
                    element.clear();
                    element.sendKeys(text);
                    logger.info(text + " entered into element " + element);
                } catch (Exception e) {
                    webdriver.switchTo().defaultContent();
                    element.clear();
                    element.sendKeys(text);
                    logger.info(text + " entered into element " + element);
                }
            }
        } catch (Exception e) {
            logger.error("Text couldn't be entered because of " + e);
        }
    }

    public void clickOnElement(WebElement element) {
        try {
            if (isElementExist(element)) {
                element.click();
                logger.info(element + " was clicked");
            } else {
                try {
                    webdriver.switchTo().frame(0);
                    element.click();
                    logger.info(element + " was clicked");
                } catch (Exception e) {
                    webdriver.switchTo().defaultContent();
                    element.click();
                    logger.info(element + " was clicked");
                }
            }
        } catch (Exception e) {
            logger.error("Element couldn't be clicked because of" + e);
        }

    }
}
