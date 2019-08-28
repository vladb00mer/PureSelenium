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

public class CreateProjectForm extends ParentPage {

    @FindBy(xpath = "//form[@name='projectCreateDialog']//button[@aria-label='Close dialog']")
    private WebElement closeButton;

    @FindBy(xpath = "//form[@name='projectCreateDialog']//input[@id='projectName']")
    private WebElement projectNameArea;

    @FindBy(xpath = "//form[@name='projectCreateDialog']//input[@id='projectCode']")
    private WebElement projectCodeArea;

    @FindBy(xpath = "//form[@name='projectCreateDialog']//input[@id='apiID']")
    private WebElement apiIdArea;

    @FindBy(xpath = "//input[@aria-label='Search']")
    private WebElement therapeuticArea;

    @FindBy(xpath = "//input[@type='checkbox']")
    private List<WebElement> processesCheckBoxes;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveProjectButton;


    CreateProjectForm() {

        PageFactory.initElements(Init.getWebDriver(), this);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOut()).until(ExpectedConditions.visibilityOf(closeButton));
    }

    public CreateProjectForm setProjectName(String projectName) {

        setTextValue(projectNameArea, projectName);
        return this;
    }

    public CreateProjectForm setProjectCode(String projectCode) {

        setTextValue(projectCodeArea, projectCode);
        return this;
    }

    public CreateProjectForm setApiId(String apiId) {

        setTextValue(apiIdArea, apiId);
        return this;
    }

    public CreateProjectForm setTherapeuticArea(String projectName) {

        setTextValue(therapeuticArea, projectName);
        Init.getWebDriver().findElement(By.xpath("//span[contains(text(), '"+projectName+"')]")).click();
        return this;
    }

    public CreateProjectForm setProcessesCheckBoxes(String state, String... processes) {

        for (String value: processes) {

            for (WebElement element: processesCheckBoxes) {

                if (element.getAttribute("title").equals(value)) {

                    setCheckBox(element, state);
                }
            }
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
