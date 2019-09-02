package pageobjects.tables;

import common.Init;
import common.ParentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.project.ProjectPage;

import java.util.List;

public class MyRecentFavoritesTable extends ParentPage {

    @FindBy(xpath = "//table[@ng-table='favoritesTableParams']//input[@placeholder='Search by Name']")
    private WebElement searchByName;

    @FindBy(xpath = "//table[@ng-table='favoritesTableParams']//td[@data-title-text='Name']//a")
    private List<WebElement> favoritesTableNames;

    @FindBy(xpath = "//table[@ng-table='favoritesTableParams']//md-select[@placeholder='Search by Type']")
    private WebElement searchByType;

    @FindBy(xpath = "//table[@ng-table='favoritesTableParams']//td[@data-title-text='Type']//span")
    private List<WebElement> favoritesTableTypes;

    @FindBy(xpath = "//table[@ng-table='favoritesTableParams']//div[@place-holder='Search by Project Name']//input")
    private WebElement searchByProjectName;

    @FindBy(xpath = "//table[@ng-table='favoritesTableParams']//td[@data-title-text='Project Name']//span")
    private List<WebElement> favoritesTableProjectNames;

    @FindBy(xpath = "//table[@ng-table='favoritesTableParams']//div[@display-name='Last Accessed']/div/input")
    private WebElement searchByLastAccessed;

    @FindBy(xpath = "//table[@ng-table='favoritesTableParams']//td[@data-title-text='My Last Accessed']//span")
    private List<WebElement> favoritesTableMyLastAccessed;

    @FindBy(xpath = "//table[@ng-table='favoritesTableParams']//md-menu[@md-position-mode='target-right target']")
    private List<WebElement> favoritesTableOptions;


    public MyRecentFavoritesTable() {

        PageFactory.initElements(Init.getWebDriver(), this);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOut()).until(ExpectedConditions.visibilityOf(searchByName));
    }

    public MyRecentFavoritesTable filterByName(String name) {

        setTextValue(searchByName, name);
        return this;
    }

    public MyRecentFavoritesTable filterByType(String type) {

        setTextValue(searchByType, type);
        return this;
    }

    public MyRecentFavoritesTable filterByProjectName(String projectName) {

        setTextValue(searchByName, projectName);
        return this;
    }

    public MyRecentFavoritesTable filterByLastAccessed(String dateRange) {

        setTextValue(searchByName, dateRange);
        return this;
    }

    public ProjectPage openFilteredFavorite() {

        List<WebElement> projectNames = Init.getWebDriver().findElements(By.xpath("//table[@ng-table='favoritesTableParams']//td[@data-title-text='Name']/div/a"));
        projectNames.get(0).click();

        return new ProjectPage();
    }
}
