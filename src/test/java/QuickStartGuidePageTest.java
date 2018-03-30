import io.github.bonigarcia.SeleniumExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import static java.lang.System.setProperty;

@ExtendWith(SeleniumExtension.class)
@DisplayName("QuickStartGuide page test")
public class QuickStartGuidePageTest {

    private MainPage mainPage;
    private LoginPage loginPage;
    private OverviewPage overviewPage;
    private QuickStartGuidePage quickStartGuidePage;
    private AccountPage accountPage;
    private AlertPage alertPage;

    @BeforeAll
    static void setup() {
        setProperty("wdm.edgeVersion", "3.14393");
    }

    @TestTemplate
    @DisplayName("QuickStartGuide page. Test")
    void testQuickStartGuide(WebDriver driver){

        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        overviewPage = new OverviewPage(driver);
        quickStartGuidePage = new QuickStartGuidePage(driver);
        accountPage = new AccountPage(driver);
        alertPage = new AlertPage(driver);


        driver.get("https://exitget.com");
        mainPage.clickHeaderLoginButton();
        loginPage.login("exitgetest@gmail.com", "20exitget17");
        Assertions.assertEquals("VISITATIONS", overviewPage.getHeader(), "FAULT - We are not on the Overview page");

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
        Assertions.assertEquals("Enter the installation URL", quickStartGuidePage.getHeader(), "FAULT - We are not on the QuickStart page");

        quickStartGuidePage.setInslallUrl();
        Assertions.assertEquals("Development mode", quickStartGuidePage.getDevModeFormHeader(), "FAULT - We are not on the Development Mode form");

        quickStartGuidePage.setDevMode();
        Assertions.assertEquals("Choose the advertisement background", quickStartGuidePage.getChooseImageFormHeader(), "FAULT - We are not on the Choose background form");

        quickStartGuidePage.setTemplate();
        Assertions.assertEquals("Profesional Design Customization", quickStartGuidePage.getcustomizeDesignFormHeader(), "FAULT - We are not on the Profesional Design Customization form");

        quickStartGuidePage.clickPreviewButton();
        Assertions.assertTrue(alertPage.isVisible(), "The Alert window is not appear after pressing the Preview button");
        alertPage.clickOkButton();

        quickStartGuidePage.clickNextButton();
        Assertions.assertEquals("Enter the redirection URL", quickStartGuidePage.getInputRedirectionUrlHeader(), "FAULT - We are not on the redirection URL form");

        quickStartGuidePage.inputRedirectionUrl();
        Assertions.assertEquals("1 rules configred", quickStartGuidePage.getTriggerTypeHeader(), "FAULT - We are not on the Triggers form");

        quickStartGuidePage.clickTriggetTypeNextButton();
        Assertions.assertEquals("Final step: Confirm installation", quickStartGuidePage.getConfirmInstallationHeader(), "FAULT - We are not on the Confirm installation form");


    }

}
