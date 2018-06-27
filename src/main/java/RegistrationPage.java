import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import static org.assertj.core.api.Assertions.*;

public class RegistrationPage {
    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    private By buttonMonthly = By.xpath("//div[@class='myMonthly']");
    private By monthlyProPlan = By.xpath("(//div[@class='damount'])[1]");
    private By monthlyBusinessPlan = By.xpath("(//div[@class='damount'])[2]");
    private By monthlyEnterPrizePlan = By.xpath("(//div[@class='damount'])[3]");
    private static String url = "https://exitget.com/pricing";

    public RegistrationPage clickMonthlyButton(){
        MainPage mainPage = new MainPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        driver.findElement(buttonMonthly).click();
        mainPage.pause(300);
        assertThat(driver.findElement(monthlyProPlan).getText()).isEqualTo("123");
        assertThat(driver.findElement(monthlyBusinessPlan).getText()).isEqualTo("498");
        assertThat(driver.findElement(monthlyEnterPrizePlan).getText()).isEqualTo("1248+");
        return this;
    }

//    private By header = By.xpath("//div[@id='register_frame']//div[@class='contentlabel font_size_by_height']");
//    private By registerNameField = By.id("registername");
//    private By registereMailField = By.id("registeremail");
//    private By registerPasswdField = By.id("registerpass");
//    private By legalCheckbox = By.id("legalCheckbox");
//    private By registerButton = By.xpath("//button[@origtext='Register']");
//    private By closeIcon = By.xpath("//div[@id='register_frame']//img[@class='close']");
//    static private String url = "https://exitget.com";
//    private String userName;
//
//    public String getHeader(){
//        return trim((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(header)).getText());
//    }
//
//    private RegistrationPage inputName(String userName){
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
////        (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocated(registerNameField)).sendKeys(userName);
//        driver.findElement(registerNameField).sendKeys(userName);
//        return this;
//    }
//
//    private RegistrationPage inputEMail(String email){
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
////        (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocated(registereMailField)).sendKeys(email);
//        driver.findElement(registereMailField).sendKeys(email);
//        return this;
//    }
//
//    private RegistrationPage inputPassword(String passwd){
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
////        (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocated(registerPasswdField)).sendKeys(passwd);
//        driver.findElement(registerPasswdField).sendKeys(passwd);
//        return this;
//    }
//
//    private RegistrationPage tickCheckBox() {
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
////        (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocated(legalCheckbox)).click();
//        driver.findElement(legalCheckbox).click();
//        return this;
//    }
//
//    private RegistrationPage clickRegisterButton(){
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
////        (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocated(registerButton)).click();
//        driver.findElement(registerButton).click();
//        return this;
//    }
//
//    public void clickCloseIcon(){
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
////        (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocated(closeIcon)).click();
//        driver.findElement(closeIcon).click();
//    }
//
//    private void register(String username, String email, String passwd){
//        inputName(username);
//        inputEMail(email);
//        inputPassword(passwd);
//        tickCheckBox();
//        clickRegisterButton();
//    }
//
//    public void registerWithCorrectData(){
//        MainPage mainPage = new MainPage(driver);
//        OverviewPage overviewPage = new OverviewPage(driver);
//
//        driver.get(url);
//        mainPage.clickTopImageRegisterButton();
//        Assertions.assertEquals("Registration", getHeader(), "FAULT - We are not on the Registration page");
//        register(getUserName(), userName + "@exitget.com", "Ckfdfnhele_1");
//        Assertions.assertEquals(userName, overviewPage.getUserNameString(), "FAULT - We are not on the Overview page");
//    }
//
//    private String getUserName(){
//        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
//        Date today = Calendar.getInstance().getTime();
//        String dat = df.format(today);
//        return userName = "tester647382" + dat;
//    }
}
