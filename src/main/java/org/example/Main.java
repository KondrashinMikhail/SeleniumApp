package org.example;

import org.example.Testing.CreatingTesting;
import org.example.Testing.Initializing;
import org.example.Testing.StatusChangingTesting;
import org.example.Testing.ViewingTesting;

public class Main {
    public static void main(String[] args) {
        new Initializing();
        new ViewingTesting();
        new StatusChangingTesting();
        try {
            new CreatingTesting();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}