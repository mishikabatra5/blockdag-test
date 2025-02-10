package Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;
import java.util.UUID;
import java.util.logging.Logger;

public class BaseClass {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final Logger logger = Logger.getLogger(BaseClass.class.getName());

    private static String baseUrl;

    static {
        loadConfig();
    }

    private static void loadConfig() {
        try {
            // Pehle System Property check karega
            baseUrl = System.getProperty("BASE_URL");

            if (baseUrl == null || baseUrl.isEmpty()) {
                // Agar system property nahi mili, toh config.properties se read karega
                Properties prop = new Properties();
                FileInputStream fis = new FileInputStream("config.properties");
                prop.load(fis);
                baseUrl = prop.getProperty("BASE_URL");
                fis.close();
            }

            if (baseUrl == null || baseUrl.isEmpty()) {
                // Agar config.properties me bhi na mile, toh default URL use karega
                baseUrl = "https://explorer.devdomain123.com/";
                System.out.println("Using Default URL: " + baseUrl);
            } else {
                System.out.println("BASE_URL from config: " + baseUrl);
            }

        } catch (IOException e) {
            System.err.println("Could not load config.properties: " + e.getMessage());
            baseUrl = "https://explorer.devdomain123.com/"; // Default fallback URL
            System.out.println("Using Default URL: " + baseUrl);
        }
    }

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            logger.info("Initializing WebDriver...");
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();

            String userDataDir = "/tmp/user-data-dir-" + UUID.randomUUID().toString();
            options.addArguments("--user-data-dir=" + userDataDir);
            options.addArguments("--no-sandbox", "--disable-dev-shm-usage");

            String headless = System.getProperty("headless", "true");
            if ("true".equalsIgnoreCase(headless)) {
                logger.info("Running in headless mode...");
                options.addArguments("--headless=new", "--disable-gpu", "--window-size=1920,1080");
            }

            WebDriver webDriver = new ChromeDriver(options);
            webDriver.manage().window().maximize();
            driver.set(webDriver);
            logger.info("WebDriver initialized successfully.");
        }
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            logger.info("Quitting WebDriver...");
            driver.get().quit();
            driver.remove();
            logger.info("WebDriver quit successfully.");
        }
    }

    public static void loadURL(String url) {
        logger.info("Loading URL: " + url);
        getDriver().get(url);
    }

    public void loadingUrl() throws InterruptedException {
        loadingUrl(baseUrl);  // Load URL from config.properties
    }

    public void loadingUrl(String url) throws InterruptedException {
        loadURL(url);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
        logger.info("Page loaded successfully: " + url);
    }

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(BaseClass::quitDriver));
    }
}
