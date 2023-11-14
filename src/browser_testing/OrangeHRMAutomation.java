package browser_testing;
/**
 * Project-2 - ProjectName : com-orangehrmlive
 * BaseUrl = https://opensource-demo.orangehrmlive.com/
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Click on ‘Forgot your password?’ link.
 * 7. Print the current url.
 * 8. Navigate back to the login page.
 * 9. Refresh the page.
 * 10. Enter the email to email field.
 * 11. Enter the password to password field.
 * 12. Click on Login Button.
 * 13. Close the browser.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Scanner;

public class OrangeHRMAutomation {
    static String baseURL = "https://opensource-demo.orangehrmlive.com/";
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        // Use scanner to get browser choice from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the browser name (Chrome/Firefox/Edge): ");
        String browser = scanner.nextLine();
        // Multi Browser choice
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser Name");
            return; // exit the program if the browser name is incorrect
        }
        // Step 1: Setup Chrome browser
        System.setProperty("webdriver.chrome.driver", "C:\\Soft\\chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        // Step 2: Open Url
        driver.get(baseURL);
        Thread.sleep(5000);
        // Step 3: Print the title of the page
        System.out.println("Title of the page: " + driver.getTitle());
        // Step 4: Print the current URL
        System.out.println("Current URL: " + driver.getCurrentUrl());
        // Step 5: Print the page source
        System.out.println("Page Source: " + driver.getPageSource());
        // Step 6: Click on 'Forgot your password?' link
        WebElement forgotPasswordLink = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']"));
        forgotPasswordLink.click();
        // Step 7: Print the current URL
        System.out.println("Current URL after clicking Forgot Password: " + driver.getCurrentUrl());
        // Step 8: Navigate back to the login page
        driver.navigate().back();
        // Step 9: Refresh the page
        driver.navigate().refresh();
        // Step 10: Enter email to email field
        WebElement emailField = driver.findElement(By.name("username"));
        emailField.sendKeys("prime@gmail.com");
        // Step 11: Enter password to password field
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("123456");
        // Step 12: Click on the Login Button
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        // Step 13: Close the browser
        driver.quit();
        // Close scanner
        scanner.close();
    }
}
