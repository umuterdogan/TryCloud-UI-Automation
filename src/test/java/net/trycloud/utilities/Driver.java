package net.trycloud.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    private Driver(){}


    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    public static WebDriver get() {

        if (driverPool.get() == null) {

            String browserType = System.getProperty("browser", ConfigurationReader.getProperty("browser"));

            // Force Chrome on Jenkins agents no matter what env vars say
            if (System.getenv("JENKINS_HOME") != null) {
                browserType = "headless-chrome";
            }

            // Quick visibility in Jenkins console
            System.out.println("BROWSER=" + browserType);

            switch (browserType) {
                case "chrome":
                    driverPool.set(new ChromeDriver());
                    break;

                case "firefox":
                    driverPool.set(new FirefoxDriver());
                    break;

                case "edge":
                    driverPool.set(new EdgeDriver());
                    break;

                case "safari":
                    driverPool.set(new SafariDriver());
                    break;

                case "headless-chrome": {
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments(
                            "--headless=new",
                            "--window-size=1920,1080",
                            "--disable-gpu",
                            "--no-sandbox",
                            "--disable-dev-shm-usage",
                            "--ignore-certificate-errors"
                    );
                    options.setAcceptInsecureCerts(true);
                    driverPool.set(new ChromeDriver(options));
                    break;
                }

                case "headless-firefox": {
                    FirefoxOptions options = new FirefoxOptions();
                    options.addArguments("-headless");
                    options.addArguments("--width=1920", "--height=1080");
                    options.setAcceptInsecureCerts(true);
                    driverPool.set(new FirefoxDriver(options));
                    break;
                }

                default:
                    driverPool.set(new ChromeDriver());
            }

            // Don’t call maximize in headless; it’s ignored and can fail on some drivers
            if (!browserType.contains("headless")) {
                driverPool.get().manage().window().maximize();
            }
            driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        return driverPool.get();
    }


    public static void closeDriver(){
        if (driverPool.get()!=null){

            driverPool.get().quit();

            driverPool.remove();
        }
    }

}

