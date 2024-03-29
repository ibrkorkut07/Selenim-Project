package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Day02_FirefoxTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
        // creating firefox driver
        WebDriver driver = new FirefoxDriver();
        // going to the google.com
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        driver.quit();
    }
}
