package org.example.Testing;

import org.example.Utils.SafariDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class CreatingTesting {
    WebDriver driver = SafariDriverSingleton.getDriver();
    private static WebElement buttonAdd;
    public CreatingTesting() throws InterruptedException {
        System.out.println("--------------------");
        System.out.println("--TESTING CREATING---");
        System.out.println("--------------------");
        System.out.println(mailCreatingTesting("CARD", "111111", "st.Green", "Mikhail", "432010"));
        TimeUnit.SECONDS.sleep(1);
        System.out.println(mailCreatingTesting("CARD", "111111", "st.Green", "Mikhail", "111111"));
        TimeUnit.SECONDS.sleep(1);
        System.out.println(mailCreatingTesting("", "", "", "", ""));
        TimeUnit.SECONDS.sleep(1);
        System.out.println(mailCreatingTesting("CARD", "432", "st.Green", "Mikhail", "010"));
        TimeUnit.SECONDS.sleep(1);
        System.out.println(mailCreatingTesting("CARD", "11ab11", "st.Green", "Mikhail", "432010"));
        TimeUnit.SECONDS.sleep(1);
        System.out.println(mailCreatingTesting("CARD", "11ab", "st.Green", "Mikhail", "432010"));
        TimeUnit.SECONDS.sleep(1);
        System.out.println(mailCreatingTesting("CARD", "11ab", "st.Green", "Mikhail", "43201a"));

        TimeUnit.SECONDS.sleep(1);

        System.out.println(officeCreatingTesting("432000", "PostOffice #1", "st.Green"));
        TimeUnit.SECONDS.sleep(1);
        System.out.println(officeCreatingTesting("432", "PostOffice #1", "st.Green"));
        TimeUnit.SECONDS.sleep(1);
        System.out.println(officeCreatingTesting("432abc", "PostOffice #1", "st.Green"));
        TimeUnit.SECONDS.sleep(1);
        System.out.println(officeCreatingTesting("", "", ""));
    }

    private String mailCreatingTesting(String type,
                                      String recipientIndex,
                                      String recipientAddress,
                                      String recipientName,
                                      String sourceIndex) {

        driver.get("http://localhost:80/mail/create");
        WebElement typeInput = driver.findElement(By.id("type"));
        WebElement recipientIndexInput = driver.findElement(By.id("recipientIndex"));
        WebElement recipientAddressInput = driver.findElement(By.id("recipientAddress"));
        WebElement recipientNameInput = driver.findElement(By.id("recipientName"));
        WebElement sourceIndexInput = driver.findElement(By.id("sourceIndex"));

        typeInput.sendKeys(type);
        recipientIndexInput.sendKeys(recipientIndex);
        recipientAddressInput.sendKeys(recipientAddress);
        recipientNameInput.sendKeys(recipientName);
        sourceIndexInput.sendKeys(sourceIndex);

        driver.findElements(By.className("main-button")).forEach(it -> {
            if (it.getText() != null && it.getText().contains("Добавить")) {
                buttonAdd = it;
            }
        });

        buttonAdd.click();
        return String.format("MAIL (%s, %s, %s, %s, %s)", type, recipientIndex, recipientAddress, recipientName, sourceIndex);
    }

    private String officeCreatingTesting(String index,
                                        String name,
                                        String address) {

        driver.get("http://localhost:80/office/edit");
        WebElement indexInput = driver.findElement(By.id("index"));
        WebElement nameInput = driver.findElement(By.id("name"));
        WebElement addressInput = driver.findElement(By.id("address"));

        indexInput.sendKeys(index);
        nameInput.sendKeys(name);
        addressInput.sendKeys(address);

        driver.findElements(By.className("main-button")).forEach(it -> {
            if (it.getText() != null && it.getText().contains("Добавить")) {
                buttonAdd = it;
            }
        });

        buttonAdd.click();
        return String.format("OFFICE (%s, %s, %s)", index, name, address);
    }
}
