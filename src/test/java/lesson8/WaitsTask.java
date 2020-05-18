package test.java.lesson8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfAllElementsLocatedBy;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class WaitsTask {
    WebDriver driver;
    By login = By.cssSelector("[class='header-topline__user-link link-dashed']");
    By register = By.cssSelector("[class='auth-modal__register-link']");
    By name = By.cssSelector("[formcontrolname='name']");
    By username = By.cssSelector("[formcontrolname='username']");
    By password = By.cssSelector("[formcontrolname='password']");
    By submit = By.cssSelector("[type='submit']");
    String expectedColor = ("rgb(231, 113, 117)");

    @BeforeMethod
    public void beforeMethod(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }

    @Test
    public void registerAllEmptyRed() {
        driver.get("https://rozetka.com.ua/");
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.findElement(login).click();
        driver.findElement(register).click();
        WebElement nameField = driver.findElement(name);
        nameField.click();
        WebElement usernameField = driver.findElement(username);
        usernameField.click();
        WebElement passwordField = driver.findElement(password);
        passwordField.click();
        driver.findElement(submit).click();

        new WebDriverWait(driver, 10).until(presenceOfAllElementsLocatedBy(name));
        String actualBorderColorOfNameField = nameField.getCssValue("border-color");
        assertEquals(actualBorderColorOfNameField, expectedColor, "Name assert failed:");

        new WebDriverWait(driver, 10).until(presenceOfAllElementsLocatedBy(username));
        String actualBorderColorOfUsernameField = usernameField.getCssValue("border-color");
        assertEquals(actualBorderColorOfUsernameField, expectedColor, "Username assert failed:");

        new WebDriverWait(driver, 10).until(presenceOfAllElementsLocatedBy(password));
        String actualBorderColorOfPasswordField = passwordField.getCssValue("border-color");
        assertEquals(actualBorderColorOfPasswordField, expectedColor, "Password assert failed:");
    }

    @Test
    public void registerOneFilledOtherRed() {
        driver.get("https://rozetka.com.ua/");
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.findElement(login).click();
        driver.findElement(register).click();
        WebElement nameField = driver.findElement(name);
        nameField.sendKeys("Тест");
        WebElement usernameField = driver.findElement(username);
        usernameField.click();
        WebElement passwordField = driver.findElement(password);
        passwordField.click();
        driver.findElement(submit).click();

        new WebDriverWait(driver, 10).until(presenceOfAllElementsLocatedBy(name));
        String actualBorderColorOfNameField = nameField.getCssValue("border-color");
        assertNotEquals(actualBorderColorOfNameField, expectedColor);

        new WebDriverWait(driver, 10).until(presenceOfAllElementsLocatedBy(username));
        String actualBorderColorOfUsernameField = usernameField.getCssValue("border-color");
        assertEquals(actualBorderColorOfUsernameField, expectedColor, "Username assert failed:");

        new WebDriverWait(driver, 10).until(presenceOfAllElementsLocatedBy(password));
        String actualBorderColorOfPasswordField = passwordField.getCssValue("border-color");
        assertEquals(actualBorderColorOfPasswordField, expectedColor, "Password assert failed:");
    }

    /*@AfterMethod
    public void afterMethod() {
        driver.quit();
    }*/
}
