package StepDefinitions;

import Pages.BankXYZ_Pages;
import Utilities.DataUtils;
import Utilities.LogsUtils;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import java.io.IOException;
import java.time.Duration;
import static DriverFactory.DriverFactory.*;
import static Utilities.DataUtils.getPropertyValue;

public class TC01_AddingCustomerSteps
{

    private final String FIRSTNAME = DataUtils.getJsonData("addingCustomer", "firstname");
    private final String LASTNAME = DataUtils.getJsonData("addingCustomer", "lastname");
    private final String POSTCODE = DataUtils.getJsonData("addingCustomer", "postcode");

    @Before
    public void setupTC01() throws IOException {
        String browser = System.getProperty("browser") != null ? System.getProperty("browser") : getPropertyValue("environment", "Browser");
        LogsUtils.info(System.getProperty("browser"));
        setupDriver(browser);
        LogsUtils.info(browser + " driver is opened");
        getDriver().get(getPropertyValue("environment", "BASE_URL"));
        LogsUtils.info("Page is redirected to the URL");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @Given("the user is navigated to XYZ Bank Page and logged in as bank manager ForTC01")
    public void LoginBankManagerTC01()
    {
        new BankXYZ_Pages(getDriver())
                .clickBankManagerLoginBtn();
    }

    @When("the user clicks on the Add Customer button")
    public void AddingCustomerTC01()
    {
        new BankXYZ_Pages(getDriver())
            .clickAddingCustBtn();
    }

    @And("fills in the customer details and clicks on the Add Customer button")
    public void FillingCustDataTC01()
    {
        new BankXYZ_Pages(getDriver())
            .EnterFirstN(FIRSTNAME)
            .EnterLastN(LASTNAME)
            .EnterPostcode(POSTCODE)
            .clickAddCustBtn();
    }

    @Then("a success message should be displayed")
    public void verifyCustomerAddedTC01()
    {
        new BankXYZ_Pages(getDriver())
                .checkCustAdding();
    }

    @After
    public void quitTC01() {
        quitDriver();
        LogsUtils.info("Driver is closed");
    }


}
