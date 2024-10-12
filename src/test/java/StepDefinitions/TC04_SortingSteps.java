package StepDefinitions;

import Pages.BankXYZ_Pages;
import Utilities.LogsUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Duration;

import static DriverFactory.DriverFactory.*;
import static Utilities.DataUtils.getPropertyValue;


public class TC04_SortingSteps
{
    @Before("@Sorting")
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

    @Given("the user is navigated to XYZ Bank Page and logged in as bank manager ForTC04")
    public void LoginBankMgrTC04()
    {
        new BankXYZ_Pages(getDriver())
                .clickBankManagerLoginBtn();
    }

    @Then("the user clicks the Customers button ForTC04")
    public void clickOnCustButtonTC04()
    {
        new BankXYZ_Pages(getDriver())
                .clickonCustomers();


    }

    @When("the user clicks on the postcode column to sort")
    public void ClickingSortTC04()
    {
        new BankXYZ_Pages(getDriver())
                .clickonPostCode();


    }

    @Then("the user should see customers sorted and the order type")
    public void CheckingSortTC04()
    {
        new BankXYZ_Pages(getDriver())
                .checkSortingOrder();
    }

    @When("the user clicks on the postcode column again to sort again")
    public void ClickingSortAgainTC04()
    {
        new BankXYZ_Pages(getDriver())
                .clickonPostCode();
    }

    @Then("the user should see customers sorted and the order type again")
    public void CheckingSortAgainTC04()
    {
        new BankXYZ_Pages(getDriver())
                .checkSortingOrder();
    }

    @After("@Sorting")
    public void quitTC04() {
        quitDriver();
    }
}
