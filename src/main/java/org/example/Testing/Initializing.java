package org.example.Testing;

import org.example.Utils.SafariDriverSingleton;
import org.example.Utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class Initializing {
    WebDriver driver = SafariDriverSingleton.getDriver();
    private String result;

    public Initializing() {
        System.out.println("--------------------");
        System.out.println("----INITIALIZING----");
        System.out.println("--------------------");
        System.out.println(initializeMailsHref());
        System.out.println(initializeOfficesHref());
        System.out.println(initializeStoredMailsInOffices());
        System.out.println(initializeMailHistories());
        System.out.println(initializeMailStatuses());
    }

    public String initializeMailsHref() {
        driver.get(Utils.server_api);
        driver.findElements(By.className("nav-link")).forEach(it -> {
            if (it.getAttribute("href") != null && it.getAttribute("href").contains("mail")) {
                Utils.href_mail = it.getAttribute("href");
                result = "LOADED MAIL VIEWING LINK";
            }
        });
        return result;
    }

    public String initializeOfficesHref() {
        driver.get(Utils.server_api);
        driver.findElements(By.className("nav-link")).forEach(it -> {
            if (it.getAttribute("href") != null && it.getAttribute("href").contains("office")) {
                Utils.href_office = it.getAttribute("href");
                result = "LOADED OFFICE VIEWING LINK";
            }
        });
        return result;
    }

    public String initializeStoredMailsInOffices() {
        driver.get(Utils.href_office);
        Utils.storedMailsInOffices = new ArrayList<>();
        driver.findElements(By.tagName("form")).forEach(it -> {
            if (it.getAttribute("action") != null && it.getAttribute("action").contains("mails"))
                    Utils.storedMailsInOffices.add(it.getAttribute("action"));
        });
        result = "LOADED STORED MAILS IN OFFICES LINKS";
        return result;
    }

    public String initializeMailHistories() {
        driver.get(Utils.href_mail);
        Utils.mailHistories = new ArrayList<>();
        driver.findElements(By.tagName("form")).forEach(it -> {
            if (it.getAttribute("action") != null && it.getAttribute("action").contains("history"))
                Utils.mailHistories.add(it.getAttribute("action"));
        });
        result = "LOADED MAIL HISTORIES";
        return result;
    }

    public String initializeMailStatuses() {
        driver.get(Utils.href_mail);
        Utils.mailStatuses = new ArrayList<>();
        driver.findElements(By.tagName("form")).forEach(it -> {
            if (it.getAttribute("action") != null && it.getAttribute("action").contains("nextStatus"))
                Utils.mailStatuses.add(it.getAttribute("action"));
        });
        result = "LOADED MAIL STATUSES";
        return result;
    }
}
