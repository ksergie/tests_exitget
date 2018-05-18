import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static jdk.nashorn.internal.objects.NativeString.trim;

public class DashboardPage {
    private WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    private By itemOverview = By.xpath("//a[text()='Overview']");
    private By markerOverview = By.xpath("(//div[@id='stats_highlight']//div[@class='helptext'])[1]");
    private By itemUsageStatistics = By.xpath("//a[text()='Usage Statistics']");
    private By markerUsageStatistics = By.xpath("(//div[@id='contentPlace']//span)[1]");
    private By itemQuickStart = By.xpath("//a[text()='QuickStart Guide']");
    private By markerQuickStart = By.xpath("//div[@id='inputUrl']//span[@class='webAddress']");
    private By itemWebsites = By.xpath("//a[text()='Websites']");
    private By itemDomain = By.xpath("//a[text()='Domains']");
    private By markerDomain = By.xpath("//a[@title='Path']");
    private By itemHits = By.xpath("//a[text()='Hits']");
    private By markerHits = By.xpath("//a[@title='Path']");
    private By itemInstall = By.xpath("//a[text()='Install']");
    private By markerInstall = By.xpath("//div[@id ='inputUrl']//span[@class='webAddress']");
    private By itemDesign = By.xpath("//a[text()='Designs']");
    private By markerDesign = By.xpath("//a[@title='Design name']");
    private By itemCreateDesign = By.xpath("//a[text()='Create Design']");
    private By markerCreateDesign = By.xpath("(//div[@class='title'])[1]");
    private By itemDesignList = By.xpath("//a[text()='Designs List']");
    private By markerDesignList = By.xpath("//a[@title='Design name']");
    private By itemCampaigns = By.xpath("//a[text()='Campaigns']");


    public void clickMenuItems(){
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = new MainPage(driver);
        loginPage.loginWithCorrectData();
        (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(itemOverview)).click();
        String actual = (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(markerOverview)).getText();
        Assertions.assertEquals("VISITATIONS", actual, "We are not on the Overview page");

        (new WebDriverWait(driver, 15)).until(ExpectedConditions.visibilityOfElementLocated(itemUsageStatistics)).click();
        mainPage.pause(500);
        actual = (new WebDriverWait(driver, 15)).until(ExpectedConditions.visibilityOfElementLocated(markerUsageStatistics)).getText();
        Assertions.assertEquals("Visitations", actual, "We are not on the Usage Statistics page");

        (new WebDriverWait(driver, 15)).until(ExpectedConditions.visibilityOfElementLocated(itemQuickStart)).click();
        mainPage.pause(500);
        actual = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(markerQuickStart)).getText();
        Assertions.assertEquals("Enter the installation URL", actual, "We are not on the QuickStart Guide page");

        (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(itemWebsites)).click();
        mainPage.pause(500);
        boolean visibleItem = (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(itemWebsites)).isDisplayed();
        Assertions.assertTrue(visibleItem, "The Website item is not pressed");

        (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(itemDomain)).click();
        mainPage.pause(500);
        actual = trim((new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(markerDomain)).getText());
        Assertions.assertEquals("Domain", actual, "We are not on the Domain page");

        (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(itemHits)).click();
        mainPage.pause(500);
        actual = trim((new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(markerHits)).getText());
        Assertions.assertEquals("URL", actual, "We are not on the Hits page");

        (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(itemInstall)).click();
        mainPage.pause(500);
        actual = (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(markerInstall)).getText();
        Assertions.assertEquals("Enter the installation URL", actual, "We are not on the Install page");

        (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(itemDesign)).click();
        mainPage.pause(500);
        visibleItem = (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(markerDesign)).isDisplayed();
        Assertions.assertTrue(visibleItem, "The Design item is not pressed");

        (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(itemCreateDesign)).click();
        mainPage.pause(500);
        actual = trim((new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(markerCreateDesign)).getText());
        Assertions.assertEquals("CHOOSE THE DESIGN", actual, "We are not on the Create Design page");

        (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(itemDesignList)).click();
        mainPage.pause(500);
        actual = trim((new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(markerDesignList)).getText());
        Assertions.assertEquals("Design", actual, "We are not on the Design List page");
    }
}
