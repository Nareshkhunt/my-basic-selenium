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

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CalendarSelection {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        baseUrl = "http://www.expedia.com/";

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void test1() throws Exception {
        driver.get(baseUrl);
        // Click flights tab
        driver.findElement(By.id("tab-flight-tab-hp")).click();
        // Find departing field
        WebElement departingField = driver.findElement(By.id("flight-origin-hp-flight"));
        // Click departing field
        departingField.click();
        Thread.sleep(3000);
        // Find the date to be selected
        WebElement dateToSelect = driver.findElement(By.id("flight-departing-hp-flight"));
        // Click the date
        dateToSelect.click();
    }

    @Test
    public void test2() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.id("tab-flight-tab-hp")).click();
        driver.findElement(By.xpath("//input[@id='flight-origin-hp-flight']")).sendKeys("lhr");
        driver.findElement(By.xpath("//div[contains(@class,'multiLineDisplay')]")).click();
        driver.findElement(By.xpath("//input[@id='flight-destination-hp-flight']")).sendKeys("amd");
        driver.findElement(By.xpath("//a[@id='aria-option-0']")).click();
        WebElement departingField = driver.findElement(By.xpath("//input[@id='flight-departing-hp-flight']"));
        departingField.click();
        WebElement calMonth = driver.findElement(By.xpath("//div[@id='flight-departing-wrapper-hp-flight']//div[contains(@class,'datepicker-dropdown')]"));

        List<WebElement> allValidDates = calMonth.findElements(By.cssSelector(".datepicker-cal-date"));
        System.out.println(allValidDates);
        Thread.sleep(3000);

        for (WebElement date : allValidDates) {
            if (date.getText().equals("31")) {
                date.click();
                break;
            }
        }
    }
    //@After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }

}
