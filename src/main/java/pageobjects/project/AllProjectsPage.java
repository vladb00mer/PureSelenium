package pageobjects.project;

import common.Init;
import common.ParentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class AllProjectsPage extends ParentPage {

    @FindBy(xpath = "//div[contains(text(), 'All Projects')]")
    private WebElement allProjectsHeader;

    @FindBy(xpath = "//div[@ng-if='userCanCreateorUpdateProject']")
    private WebElement addNewProject;

    @FindBy(xpath = "//input[@placeholder='Search by Name']")
    private WebElement searchByName;

    @FindBy(xpath = "//input[@placeholder='Search by Project Code']")
    private WebElement searchByProjectCode;

    @FindBy(xpath = "//input[@placeholder='Search by API ID']")
    private WebElement searchByApiId;


    public AllProjectsPage() {

        PageFactory.initElements(Init.getWebDriver(), this);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOut()).until(ExpectedConditions.visibilityOf(allProjectsHeader));
    }

    public AllProjectsPage filterByProjectName(String name) {

        setTextValue(searchByName, name);
        return this;
    }
    public AllProjectsPage filterByProjectCode(String code) {

        setTextValue(searchByProjectCode, code);
        return this;
    }
    public AllProjectsPage filterByApiId(String apiId) {

        setTextValue(searchByApiId, apiId);
        return this;
    }

    public ProjectPage openFilteredProject(String name) {

        WebElement projectName = Init.getWebDriver().findElement(By.xpath("//a[@title='"+name+"']"));
        clickOnElement(projectName);

        return new ProjectPage();
    }

    public CreateProjectForm addNewProject() {

        clickOnElement(addNewProject);
        return new CreateProjectForm();
    }
}
