package com.basic.operations.keypress;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class KeyPressDemo2 {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() throws Exception {
       // System.setProperty("webdriver.gecko.driver", "/Users/atomar/Documents/workspace_personal/libs/geckodriver");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        baseUrl = "https://letskodeit.teachable.com/p/practice";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testKeyPress() throws Exception {
        driver.get(baseUrl);
       // driver.findElement(By.id("openwindow")).sendKeys(Keys.CONTROL + "a");
        Thread.sleep(2000);
        //driver.findElement(By.id("openwindow")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        //Thread.sleep(2000);
        String selectAll = Keys.chord(Keys.CONTROL, "a");
        driver.findElement(By.id("openwindow")).sendKeys(selectAll);
        Thread.sleep(4000);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
