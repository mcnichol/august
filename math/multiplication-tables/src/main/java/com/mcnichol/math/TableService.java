package com.mcnichol.math;

public class TableService {

    private String tableColor = ConsoleColor.BLUE.getValue();
    private String valueColor = ConsoleColor.CYAN.getValue();
    private String initColor = ConsoleColor.WHITE.getValue();
    private int rangeStart;
    private int rangeEnd;
    private String dividingRow;

    TableService(int rangeStart, int rangeEnd) {
        this.rangeStart = rangeStart;
        this.rangeEnd = rangeEnd;

        this.dividingRow = createDividingRow(rangeStart, rangeEnd);
    }

    void initializeTable() {
        System.out.println();
        printTableHead();
        printTableLeftColumnAndBody();
        printTableLastRow();
    }

    private String createDividingRow(int tableStart, int tableEnd) {
        StringBuilder sb = new StringBuilder();

        sb.append(tableColor).append("--|");
        for (int i = tableStart; i <= tableEnd - tableStart; i++) {
            sb.append("---|");
        }

        return sb.toString();
    }

    private void printTableHead() {
        System.out.print(tableColor + "  |");
        for (int i = rangeStart; i <= rangeEnd; i++) {
            System.out.print(valueColor + " " + i + " " + tableColor + "|");
        }
        System.out.println();
    }

    private void printTableLeftColumnAndBody() {
        for (int i = rangeStart; i <= rangeEnd; i++) {
            System.out.println(dividingRow);
            System.out.print(valueColor + String.valueOf(i) + tableColor + " |");

            for (int j = rangeStart; j <= rangeEnd; j++) {
                System.out.print(initColor + " █ " + tableColor + "|");

            }
            System.out.println();
        }
    }

    private void printTableLastRow() {
        System.out.println(dividingRow);
    }
}
