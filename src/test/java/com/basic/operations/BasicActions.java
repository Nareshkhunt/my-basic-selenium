package com.basic.operations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;


public class BasicActions {
    WebDriver driver;
    String baseUrl;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        baseUrl = "https://www.letskodeit.com/practice";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void test() {
        driver.get(baseUrl);

        //driver.findElement(By.xpath("//div[@id='navbar']//a[@href='/sign_in']")).click();
        driver.findElement(By.linkText("Login")).click();
        System.out.println("Clicked on login");
        driver.findElement(By.id("user_email")).sendKeys("test@email.com");
        System.out.println("Sending keys to username field");
        driver.findElement(By.id("user_password")).sendKeys("test");
        System.out.println("Sending keys to password field");
        driver.findElement(By.id("user_email")).clear();
        System.out.println("Clearing the username field");
    }

    @After
    public void tearDown() throws Exception {
         driver.quit();
    }
}
