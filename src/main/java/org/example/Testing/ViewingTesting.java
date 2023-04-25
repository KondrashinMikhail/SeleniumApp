package org.example.Testing;

import org.example.Utils.SafariDriverSingleton;
import org.example.Utils.Utils;

public class ViewingTesting {

    public ViewingTesting() {
        System.out.println("--------------------");
        System.out.println("--TESTING VIEWINGS--");
        System.out.println("--------------------");
        System.out.println(viewingOffices());
        System.out.println(viewingMails());
        System.out.println(viewingStoredMailsInOffices());
        System.out.println(viewingMailHistories());
    }
    private String viewingOffices() {
        SafariDriverSingleton.getDriver().get(Utils.href_office);
        return "SUCCESSFULLY VIEWED OFFICES";
    }

    private String viewingMails() {
        SafariDriverSingleton.getDriver().get(Utils.href_office);
        return "SUCCESSFULLY VIEWED MAILS";
    }

    private String viewingStoredMailsInOffices() {
        for (String element : Utils.storedMailsInOffices)
            SafariDriverSingleton.getDriver().get(element);
        return "SUCCESSFULLY VIEWED ALL STORED MAILS IN OFFICES";
    }

    private String viewingMailHistories() {
        for (String element : Utils.mailHistories)
            SafariDriverSingleton.getDriver().get(element);
        return "SUCCESSFULLY VIEWED ALL MAILS HISTORIES";
    }
}
