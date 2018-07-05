import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import static org.assertj.core.api.Assertions.*;

public class RegistrationPage {
    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    private By buttonMonthly = By.xpath("//div[@class='myMonthly']");
    private By ProPlan = By.xpath("(//div[@class='damount'])[1]");
    private By BusinessPlan = By.xpath("(//div[@class='damount'])[2]");
    private By EnterPrisePlan = By.xpath("(//div[@class='damount'])[3]");
    private By buttonYearly = By.xpath("//div[@class='myYearly']");
    private By getStarted = By.xpath("//h3");
    private By fieldName = By.id("nameInput");
    private By fieldEmail = By.id("emailInput");
    private By buttonContinue = By.id("sendInput");
    private By fieldPassword = By.id("passwordInput");
    private By dropdownSelectAccount = By.id("accountType");
    private By passwordPageHeader = By.xpath("//div[@class='headlineTitle']/h3");
    private By dropdownOption = By.xpath("//select[@name='accountType']/option[@value='other']");
    private By theIamHeader = By.xpath("//input[@name='other_description']//following::div[1]");
    private By fieldWebsiteName = By.name("other_name");
    private By fieldWebsiteUrl = By.name("other_website");
    private By fieldWebsiteDescription = By.name("other_description");
    private By fieldJobPosition = By.name("other_job");
    private By paymentHeader = By.xpath("//label[@id='cycle_choose']/span");
    private By buttonAddCreditCard = By.id("addCreditCard");
    private By addCreditCardHeader = By.xpath("//header[@class='Header']//h1");
    private By fieldCardNumber = By.xpath("//input[@placeholder='Card number']");
    private By fieldCardExpDate = By.xpath("//input[@placeholder='MM / YY']");
    private By fieldCardCVC = By.xpath("//input[@placeholder='CVC']");
    private By fieldCardZipcode = By.xpath("//input[@placeholder='ZIP Code']");
    private By buttonCard = By.xpath("//div[@class='Section-button']/button");
    private By dashboardHeader = By.xpath("//div[@id='header_links']/a");



    private static String websiteName = "tester647382";
    private static String websiteUrl = "www.tester647382.com";
    private static String websiteDescription = "For the testing!";
    private static String jobPosition = "QA Engineer";

    private static String cardNumber = "4242424242424242";
    private static String cardExpDate = "1221";
    private static String cardCVC = "123";
    private static String cardZipcode = "38330";

    private static String url = "https://exitget.com/pricing";
    private static String urlNamePasswdForm = "https://exitget.com/signup/plan/enterprise/yearly";


    public RegistrationPage RegistrationForms(){
        driver.manage().window().maximize();
        MainPage mainPage = new MainPage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(urlNamePasswdForm);
        String userName = getUserName();
        driver.findElement(fieldName).sendKeys(userName);
        driver.findElement(fieldEmail).sendKeys(userName + "@gmail.com");
        driver.findElement(buttonContinue).click();
        mainPage.pause(1500);
//        assertThat(driver.findElement(passwordPageHeader).getText()).isEqualTo("Set up your password");
        driver.findElement(fieldPassword).sendKeys("Ckfdfnhele_1");
        driver.findElement(buttonContinue).click();
        mainPage.pause(1500);
//        assertThat(driver.findElement(passwordPageHeader).getText()).isEqualTo("Set up your account");
        driver.findElement(dropdownSelectAccount).click();
        driver.findElement(dropdownOption).click();
        mainPage.pause(1500);
//        assertThat(driver.findElement(theIamHeader).getText()).isEqualTo("Job Position");
        driver.findElement(fieldWebsiteName).sendKeys(websiteName);
        driver.findElement(fieldWebsiteUrl).sendKeys(websiteUrl);
        driver.findElement(fieldWebsiteDescription).sendKeys(websiteDescription);
        driver.findElement(fieldJobPosition).sendKeys(jobPosition);
        driver.findElement(buttonContinue).click();
        mainPage.pause(1500);
//        assertThat(driver.findElement(paymentHeader).getText()).isEqualTo("Choose the Yearly Subscription");
        driver.findElement(buttonAddCreditCard).click();
        mainPage.pause(1500);
        driver.switchTo().frame(0);
        mainPage.pause(1500);
//        assertThat(driver.findElement(addCreditCardHeader).getText()).isEqualTo("Exitget");
        driver.findElement(fieldCardNumber).sendKeys(cardNumber);
        driver.findElement(fieldCardExpDate).sendKeys(cardExpDate);
        driver.findElement(fieldCardCVC).sendKeys(cardCVC);
        driver.findElement(fieldCardZipcode).sendKeys(cardZipcode);
        driver.findElement(buttonCard).click();
        (new WebDriverWait(driver, 5)).until(ExpectedConditions.invisibilityOfElementLocated(buttonCard));
        mainPage.pause(1500);
        driver.switchTo().defaultContent();
        mainPage.pause(1500);
//        assertThat(driver.findElement(paymentHeader).getText()).isEqualTo("Choose the Yearly Subscription");
        (new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(buttonContinue)).click();
        mainPage.pause(3000);
        assertThat(driver.findElement(dashboardHeader).getText()).isEqualTo(userName);
        return this;
    }

