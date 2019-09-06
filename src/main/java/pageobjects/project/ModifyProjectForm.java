package pageobjects.project;

import common.Init;
import common.ParentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ModifyProjectForm extends ParentPage {

    @FindBy(xpath = "//form[@name='projectEditingDialog']//button[@aria-label='Close dialog']")
    private WebElement closeButton;

    @FindBy(xpath = "//form[@name='projectEditingDialog']//input[@id='projectName']")
    private WebElement projectNameArea;

    @FindBy(xpath = "//form[@name='projectEditingDialog']//input[@id='projectCode']")
    private WebElement projectCodeArea;

    @FindBy(xpath = "//form[@name='projectEditingDialog']//input[@id='apiID']")
    private WebElement apiIdArea;

    @FindBy(xpath = "//input[@aria-label='Search']")
    private WebElement therapeuticArea;

    @FindBy(xpath = "//label[@class='column-items-list_label']/span")
    private List<WebElement> processesCheckBoxes;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveProjectButton;


    ModifyProjectForm() {

        PageFactory.initElements(Init.getWebDriver(), this);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOut()).until(ExpectedConditions.visibilityOf(closeButton));
    }

    public ModifyProjectForm setProjectName(String projectName) {

        setTextValue(projectNameArea, projectName);
        return this;
    }

    public ModifyProjectForm setProjectCode(String projectCode) {

        setTextValue(projectCodeArea, projectCode);
        return this;
    }

    public ModifyProjectForm setApiId(String apiId) {

        setTextValue(apiIdArea, apiId);
        return this;
    }

    public ModifyProjectForm setTherapeuticArea(String projectName) {

        setTextValue(therapeuticArea, projectName);
        Init.getWebDriver().findElement(By.xpath("//span[contains(text(), '"+projectName+"')]")).click();
        return this;
    }

    public ModifyProjectForm selectProcesses(int... rec) {

        for (WebElement element: processesCheckBoxes) {

            clickOnElement(element);
        }

        for (int i: rec) {

            clickOnElement(processesCheckBoxes.get(i));
        }

        return this;
    }

    public AllProjectsPage saveProject() {

        clickOnElement(saveProjectButton);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new AllProjectsPage();
    }
}
