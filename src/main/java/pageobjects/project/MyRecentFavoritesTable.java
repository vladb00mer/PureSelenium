package pageobjects.project;

import common.ParentPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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


}
