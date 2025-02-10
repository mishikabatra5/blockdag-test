////----------------------------------------------------change------------------------------------------------------------------
//package Helper;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class BaseClass {
//    public static WebDriver driver;
//
//    public static WebDriver getDriver() {
//        if (driver == null) {
//            WebDriverManager.chromedriver().setup();
//
//            // Adding ChromeOptions
//            ChromeOptions options = new ChromeOptions();
//
//            // Check for the 'headless' system property
//            String headless = System.getProperty("headless", "false"); // Default to false
//            if ("true".equalsIgnoreCase(headless)) {
//                options.addArguments("--headless"); // Enable headless mode
//                options.addArguments("--disable-gpu"); // Disable GPU to avoid potential issues
//                options.addArguments("--window-size=1920,1080"); // Set a default window size for headless mode
//            }
//
//            driver = new ChromeDriver(options);
//            driver.manage().window().maximize();
//        }
//        return driver;
//    }
//
//    public void quitDriver() {
//        if (driver != null) {
//            driver.quit();
//            driver = null;
//        }
//    }
//
//    // Declaring the URL for specific path
//    public static void loadURL(String url) {
//        getDriver().get(url);
//    }
//
//    // Main method that will call the BaseClass loading and quitting driver
//    public void loadingUrl() throws InterruptedException {
//        BaseClass.loadURL("https://explorer.devdomain123.com/");
//
//        // Time to see the loaded URL
//        Thread.sleep(5000);
//    }
//}
//---------------------------------------------------change updated--------------------------------------------------------------------

