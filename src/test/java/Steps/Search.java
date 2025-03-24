package Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.Objects;

public class Search {
    WebDriver driver=new ChromeDriver();
    @Given("I enter special characters into the search bar")
    public void iu()
    {
        driver.get("https://www.noon.com/egypt-en/");
        driver.manage().window().maximize();

    }
    @When("I click on the search icon or press enter")
    public void when_2() throws InterruptedException {
        driver.findElement(By.id("searchBar")).sendKeys("---//**+-");
        driver.findElement(By.id("searchBar")).sendKeys(Keys.ENTER);
    }
    @Then("I should see a message indicating that no products were found")
    public void then_2() throws InterruptedException {

        String exp="We couldn’t find what you were looking for";
        String actual=driver.findElement(By.xpath("//*[@id=\"__next\"]/div/section/div/p[1]")).getText();
        Assert.assertTrue(Objects.equals(actual, exp));
    }

    @Given("I am on the homepage")
    public void given()
    {
        driver.get("https://www.noon.com/egypt-en/");
        driver.manage().window().maximize();
    }
    @And("I enter \"laptop\" in the search bar")
    public void and_1()
    {
        driver.findElement(By.id("searchBar")).sendKeys("Laptop");

    }
    @When("I press the Enter key on the keyboard")
    public void when()
    {
        driver.findElement(By.id("searchBar")).sendKeys(Keys.ENTER);



    }
    @Then("I should see a list of search results related to \"laptop\"")
    public void then() {
        driver.navigate().to("https://www.noon.com/egypt-en/search/?q=laptop");
    }


}
