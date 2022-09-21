package com.example;

import java.util.ArrayList;

public final class App {
    public static void main(String[] args) {
        ArrayList<Dvd> library = LibraryController.OpenLibrary();
        UserInterface.run(library);
        LibraryController.CloseLibrary(library);
    }
}