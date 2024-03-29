package com.basic.operations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SwitchWindow {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        baseUrl = "https://courses.letskodeit.com/practice";

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void test() throws InterruptedException {

//
//		WebElement searchBox = driver.findElement(By.id("search-courses"));
//		searchBox.sendKeys("python");
        // Get the handle
        String parentHandle = driver.getWindowHandle();
        System.out.println("Parent Handle: " + parentHandle);

        // Find Open Window button
        WebElement openWindow = driver.findElement(By.id("openwindow"));
        openWindow.click();

        // Get all handles
        Set<String> handles = driver.getWindowHandles();
        System.out.println(handles.size());


        // Switching between handles
        for (String handle: handles) {
            System.out.println(handle);
        }

        // Switch back to the parent window
    }

   // @After
    public void tearDown() throws Exception {
    }
}
