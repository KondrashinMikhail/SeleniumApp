package org.example.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class SafariDriverSingleton {
    private static WebDriver driver;

    private SafariDriverSingleton() {}

    public static WebDriver getDriver() {
        if (driver == null)
            driver = new SafariDriver();
        return driver;
    }
}
