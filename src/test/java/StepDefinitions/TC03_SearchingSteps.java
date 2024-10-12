package StepDefinitions;

import Pages.BankXYZ_Pages;
import Utilities.DataUtils;
import Utilities.LogsUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.time.Duration;
import static DriverFactory.DriverFactory.*;
import static Utilities.DataUtils.getPropertyValue;


public class TC03_SearchingSteps
{

    private final String FIRSTNAME = DataUtils.getJsonData("addingCustomer", "firstname");
    private final String LASTNAME = DataUtils.getJsonData("addingCustomer", "lastname");
    private final String POSTCODE = DataUtils.getJsonData("addingCustomer", "postcode");



    @Before
    public void setup() throws Exception
    {
        String browser = System.getProperty("browser") != null ? System.getProperty("browser") : getPropertyValue("environment", "Browser");
        LogsUtils.info(System.getProperty("browser"));
        setupDriver(browser);
        LogsUtils.info(browser + " driver is opened");
        getDriver().get(getPropertyValue("environment", "BASE_URL"));
        LogsUtils.info("Page is redirected to the URL");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Given("the user is navigated to XYZ Bank Page and logged in as bank manager ForTC03")
    public void LoginBankMgrTC03()
    {
        new BankXYZ_Pages(getDriver())
                .clickBankManagerLoginBtn();
    }

    @And("the user creates a new customer ForTC03")
    public void CreatingNewCustTC03()
    {
        new BankXYZ_Pages(getDriver())
                .clickAddingCustBtn()
                .EnterFirstN(FIRSTNAME)
                .EnterLastN(LASTNAME)
                .EnterPostcode(POSTCODE)
                .clickAddCustBtn()
                .checkCustAdding();
    }

    @Then("the user go to home and clicks the Customers button ForTC03")
    public void clickOnCustButtonTC03()
    {
        new BankXYZ_Pages(getDriver())
                .clickHomeBtn()
                .clickBankManagerLoginBtn()
                .clickonCustomers();

    }

    @Then("the user searches for the customer by name")
    public void SearchingCustTC03()
    {
        new BankXYZ_Pages(getDriver())
                .SearchByName(FIRSTNAME);

    }

    @Then("the customer should be found in the search results")
    public void CheckingSearchingTC03()
    {
        new BankXYZ_Pages(getDriver())
                .CheckSearching(FIRSTNAME);
    }

    @After
    public void quitTC03()
    {
        quitDriver();
    }

}
