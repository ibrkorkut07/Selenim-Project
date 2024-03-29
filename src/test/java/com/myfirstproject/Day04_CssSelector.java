package com.myfirstproject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day04_CssSelector {

    WebDriver driver;

    @Before
    public void setUp(){

        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe"); // MAC // For windows add .exe

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // WE can add a wait here
        // WE can add an implicit wait dynamic wait and if all elements are located before timeout it stops waiting
        // This form is with Selenium 4
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        // Before this with Selenium 3
        //  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.carettahotel.com/Account/Logon");
    }

    @Test
    public void cssTest(){
        // Login test with css selector locator
        //<input class="form-control required" data-val="true" data-val-required="This field is required" id="UserName"
        // name="UserName" placeholder="Username" type="text" value="">
        // driver.findElement(By.cssSelector("input[id='UserName']"))
        WebElement userName= driver.findElement(By.cssSelector("#UserName"));
        userName.sendKeys("Manager");
        WebElement passWord = driver.findElement(By.cssSelector("#Password"));
        passWord.sendKeys("Manage1!");
        driver.findElement(By.cssSelector("input[id='btnSubmit']")).click();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}