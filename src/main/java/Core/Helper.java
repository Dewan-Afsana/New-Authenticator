package Core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Helper {
    public static WebDriver driver;
    public void chrome(){
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        Map<String, Object> profile = new HashMap<String, Object>();
        Map<String, Integer> contentSettings = new HashMap<String, Integer>();


        // 0- Default, 1 - Allow, 2 - Block
        contentSettings.put("notifications", 2);
        contentSettings.put("geolocation", 2);
        profile.put("managed_default_content_settings", contentSettings);
        prefs.put("profile", profile);
        options.setExperimentalOption("prefs", prefs);

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }
    public void fireFox() {

        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(new FirefoxProfile());
        options.addPreference("dom.webnotifications.enabled", false);
        options.addPreference("geo.enabled", true);
        options.addPreference("geo.prompt.testing", true);
        options.addPreference("geo.prompt.testing.allow", true);
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver(options);
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();


    }
}

