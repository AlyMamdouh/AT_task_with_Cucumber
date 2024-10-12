package steps;

import Pages.BankXYZ_Pages;
import Utilities.DataUtils;
import Utilities.LogsUtils;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import java.io.IOException;
import java.time.Duration;
import static DriverFactory.DriverFactory.*;

public class TC01_AddingCustomerSteps {

    private final String FIRSTNAME = DataUtils.getJsonData("addingCustomer", "firstname");
    private final String LASTNAME = DataUtils.getJsonData("addingCustomer", "lastname");
    private final String POSTCODE = DataUtils.getJsonData("addingCustomer", "postcode");

    @Before
    public void setup() throws IOException {
        String browser = System.getProperty("browser") != null ? System.getProperty("browser") : DataUtils.getPropertyValue("environment", "Browser");
        LogsUtils.info(System.getProperty("browser"));
        setupDriver(browser);
        LogsUtils.info(browser + " driver is opened");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @Given("the browser is opened")
    public void openBrowser() {
        // We already opened the browser in the @Before hook
    }

    @And("the user navigates to the bank's homepage")
    public void navigateToHomepage() throws IOException {
        getDriver().get(DataUtils.getPropertyValue("environment", "BASE_URL"));
        LogsUtils.info("Page is redirected to the URL");
    }

    @When("the user logs in as bank manager")
    public void loginAsManager() {
        new BankXYZ_Pages(getDriver())
                .clickBankManagerLoginBtn();
    }

    @And("clicks the {string} button")
    public void clickAddCustomerBtn(String btnName) {
        if ("Add Customer".equals(btnName)) {
            new BankXYZ_Pages(getDriver()).clickAddingCustBtn();
        }
    }

    @And("enters the first name, last name, and postcode")
    public void enterCustomerDetails() {
        new BankXYZ_Pages(getDriver())
                .EnterFirstN(FIRSTNAME)
                .EnterLastN(LASTNAME)
                .EnterPostcode(POSTCODE)
                .clickAddCustBtn();
    }

    @Then("the customer should be added successfully")
    public void verifyCustomerAdded() {
        new BankXYZ_Pages(getDriver()).checkCustAdding();
    }

    @After
    public void teardown() {
        quitDriver();
        LogsUtils.info("Driver is closed");
    }


}
