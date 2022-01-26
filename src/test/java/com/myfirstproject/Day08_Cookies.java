package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import java.util.Set;

/*
Class: Cookies
Method: handleCookies
-Go to amazon  and automate the tasks:
1. Find the total number of cookies
2. Print all the cookies
3. Get the cookies by their name
4. Add new cookie
5. Delete cookie by name
6. Delete all cookies
 */
public class Day08_Cookies extends TestBase {

    @Test
    public void handleCookies(){
        // Go to amazon website and print all the cookies
        driver.get("https://www.amazon.com");

        //1. Find the cookies size and print all cookies to  the console
        Set<Cookie> allCookies = driver.manage().getCookies();
        int numberOfCookies = allCookies.size(); // size = 8
        System.out.println("numberOfCookies = " + numberOfCookies);

        for (Cookie eachCookie:allCookies) {
            System.out.println("eachCookie = " + eachCookie);
            System.out.println("eachCookie.getName() = " + eachCookie.getName());
            System.out.println("eachCookie.getValue() = " + eachCookie.getValue());
        }

        System.out.println("driver.manage().getCookieNamed(\"i18n-prefs\") = " + driver.manage().getCookieNamed("i18n-prefs"));

        // Adding a new cookie
        // 1. Create a cookie object

        Cookie cookie = new Cookie("My_Favorite","Starbucks_Cookie");
        driver.manage().addCookie(cookie);

        int newSize = driver.manage().getCookies().size();  // 9
        System.out.println(newSize);

        driver.manage().deleteCookie(cookie);
        driver.manage().deleteCookieNamed("skin");
        int newSize_2 = driver.manage().getCookies().size();
        System.out.println("newSize_2 = " + newSize_2);   // 8

        // Deleting all cookies

        driver.manage().deleteAllCookies();
        int lastSize = driver.manage().getCookies().size();
        System.out.println("lastSize = " + lastSize);
    }
}