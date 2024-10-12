package StepDefinitions;


import Pages.BankXYZ_Pages;
import Utilities.DataUtils;
import Utilities.LogsUtils;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.time.Duration;
import static DriverFactory.DriverFactory.*;
import static Utilities.DataUtils.getPropertyValue;


public class TC02_OpenAccSteps
{

    private final String FIRSTNAME = DataUtils.getJsonData("addingCustomer", "firstname");
    private final String LASTNAME = DataUtils.getJsonData("addingCustomer", "lastname");
    private final String POSTCODE = DataUtils.getJsonData("addingCustomer", "postcode");

    @Before
    public void setupTC02() throws Exception
    {
            String browser = System.getProperty("browser") != null ? System.getProperty("browser") : getPropertyValue("environment", "Browser");
            LogsUtils.info(System.getProperty("browser"));
            setupDriver(browser);
            LogsUtils.info(browser + " driver is opened");
            getDriver().get(getPropertyValue("environment", "BASE_URL"));
            LogsUtils.info("Page is redirected to the URL");
            getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Given("the user is navigated to XYZ Bank Page and logged in as bank manager ForTC02")
    public void LoginBankMgrTC02()
    {
        new BankXYZ_Pages(getDriver())
                .clickBankManagerLoginBtn();
    }

    @And("the user creates a new customer ForTC02")
    public void CreatingNewCustTC02()
    {
        new BankXYZ_Pages(getDriver())
                .clickAddingCustBtn()
                .EnterFirstN(FIRSTNAME)
                .EnterLastN(LASTNAME)
                .EnterPostcode(POSTCODE)
                .clickAddCustBtn()
                .checkCustAdding();
    }

    @Then("the user go to home and opening new account")
    public void OpeningNewAccTC02()
    {
        new BankXYZ_Pages(getDriver())
                .clickHomeBtn()
                .clickBankManagerLoginBtn()
                .clickOpenAccBtn()
                .ChooseCustomer()
                .ChooseCurrency()
                .clickProceedBtn()
                .checkproceeding();

    }

    @Then("the user can log in with the new account")
    public void LoginNewAccTC02()
    {
        new BankXYZ_Pages(getDriver())
                .clickHomeBtn()
                .clickonCustomLogin()
                .ChooseName()
                .clickProceedBtn();

    }

    @After
    public void quitTC02() {
        quitDriver();
    }
}
