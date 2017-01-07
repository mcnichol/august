package com.mcnichol.math;

class TableService {
    private String tableColor = ConsoleColor.BLUE.getValue();
    private String rangeColor = ConsoleColor.CYAN.getValue();
    private String initColor = ConsoleColor.WHITE.getValue();
    private String rowDivider;
    private int rangeStart;
    private int rangeEnd;

    Table initializeTable(int rangeStart, int rangeEnd) {
        Table table = new Table();

        this.rangeStart = rangeStart;
        this.rangeEnd = rangeEnd;
        this.rowDivider = createRowDivider();
        table.setHeader(createHeader());
        table.setLeftColumnAndBody(createLeftColumnAndBody());
        table.setLastRow(createLastRow());

        return table;
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
}
