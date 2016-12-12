package com.mcnichol.math;

public class App {


    public static void main(String[] args) {
        TableService tableService = new TableService(0, 9);

        tableService.initializeTable();
    }
}
