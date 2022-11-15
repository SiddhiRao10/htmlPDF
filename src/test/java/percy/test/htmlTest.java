package percy.test;

import io.percy.selenium.Percy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.sun.net.httpserver.HttpServer;

import static org.testng.Assert.assertNotNull;

public class htmlTest  extends App{
    private static final String TEST_URL = "http://localhost:8000";
    private static WebDriver driver;
    private static Percy percy;
    private static ExecutorService serverExecutor;
    private static HttpServer server;
    @BeforeMethod
    public void startAppAndOpenBrowser() throws IOException {
        // Disable browser logs from being logged to stdout
       FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);
        System.setProperty("webdriver.gecko.driver","/Users/siddhirao/SidProjects/Assignments/percyAssignment1/src/main/resources/driver/geckodriver");

       // Create a threadpool with 1 thread and run our server on it.
        serverExecutor = Executors.newFixedThreadPool(1);
        server = App.startServer(serverExecutor);
        driver = new FirefoxDriver(options);
        percy = new Percy(driver);
       // percyHelper = new PercyHelper(driver);
    }

    @Test
    public void loadsHomePage() {
        driver.get("www.google.com");
        //WebElement element = driver.findElement(By.className("todoapp"));
       // assertNotNull(element);

        // Take a Percy snapshot.
        percy.snapshot("Home Page",Arrays.asList(1440, 1920));
    }
}
