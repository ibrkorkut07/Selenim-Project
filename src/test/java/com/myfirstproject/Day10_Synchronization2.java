package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class Day10_Synchronization2 {
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void isEnabled(){
        //    Go to https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //    Click enable Button
        WebElement enableButton =  driver.findElement(By.xpath("(//button[@type='button'])[2]"));
        enableButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement enabledMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));

        //    And verify the message is equal to “It's enabled!”
        Assert.assertEquals("It's enabled!",enabledMessage.getText());

        //    And verify the textbox is enabled (I can type in the box)
        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertTrue(textBox.isEnabled());

        //    And click on Disable button
        WebElement disableButton = driver.findElement(By.xpath("(//button[@type='button'])[2]"));
        disableButton.click();

        //    And verify the message is equal to “It's disabled!”
        WebElement disabledText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertEquals("It's disabled!",disabledText.getText());
        //    And verify the textbox is disabled (I cannot type in the box)
        Assert.assertFalse(textBox.isEnabled());
    }
}