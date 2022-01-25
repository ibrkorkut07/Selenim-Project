package com.myfirstproject;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day04_CheckBox {
    //(//input[@type='checkbox'])[1]
    //(//input[@type='checkbox'])[2]

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
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    @Test
    public void checkBoxTest() throws InterruptedException {
        // Firstly we can locate the elements
        WebElement firstCheckBox = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement secondCheckbox = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

        // Verify the first checkbox is not selected
        Assert.assertTrue(!firstCheckBox.isSelected());
        Thread.sleep(5000);
        //  Assert.assertFalse(firstCheckBox.isSelected());

        // VErify the second checkbox is selected
        Assert.assertTrue(secondCheckbox.isSelected());
        Thread.sleep(5000);

        // How to click a checkbox
        firstCheckBox.click();  // checked
        Assert.assertTrue(firstCheckBox.isSelected());
        Thread.sleep(5000);
        secondCheckbox.click();    // unchecked
        Assert.assertTrue(!secondCheckbox.isSelected());

        // I want to click the checKboxes if they aren't checked

        if (!firstCheckBox.isSelected()){
            firstCheckBox.click();
        }
        if (!secondCheckbox.isSelected()){
            secondCheckbox.click();
        }
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}