    public RegistrationPage clickMonthlyButton(){
        driver.manage().window().maximize();
        MainPage mainPage = new MainPage(driver);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(url);
        driver.findElement(buttonMonthly).click();
        mainPage.pause(300);
        assertThat(driver.findElement(ProPlan).getText()).isEqualTo("123");
        assertThat(driver.findElement(BusinessPlan).getText()).isEqualTo("498");
        assertThat(driver.findElement(EnterPrisePlan).getText()).isEqualTo("1248+");
        return this;
    }

    public RegistrationPage clickYearlyButton(){
        driver.manage().window().maximize();
        MainPage mainPage = new MainPage(driver);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(url);
        driver.findElement(buttonMonthly).click();
        mainPage.pause(300);
        driver.findElement(buttonYearly).click();
        mainPage.pause(300);
        assertThat(driver.findElement(ProPlan).getText()).isEqualTo("99");
        assertThat(driver.findElement(BusinessPlan).getText()).isEqualTo("399");
        assertThat(driver.findElement(EnterPrisePlan).getText()).isEqualTo("999+");
        return this;
    }

    public RegistrationPage clickSelectPlanButton(){
        driver.manage().window().maximize();
        MainPage mainPage = new MainPage(driver);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(url);
        for (int i = 1; i < 4; i++){
            String xpath = "(//a[text()='SELECT PLAN'])[" + i + "]";
            driver.findElement(By.xpath(xpath)).click();
            mainPage.pause(1000);
            assertThat(driver.findElement(getStarted).getText()).isEqualTo("Let's get started");
            driver.navigate().back();
        }
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
//        return trim((new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocatedElementLocated(header)).getText());
//    }
//
//    private RegistrationPage inputName(String userName){
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
////        (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocatedElementLocated(registerNameField)).sendKeys(userName);
//        driver.findElement(registerNameField).sendKeys(userName);
//        return this;
//    }
//
//    private RegistrationPage inputEMail(String email){
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
////        (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocatedElementLocated(registereMailField)).sendKeys(email);
//        driver.findElement(registereMailField).sendKeys(email);
//        return this;
//    }
//
//    private RegistrationPage inputPassword(String passwd){
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
////        (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocatedElementLocated(registerPasswdField)).sendKeys(passwd);
//        driver.findElement(registerPasswdField).sendKeys(passwd);
//        return this;
//    }
//
//    private RegistrationPage tickCheckBox() {
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
////        (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocatedElementLocated(legalCheckbox)).click();
//        driver.findElement(legalCheckbox).click();
//        return this;
//    }
//
//    private RegistrationPage clickRegisterButton(){
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
////        (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocatedElementLocated(registerButton)).click();
//        driver.findElement(registerButton).click();
//        return this;
//    }
//
//    public void clickCloseIcon(){
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
////        (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocatedElementLocated(closeIcon)).click();
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
    private String getUserName(){
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        Date today = Calendar.getInstance().getTime();
        String dat = df.format(today);
        return "tester647382" + dat;
    }
}
