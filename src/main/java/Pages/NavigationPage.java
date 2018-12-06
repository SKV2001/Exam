package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationPage extends MainPage {


    public NavigationPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//form[@name='search']//select[1]")
    WebElement filmGenreButton;

    @FindBy(xpath = "//form[@name='search']//select[2]")
    WebElement filmYearButton;

    @FindBy(xpath = "//form[@name='search']//select[3]")
    WebElement filmCountryButton;

    @FindBy(xpath = "//form[@name='search']//select[4]")
    WebElement filmActorButton;

    @FindBy(xpath = "//form[@name='search']//select[5]")
    WebElement filmProducerButton;

    @FindBy(xpath = "//input[@value='Найти фильмы']")
    WebElement findFilmsButton;

    /**
     * Method click on button which opens Genre dropdown
     */
    public void filmGenreButtonClick(){workWithPageElements.clickOnElement(filmGenreButton);}

    /**
     * Method click on button which opens Year dropdown
     */
    public void filmYearButtonClick(){workWithPageElements.clickOnElement(filmYearButton);}

    /**
     * Method clicks on button which opens Country dropdown
     */
    public void filmCountryButtonClick(){workWithPageElements.clickOnElement(filmCountryButton);}

    /**
     * Method clicks on button which opens Actor dropdown
     */
    public void filmActorButtonClick(){workWithPageElements.clickOnElement(filmActorButton);}

    /**
     * Method clicks on button which opens Producer dropdown
     */
    public void filmProducerButtonClick(){workWithPageElements.clickOnElement(filmProducerButton);}

    /**
     * Method clicks on button which execute searching by selected in dropdowns values
     */
    public void findFilmsButtonClick(){workWithPageElements.clickOnElement(findFilmsButton);}

    /**
     * Method selects specified genre from dropdown
     * @param genre
     */
    public void selectFromGenreDropdown(String genre) {
        selectFromDropDownHelper("1",genre);
        // workWithPageElements.clickOnElement(workWithPageElements.findAndReturnElementOnPage(By.xpath("//select[@id='actors-dropdown']//option[text()='" + actor + "']")));
    }

    /**
     * Method selects specified year from dropdown
     * @param year
     */
    public void selectFromYearDropdown(String year){
        selectFromDropDownHelper("2",year);
    }

    /**
     * Method selects specified country from dropdown
     * @param country
     */
    public void selectFromCountryDropdown(String country){ selectFromDropDownHelper("3",country);}

    /**
     * Method selects specified actor from dropdown
     * @param actor
     */
    public void selectFromActorDropdown(String actor){selectFromDropDownHelper("4",actor);}

    /**
     * Method selects specified producer from dropdown
     * @param producer
     */
    public void selectFromProducerDropdown(String producer){selectFromDropDownHelper("5",producer);}

    /**
     * Method find corresponding element and click on it
     * @param index
     * @param text
     */
    public void selectFromDropDownHelper(String index, String text){
        workWithPageElements.clickOnElement(workWithPageElements.findAndReturnElementOnPage(By.xpath("//form[@name='search']//select["+index+"]//option[text()='"+text+"']")));
    }

    /**
     * Method check if found film is the same as expected
     * @param film
     */
    public void checkFoundFilm(String film) {

        Assert.assertEquals("Film is not found from navigator",true, workWithPageElements.isElementExist(workWithPageElements.findAndReturnElementOnPage(By.xpath("//span[text()='"+film+"']"))));
    }
}
