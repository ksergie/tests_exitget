import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static jdk.nashorn.internal.objects.NativeString.trim;

public class QuickStartGuidePage {

    private WebDriver driver;

    public QuickStartGuidePage(WebDriver driver) {
        this.driver = driver;
    }

    private By headerPage = By.xpath("//div[@id='inputUrl']//span[@class='webAddress']");
    private By installUrlField = By.id("installUrl");
    private String targetSiteUrl = "https://exitgetester.tumblr.com";
    private By installUrlNextButton = By.xpath("//div[@id='inputUrl']//input[@type='button']");
    private By devModeFormHeader = By.xpath("//div[@id='debugMode']//span[@class='webAddress']");
    private By devModeSwitch = By.xpath("//div[@id='debugMode']//div[@class='switch-button-background']");
    private By devModeFormNextButton = By.xpath("//div[@id='debugMode']//button");
    private By chooseImageFormHeader = By.xpath("//div[@id='chooseImage']//span[@class='webAddress']");
    private By filterAdvertisementsSelector = By.xpath("//select[@class='filter_advertisements']");
    private By redirectOnlyOption = By.xpath("//select[@class='filter_advertisements']/option[@value='button']");
    private By template = By.xpath("(//div[@id='campaignpick']//div[@class='tn button']/img)[1]");
    private By customizeDesignHeader = By.xpath("//div[@id='customizeDesign']//span[@class='webAddress']");
    private By previewButton = By.xpath("//div[@id='customizeDesign']//button[@class='plain preview']");
    private By nextButton = By.xpath("//div[@id='customizeDesign']//button[@class='styled done']");
    private By inputRedirectionUrlHeader = By.xpath("//div[@id='inputRedirectionUrl']//span[@class='webAddress']");
    private By redirectionUrlField = By.id("redirectionUrl");
    private By redirectUrlNextButton = By.xpath("//div[@id='inputRedirectionUrl']//input[@type='button']");
    private By triggerTypeHeader = By.xpath("//div[@id='triggerType']//span[@class='webAddress']");
    private By triggerTypeNextButton = By.xpath("//div[@id='triggerType']//button");
    private By confirmInstallationHeader = By.xpath("//div[@id='testInstallation']//span[@class='webAddress']");

    public String getHeader(){
        return trim((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(headerPage)).getText());
    }

    public QuickStartGuidePage setInslallUrl(){
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(installUrlField)).sendKeys(targetSiteUrl);
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(installUrlNextButton)).click();
        return this;
    }

    public String getDevModeFormHeader() {
        return (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(devModeFormHeader)).getText();
    }

    public QuickStartGuidePage setDevMode(){
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(devModeSwitch)).click();
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(devModeFormNextButton)).click();
        return this;
    }

    public String getChooseImageFormHeader(){
        return (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(chooseImageFormHeader)).getText();
    }

    public QuickStartGuidePage setTemplate(){
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocated(filterAdvertisementsSelector)).click();
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(redirectOnlyOption)).click();
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(template)).click();
        return this;
    }

    public String getcustomizeDesignFormHeader(){
        return (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(customizeDesignHeader)).getText();
    }

    public QuickStartGuidePage clickPreviewButton(){
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(previewButton)).click();
        return this;
    }

    public QuickStartGuidePage clickNextButton(){
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(nextButton)).click();
        return this;
    }

    public String getInputRedirectionUrlHeader(){
        return (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(inputRedirectionUrlHeader)).getText();
    }

    public QuickStartGuidePage inputRedirectionUrl(){
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(redirectionUrlField)).sendKeys("https://exitget.com");
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(redirectUrlNextButton)).click();
        return this;
    }

    public String getTriggerTypeHeader(){
        return (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(triggerTypeHeader)).getText();
    }

    public QuickStartGuidePage clickTriggetTypeNextButton(){
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(triggerTypeNextButton)).click();
        return this;
    }

    public String getConfirmInstallationHeader(){
        return (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(confirmInstallationHeader)).getText();
    }
}
