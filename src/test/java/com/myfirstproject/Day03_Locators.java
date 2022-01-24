package com.myfirstproject;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Day03_Locators {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://a.testaddressbook.com/sign_in");
    }

    @Test
    public void Locators () throws InterruptedException {
        // locating the email input
        driver.findElement(By.id("session_email")).sendKeys("testtechproed@gmail.com");
        // locating the password and typing the password
        driver.findElement(By.id("session_password")).sendKeys("Test1234!");
        // locating the sign-in button and clicking on it
        driver.findElement(By.name("commit")).click();
        Thread.sleep(3000);
        // Then verify that the expected user id testtechproed@gmail.com (USE getText() method to get the text from the page)
        // 1. locate the element
        //   2. getText will return the text as String
        // 3. assert
        WebElement userId = driver.findElement(By.className("navbar-text"));
        System.out.println(userId);
        String actualUserIdText = userId.getText();
        System.out.println(actualUserIdText);
        String expectedUserId = "testtechproed@gmail.com";
        Assert.assertEquals("ID Test Fails", expectedUserId, actualUserIdText);
        // Verify the Addresses and Sign Out texts are displayed
        // 1/ addresses
        WebElement addressesElement = driver.findElement(By.linkText("Addresses"));
        // isDisplayed() returns true if the element is displayed, returns false if not.
        Assert.assertTrue(addressesElement.isDisplayed());
        // sign out
        WebElement signOutElement = driver.findElement(By.linkText("Sign Out"));
        Assert.assertTrue(signOutElement.isDisplayed());
        // Find the number of total link on the page
        // "a" tag is used to create links
        List<WebElement> allLinks = driver.findElements(By.tagName("a")); // returns all links on the page
        System.out.println("Total number of link : " + allLinks.size());
        // Sign out from the page
        driver.findElement(By.partialLinkText("Sign out")).click();
        // NOTE: make sure do the assertion for verifying the sign-out is successful
        boolean isSignedOut = driver.getCurrentUrl().equals("http://a.testaddressbook.com/sign_in");
        Assert.assertTrue(isSignedOut);
        Thread.sleep(3000);
    }

    @After
    public void tearDown () {
        driver.quit();
    }
}