package Libs;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WorkWithPageElements {
    WebDriver webdriver;
    Logger logger = Logger.getLogger(getClass());

    public WorkWithPageElements(WebDriver webdriver) {
        this.webdriver = webdriver;
    }

    /**
     * Method seeking for element and return true if element exist
     * @param element
     * @return
     */
    public boolean isElementExist(WebElement element) {
        try {
            return element.isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Method seeking for element using by path and return true if element was found
     * @param by
     * @return
     */
    public boolean isElementExist(By by) {
        try {
            return findAndReturnElementOnPage(by).isDisplayed();
        } catch (Exception e) {
            logger.error("Element " + by + " couldn't be found");
            return false;
        }

    }

    /**
     * Method seeking for element on the page in both frames and return this element.
     * @param by
     * @return
     */
    public WebElement findAndReturnElementOnPage(By by) {
        try {
            new Actions(webdriver).moveToElement(webdriver.findElement(by)).perform();
            return webdriver.findElement(by);
        } catch (Exception e) {
        }
        try {
            webdriver.switchTo().frame(0);
            new Actions(webdriver).moveToElement(webdriver.findElement(by)).perform();
            return webdriver.findElement(by);
        } catch (Exception e) {
        }
        try {
            webdriver.switchTo().defaultContent();
            new Actions(webdriver).moveToElement(webdriver.findElement(by)).perform();
            return webdriver.findElement(by);
        } catch (Exception e) {
            logger.error("Element " + by + " couldn't be found");
            return null;
        }
    }

    /**
     * Method enters text into editbox, no matter where this editbox located (frame0 or default frame)
     * @param text
     * @param element
     */
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

    /**
     * Method clicks on element, no matter where it located (frame0 or default frame)
     * @param element
     */
    public void clickOnElement(WebElement element) {
        try {
            if (isElementExist(element)) {
                new Actions(webdriver).moveToElement(element).perform();
                element.click();
                logger.info(element + " was clicked");
            } else {
                try {
                    webdriver.switchTo().frame(0);
                    new Actions(webdriver).moveToElement(element).perform();
                    element.click();
                    logger.info(element + " was clicked");
                } catch (Exception e) {
                    webdriver.switchTo().defaultContent();
                    new Actions(webdriver).moveToElement(element).perform();
                    element.click();
                    logger.info(element + " was clicked");
                }
            }
        } catch (Exception e) {
            logger.error("Element couldn't be clicked because of" + e);
        }

    }

    /**
     * Method clicks on element, no matter where it located (frame0 or default frame)
     * @param by
     */
    public void clickOnElement(By by) {
        try {
            if (isElementExist(findAndReturnElementOnPage(by))) {
                new Actions(webdriver).moveToElement(findAndReturnElementOnPage(by)).perform();
                findAndReturnElementOnPage(by).click();
                logger.info(findAndReturnElementOnPage(by) + " was clicked");
            } else {
                try {
                    webdriver.switchTo().frame(0);
                    new Actions(webdriver).moveToElement(findAndReturnElementOnPage(by)).perform();
                    findAndReturnElementOnPage(by).click();
                    logger.info(findAndReturnElementOnPage(by) + " was clicked");
                } catch (Exception e) {
                    webdriver.switchTo().defaultContent();
                    new Actions(webdriver).moveToElement(findAndReturnElementOnPage(by)).perform();
                    findAndReturnElementOnPage(by).click();
                    logger.info(findAndReturnElementOnPage(by) + " was clicked");
                }
            }
        } catch (Exception e) {
            logger.error("Element couldn't be clicked because of" + e);
        }

    }
    /**
     * Method clicks on element located in defined frame
     * @param element
     * @param frame
     */
    public void clickOnElement(WebElement element, char frame) {
        try {
            element.click();
            logger.info(element + " was clicked");
        } catch (Exception e) {
            if (frame == 1) {
                webdriver.switchTo().frame(0);
                element.click();
                logger.info(element + " was clicked");
            } else {
                webdriver.switchTo().defaultContent();
                element.click();
                logger.info(element + " was clicked");
            }
        }
    }
}
