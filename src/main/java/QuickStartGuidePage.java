import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static jdk.nashorn.internal.objects.NativeString.trim;

public class QuickStartGuidePage {

    private WebDriver driver;

    public QuickStartGuidePage(WebDriver driver) {
        this.driver = driver;
    }

    MainPage mainPage = new MainPage(driver);

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

    private QuickStartGuidePage setInslallUrl(){
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(installUrlField)).sendKeys(targetSiteUrl);
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(installUrlNextButton)).click();
        return this;
    }

    private String getDevModeFormHeader() {
        return (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(devModeFormHeader)).getText();
    }

    private QuickStartGuidePage setDevMode(){
        mainPage.pause(300);
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(devModeSwitch)).click();
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(devModeFormNextButton)).click();
        return this;
    }

    private String getChooseImageFormHeader(){
        return (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(chooseImageFormHeader)).getText();
    }

    private QuickStartGuidePage setTemplate(){
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(filterAdvertisementsSelector)).click();
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(redirectOnlyOption)).click();
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(template)).click();
        return this;
    }

    private String getcustomizeDesignFormHeader(){
        return (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(customizeDesignHeader)).getText();
    }

    private QuickStartGuidePage clickPreviewButton(){
        mainPage.pause(300);
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(previewButton)).click();
        return this;
    }

    private QuickStartGuidePage clickNextButton(){
        mainPage.pause(300);
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(nextButton)).click();
        return this;
    }

    private String getInputRedirectionUrlHeader(){
        return (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(inputRedirectionUrlHeader)).getText();
    }

    private QuickStartGuidePage inputRedirectionUrl(){
        mainPage.pause(300);
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(redirectionUrlField)).sendKeys("https://exitget.com");
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(redirectUrlNextButton)).click();
        return this;
    }

    private String getTriggerTypeHeader(){
        return (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(triggerTypeHeader)).getText();
    }

    private QuickStartGuidePage clickTriggetTypeNextButton(){
        mainPage.pause(300);
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(triggerTypeNextButton)).click();
        return this;
    }

    private String getConfirmInstallationHeader(){
        mainPage.pause(300);
        return (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(confirmInstallationHeader)).getText();
    }

    public void quickStartGuide(){
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        OverviewPage overviewPage = new OverviewPage(driver);
        AccountPage accountPage = new AccountPage(driver);
        AlertPage alertPage = new AlertPage(driver);

        driver.get("https://exitget.com");
        mainPage.clickHeaderLoginButton();
        loginPage.login("exitgetest@gmail.com", "20exitget17");
        overviewPage.clickAccountButton();
        Assertions.assertEquals("a12f41728769c1", accountPage.getHeaderPage(), "FAULT - We are not on the Account page");
        // Reset Account
        accountPage.inputCurrentPassword();
        accountPage.clickResetAccountButton();
        accountPage.closeAlertWindow();
        Assertions.assertEquals("true", accountPage.getAccountResultMessage(), "FAULT - Reset account is not done");
        accountPage.clickCloseButton();
        Assertions.assertEquals("VISITATIONS", overviewPage.getHeader(), "FAULT - We are not on the Overview page");
        overviewPage.clickQuickstartItem();
        Assertions.assertEquals("Enter the installation URL", getHeader(), "FAULT - We are not on the QuickStart page");
        setInslallUrl();
        Assertions.assertEquals("Development mode", getDevModeFormHeader(), "FAULT - We are not on the Development Mode form");
        setDevMode();
        Assertions.assertEquals("Choose the advertisement background", getChooseImageFormHeader(), "FAULT - We are not on the Choose background form");
        setTemplate();
        Assertions.assertEquals("Profesional Design Customization", getcustomizeDesignFormHeader(),
                "FAULT - We are not on the Profesional Design Customization form");
        clickPreviewButton();
        Assertions.assertTrue(alertPage.isVisible(), "The Alert window is not appear after pressing the Preview button");
        alertPage.clickOkButton();
        clickNextButton();
        Assertions.assertEquals("Enter the redirection URL", getInputRedirectionUrlHeader(),
                "FAULT - We are not on the redirection URL form");
        inputRedirectionUrl();
        Assertions.assertEquals("1 rules configred", getTriggerTypeHeader(), "FAULT - We are not on the Triggers form");
        clickTriggetTypeNextButton();
        Assertions.assertEquals("Final step: Confirm installation", getConfirmInstallationHeader(),
                "FAULT - We are not on the Confirm installation form");
    }
}
