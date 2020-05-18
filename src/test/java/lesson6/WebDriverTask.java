package test.java.lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;

public class WebDriverTask {

    public static void main(String[] args) {
        System.out.println(findPhoneNumber());
    }

    public static String findPhoneNumber() {
        String result;
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://rozetka.com.ua/");
        result = driver.findElement(By.cssSelector("[class=\"link-dashed\"]")).getText().replaceAll("[()\\-\\s]", "").trim();
        driver.quit();
        return result;
    }
}
