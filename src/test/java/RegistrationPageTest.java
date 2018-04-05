import com.automation.remarks.junit5.Video;
import io.github.bonigarcia.SeleniumExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static java.lang.System.setProperty;

@ExtendWith(SeleniumExtension.class)
@DisplayName("Registration page tests")
public class RegistrationPageTest {
    private RegistrationPage registrationPage;
    private MainPage mainPage;
    private OverviewPage overviewPage;

    @BeforeAll
    static void setUp() {
        setProperty("wdm.edgeVersion", "3.14393");
    }

    @TestTemplate
    @Video(name = "Registration page. Registration with correct data")
    @DisplayName("Registration page. Registration with correct data")
    void testRegisterWithCorrectData(WebDriver driver){
        mainPage = new MainPage(driver);
        registrationPage = new RegistrationPage(driver);
        driver.get("https://exitget.com");
        mainPage.clickTopImageRegisterButton();
        registrationPage.register(getUserName(), getUserName() + "@gmai.com", "20exitget18");
        overviewPage = new OverviewPage(driver);
        Assertions.assertEquals(getUserName(), overviewPage.getUserNameString(), "FAULT - We are not on the Overview page");
}

public String getUserName(){
    DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
    Date today = Calendar.getInstance().getTime();
    String dat = df.format(today);
    return "tester" + dat;
}
}

