package com.basic.operations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SwitchFrame {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        baseUrl = "https://www.letskodeit.com/practice";


        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void test() throws InterruptedException {
        Thread.sleep(6000);
        // Switch to frame by Id
        driver.switchTo().frame("courses-iframe");
        // Switch to frame by name
        //driver.switchTo().frame("iframe-name");
        // Switch to frame by numbers
//        driver.switchTo().frame(0);
        Thread.sleep(3000);

        WebElement searchBox = driver.findElement(By.id("search"));
//        searchBox.click();
        searchBox.sendKeys("python");
//        searchBox.click();
        searchBox.sendKeys(Keys.ENTER);

//        driver.switchTo().defaultContent();
//        Thread.sleep(6000);
//        driver.findElement(By.id("name")).sendKeys("Test Successful");
   }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(10000);
        driver.quit();
    }
}
