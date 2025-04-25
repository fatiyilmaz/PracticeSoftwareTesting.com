package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class Driver {
    static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (utilities.ConfigReader.getProperty("browser")) {
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();

                    // (Opsiyonel) Gerçek kullanıcı gibi görünmek için:
                    chromeOptions.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64)");

                    // Otomasyon izini gizlemek için
                    chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
                    chromeOptions.setExperimentalOption("useAutomationExtension", false);
                    chromeOptions.addArguments("--disable-blink-features=AutomationControlled");

                    driver = new ChromeDriver(chromeOptions);
                    break;

                case "edge":
                    driver = new EdgeDriver();
                    break;

                case "safari":
                    driver = new SafariDriver();
                    break;

                default:
                    driver = new InternetExplorerDriver();
            }
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    // reCAPTCHA checkbox'ına tıklama fonksiyonu
    public static void clickRecaptchaCheckbox() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        // reCAPTCHA checkbox'ının elementini bul
        WebElement captchaCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='g-recaptcha']")));

        // Checkbox'a tıklama
        captchaCheckbox.click();
    }
}
