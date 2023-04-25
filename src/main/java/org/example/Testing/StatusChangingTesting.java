package org.example.Testing;

import org.example.Utils.SafariDriverSingleton;
import org.example.Utils.Utils;

public class StatusChangingTesting {

    public StatusChangingTesting() {
        System.out.println("---------------------");
        System.out.println("TESTING STATUS UPDATE");
        System.out.println("---------------------");
        System.out.println(changingMailStatuses());
    }
    public String changingMailStatuses() {
        for (String element : Utils.mailStatuses)
            SafariDriverSingleton.getDriver().get(element);
        return "SUCCESSFULLY CHANGED STATUSES";
    }
}
