package SeleniumTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class testSelenium {
    static WebDriver driver;

    @BeforeMethod
    public static void beforeTest(){
        driver= new ChromeDriver();
    }


    @AfterMethod
    public static void afterTest(){
        driver.close();
    }
}
