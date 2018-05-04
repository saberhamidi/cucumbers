import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertEquals;


public class HRMSteps {

    private WebDriver driver;
    private ExtentTest test;
    private ExtentReports reports;
    private Actions actions;

    @org.junit.Before
    public void setTest(){

        System.setProperty("webdriver.chrome.driver", "../chromedriver");
        driver = new ChromeDriver();
        actions = new Actions(driver);
        reports = new ExtentReports("/Users/Saber/Desktop/QA Training/Week9/cucumbers/src/main/resources/report.html", true);
    }

    @Given("^the name of a user$")
    @Test
    public void the_name_of_a_user() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        test = reports.startTest("Search user");
        test.log(LogStatus.INFO, "Trying to login");

        //LOGIN
        driver.get("http://opensource.demo.orangehrmlive.com/");
        WebElement webElement = driver.findElement(By.xpath("//*[@id=\"txtUsername\"]"));
        webElement.sendKeys("admin");
        webElement = driver.findElement(By.xpath("//*[@id=\"txtPassword\"]"));
        webElement.sendKeys("admin");
        webElement.submit();
        test.log(LogStatus.PASS, "Logged in");

        //Search
        test.log(LogStatus.INFO, "Search for user");
        actions.moveToElement(driver.findElement(By.id("menu_admin_viewAdminModule"))).click().perform();
        webElement =  driver.findElement(By.xpath("//*[@id=\"searchSystemUser_userName\"]"));
        webElement =  driver.findElement(By.xpath("//*[@id=\"searchSystemUser_userName\"]"));
        webElement.sendKeys("Admin");
        webElement = driver.findElement(By.xpath("//*[@id=\"searchBtn\"]"));
        webElement.click();
        webElement = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td[2]/a"));

        //Analys the result
        if (webElement.getText().equals("Admin")){
            test.log(LogStatus.PASS, "Search Successfull!");
            AdminPage.setFile("/Users/Saber/Desktop/QA Training/Week9/cucumbers/src/main/resources/assessmentData.xlsx");
            AdminPage.writeReportResult("Pass", 2,4);
        }
        else {
            test.log(LogStatus.FAIL, "Search failed!");
            AdminPage.setFile("/Users/Saber/Desktop/QA Training/Week9/cucumbers/src/main/resources/assessmentData.xlsx");
            AdminPage.writeReportResult("Fail", 2, 4);
        }

        reports.endTest(test);
        reports.flush();
        assertEquals("Admin", webElement.getText());
    }

    @When("^I type this name into the search box$")
    public void i_type_this_name_into_the_search_box() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("^I see information about the user$")
    public void i_see_information_about_the_user() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @Given("^the Admin tab$")
    public void the_Admin_tab() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("^I click the add button$")
    public void i_click_the_add_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("^I complete the necessary details$")
    public void i_complete_the_necessary_details() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("^the new user is selectable$")
    public void the_new_user_is_selectable() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("^I select a tab next to a user name$")
    public void i_select_a_tab_next_to_a_user_name() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("^I click the Delete button$")
    public void i_click_the_Delete_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("^the user is no longer selectable$")
    public void the_user_is_no_longer_selectable() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @Given("^the Add Employee Tab$")
    public void the_Add_Employee_Tab() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("^I fill out the details correctly$")
    public void i_fill_out_the_details_correctly() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("^I click the Save button$")
    public void i_click_the_Save_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("^the employee can be searched for via the Employee List$")
    public void the_employee_can_be_searched_for_via_the_Employee_List() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("^I choose to create Login Details$")
    public void i_choose_to_create_Login_Details() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @org.junit.After
    public void kill() throws InterruptedException{
        Thread.sleep(5000);
        driver.quit();

    }
}
