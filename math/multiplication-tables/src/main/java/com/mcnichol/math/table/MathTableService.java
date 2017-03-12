package com.mcnichol.math.table;

import com.mcnichol.math.ConsoleColor;

class MathTableService {
    private String tableColor = ConsoleColor.BLUE.getValue();
    private String rangeColor = ConsoleColor.CYAN.getValue();
    private String initColor = ConsoleColor.WHITE.getValue();
    private String rowDivider;
    private int rangeStart;
    private int rangeEnd;

    MathTable initializeMathTable(int rangeStart, int rangeEnd) {
        MathTable mathTable = new MathTable.MathTableBuilder()
                .rangeStart(rangeStart)
                .rangeEnd(rangeEnd)
                .header(createHeader())
                .leftColumnAndBody(createLeftColumnAndBody())
                .lastRow(createLastRow()).build();

        this.rangeStart = rangeStart;
        this.rangeEnd = rangeEnd;
        this.rowDivider = createRowDivider();

        return mathTable;
    }

    private String createRowDivider() {
        StringBuilder sb = new StringBuilder();

        sb.append(tableColor).append("--|");
        for (int i = rangeStart; i <= rangeEnd - rangeStart; i++) {
            sb.append("---|");
        }

        return sb.toString();
    }

    private String createHeader() {

        StringBuilder sb = new StringBuilder();

        sb.append(tableColor).append("  |");
        for (int i = rangeStart; i <= rangeEnd; i++) {
            sb.append(rangeColor).append(" ").append(i).append(" ").append(tableColor).append("|");
        }
        sb.append("\n");

        return sb.toString();
    }

    private String createLeftColumnAndBody() {
        StringBuilder sb = new StringBuilder();

        for (int i = rangeStart; i <= rangeEnd; i++) {
            sb.append(rowDivider).append("\n");
            sb.append(rangeColor).append(String.valueOf(i)).append(tableColor).append(" |");

            for (int j = rangeStart; j <= rangeEnd; j++) {
                sb.append(initColor).append(" █ ").append(tableColor).append("|");

            }
            sb.append("\n");

        }
        return sb.toString();
    }

    private String createLastRow() {
        return rowDivider;
    }


    public MathTable createMathTable() {
        return new MathTable.MathTableBuilder().build();
    }
}
