package com.myfirstproject;
import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import java.nio.file.Files;
import java.nio.file.Paths;
public class Day08_FileDownloadTest extends TestBase {
    @Test
    public void downloadTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.linkText("IMG_1354.jpg")).click();
//        Verify if the download is successful
//        Waiting for th file to be downloaded completely
        Thread.sleep(2000);
//        path of the downloaded file
        String filePath = System.getProperty("user.home")+"/Downloads/IMG_1354.jpg";

//        Verification
        boolean isDownloaded = Files.exists(Paths.get(filePath));
        Assert.assertTrue(isDownloaded);
    }
}