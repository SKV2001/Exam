package Pages;

import Libs.WorkWithPageElements;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class ParentPage {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    WorkWithPageElements workWithPageElements;

    public static final char defFrame = 0;
    public static final char frame1 = 1;

    public ParentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        workWithPageElements = new WorkWithPageElements(webDriver);
    }

    public String getTitle() {
        return webDriver.getTitle();
    }
}
