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


    public static WebDriver get(){

        if(driverPool.get() == null){


            String browserType = System.getProperty("browser", ConfigurationReader.getProperty("browser"));

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

                case "headless-chrome":
                    ChromeOptions chOpts = new ChromeOptions();
                    chOpts.addArguments("--headless=new"); //
                    driverPool.set(new ChromeDriver(chOpts));
                    break;

                case "headless-firefox":
                    FirefoxOptions ffOpts = new FirefoxOptions();
                    ffOpts.addArguments("-headless");
                    driverPool.set(new FirefoxDriver(ffOpts));
                    break;

                default:
                    driverPool.set(new ChromeDriver());
            }
            driverPool.get().manage().window().maximize();
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