//-----------------------------------------------------------firefox baseclass----------------------------------------------------------
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class BaseClass {
//    public static WebDriver driver;
//
//    public static WebDriver getDriver() {
//        if (driver == null) {
//            WebDriverManager.firefoxdriver().setup(); // Set up Firefox WebDriver
//
//            // Adding FirefoxOptions
//            FirefoxOptions options = new FirefoxOptions();
//
//            // Check for the 'headless' system property
//            String headless = System.getProperty("headless", "false"); // Default to false
//            if ("true".equalsIgnoreCase(headless)) {
//                options.addArguments("--headless"); // Enable headless mode
//                options.addArguments("--disable-gpu"); // Disable GPU to avoid potential issues (optional for Firefox)
//                options.addArguments("--window-size=1920,1080"); // Set a default window size for headless mode
//            }
//
//            driver = new FirefoxDriver(options); // Initialize FirefoxDriver with options
//            driver.manage().window().maximize();
//        }
//        return driver;
//    }
//
//    public void quitDriver() {
//        if (driver != null) {
//            driver.quit();
//            driver = null;
//        }
//    }
//
//    // Declaring the URL for specific path
//    public static void loadURL(String url) {
//        getDriver().get(url);
//    }
//
//    // Main method that will call the BaseClass loading and quitting driver
//    public void loadingUrl() throws InterruptedException {
//        BaseClass.loadURL("https://bdagscan.com");
//
//        // Time to see the loaded URL
//        Thread.sleep(5000);
//    }
//}
//--------------------------------------frefox baseclass ended--------------------------------------------------------------------------------


//=======================================baseclass 1---------------------------------------------------------------------------------------
//package Helper;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.By;
//
//import java.time.Duration;
//import java.util.UUID;
//import java.util.logging.Logger;
//
//public class BaseClass {
//    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
//    private static final Logger logger = Logger.getLogger(BaseClass.class.getName());
//
//    public static WebDriver getDriver() {
//        if (driver.get() == null) {
//            logger.info("Initializing WebDriver...");
//            WebDriverManager.chromedriver().setup();
//            ChromeOptions options = new ChromeOptions();
//
//            // Use a unique user data directory
//            String userDataDir = "/tmp/user-data-dir-" + UUID.randomUUID().toString();
//            options.addArguments("--user-data-dir=" + userDataDir);
//
//            // Check for headless mode
//            String headless = System.getProperty("headless", "false");
//            if ("true".equalsIgnoreCase(headless)) {
//                logger.info("Running in headless mode...");
//                options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1080");
//            }
//
//            WebDriver webDriver = new ChromeDriver(options);
//            webDriver.manage().window().maximize();
//            driver.set(webDriver);
//            logger.info("WebDriver initialized successfully.");
//        }
//        return driver.get(); //
//    }
//
//    public static void quitDriver() {
//        if (driver.get() != null) {
//            logger.info("Quitting WebDriver...");
//            driver.get().quit();
//            driver.remove();
//            logger.info("WebDriver quit successfully.");
//        }
//    }
//
//    public static void loadURL(String url) {
//        logger.info("Loading URL: " + url);
//        getDriver().get(url);
//    }
//
//    public void loadingUrl() throws InterruptedException {
//        loadingUrl("https://explorer.devdomain123.com/"); // Default URL
//    }
//
//    public void loadingUrl(String url) throws InterruptedException {
//        loadURL(url);
//
//        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body"))); // Example: Wait for page to load
//        logger.info("Page loaded successfully: " + url);
//    }
//}
//
//------------------------------------------------baseclass 1 ended------------------------------------------------------------------

//====================================baseclass 2 for CI/CD=================================================================
//package Helper;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.By;
//
//import java.time.Duration;
//import java.util.UUID;
//import java.util.logging.Logger;
//
//public class BaseClass {
//    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
//    private static final Logger logger = Logger.getLogger(BaseClass.class.getName());
//
//    public static WebDriver getDriver() {
//        if (driver.get() == null) {
//            logger.info("Initializing WebDriver...");
//            WebDriverManager.chromedriver().setup();
//            ChromeOptions options = new ChromeOptions();
//
//            // Use a unique user data directory
//            String userDataDir = "/tmp/user-data-dir-" + UUID.randomUUID().toString();
//            options.addArguments("--user-data-dir=" + userDataDir);
//
//            // Add CI/CD-specific options
//            options.addArguments("--no-sandbox"); // Required for CI/CD
//            options.addArguments("--disable-dev-shm-usage"); // Prevent shared memory issues
//
//            // Enable headless mode by default in CI/CD
//            String headless = System.getProperty("headless", "true"); // Default to true
//            if ("true".equalsIgnoreCase(headless)) {
//                logger.info("Running in headless mode...");
//                options.addArguments("--headless=new", "--disable-gpu", "--window-size=1920,1080");
//            }
//
//            WebDriver webDriver = new ChromeDriver(options);
//            webDriver.manage().window().maximize();
//            driver.set(webDriver);
//            logger.info("WebDriver initialized successfully.");
//        }
//        return driver.get();
//    }
//
//    public static void quitDriver() {
//        if (driver.get() != null) {
//            logger.info("Quitting WebDriver...");
//            driver.get().quit();
//            driver.remove();
//            logger.info("WebDriver quit successfully.");
//        }
//    }
//
//    public static void loadURL(String url) {
//        logger.info("Loading URL: " + url);
//        getDriver().get(url);
//    }
//
//    public void loadingUrl() throws InterruptedException {
//        loadingUrl("https://explorer.devdomain123.com/"); // Default URL
//    }
//
//    public void loadingUrl(String url) throws InterruptedException {
//        loadURL(url);
//        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body"))); // Example: Wait for page to load
//        logger.info("Page loaded successfully: " + url);
//    }
//
//    static {
//        // Ensure WebDriver is cleaned up when JVM shuts down
//        Runtime.getRuntime().addShutdownHook(new Thread(BaseClass::quitDriver));
//    }
//}
//==================================================baseclass 2 for CI/CD ended=======================================================.

//================================================baseclass 2 with CI/CD and extent report ===========================================
//package Helper;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.By;
//
//import java.time.Duration;
//import java.util.UUID;
//import java.util.logging.Logger;
//
//public class BaseClass {
//    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
//    private static final Logger logger = Logger.getLogger(BaseClass.class.getName());
//
//    public static WebDriver getDriver() {
//        if (driver.get() == null) {
//            logger.info("Initializing WebDriver...");
//            WebDriverManager.chromedriver().setup();
//            ChromeOptions options = new ChromeOptions();
//
//            String userDataDir = "/tmp/user-data-dir-" + UUID.randomUUID().toString();
//            options.addArguments("--user-data-dir=" + userDataDir);
//            options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
//
//            String headless = System.getProperty("headless", "true");
//            if ("true".equalsIgnoreCase(headless)) {
//                logger.info("Running in headless mode...");
//                options.addArguments("--headless=new", "--disable-gpu", "--window-size=1920,1080");
//            }
//
//            WebDriver webDriver = new ChromeDriver(options);
//            webDriver.manage().window().maximize();
//            driver.set(webDriver);
//            logger.info("WebDriver initialized successfully.");
//        }
//        return driver.get();
//    }
//
//    public static void quitDriver() {
//        if (driver.get() != null) {
//            logger.info("Quitting WebDriver...");
//            driver.get().quit();
//            driver.remove();
//            logger.info("WebDriver quit successfully.");
//        }
//    }
//
//    public static void loadURL(String url) {
//        logger.info("Loading URL: " + url);
//        getDriver().get(url);
//    }
//
//    public void loadingUrl() throws InterruptedException {
//        loadingUrl("https://explorer.devdomain123.com/");
//    }
//
//    public void loadingUrl(String url) throws InterruptedException {
//        loadURL(url);
//        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
//        logger.info("Page loaded successfully: " + url);
//    }
//
//    static {
//        Runtime.getRuntime().addShutdownHook(new Thread(BaseClass::quitDriver));
//    }
//}


//================================================baseclass 2 with CI/CD and extent report ended ===========================================

//------------------------------------baseclass with extent report and env------------------------------------------------------------------
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

            baseUrl = System.getProperty("BASE_URL");
            System.out.println(" BASE_URL: " + baseUrl);

        } catch (NullPointerException  e) {
            System.err.println("Could not load config.properties: " + e.getMessage());
            baseUrl = "https://explorer.devdomain123.com/"; // Default fallback URL
            System.out.println("Default URL running");
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
