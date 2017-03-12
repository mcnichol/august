package com.mcnichol.math.table;

import lombok.Value;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Value
public class MathTable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id = 0;
    private int rangeStart;
    private int rangeEnd;
    private String header;
    private String leftColumnAndBody;
    private String lastRow;

    private MathTable(int rangeStart, int rangeEnd, String header, String leftColumnAndBody, String lastRow) {
        this.rangeStart = rangeStart;
        this.rangeEnd = rangeEnd;
        this.header = header;
        this.leftColumnAndBody = leftColumnAndBody;
        this.lastRow = lastRow;
    }

    public static class MathTableBuilder {
        private int id = 0;
        private int rangeStart;
        private int rangeEnd;
        private String header;
        private String leftColumnAndBody;
        private String lastRow;

        public MathTableBuilder rangeStart(int rangeStart) {
            this.rangeStart = rangeStart;

            return this;
        }

        public MathTableBuilder rangeEnd(int rangeEnd) {
            this.rangeEnd = rangeEnd;

            return this;
        }

        public MathTableBuilder header(String header) {
            this.header = header;

            return this;
        }

        public MathTableBuilder leftColumnAndBody(String leftColumnAndBody) {
            this.leftColumnAndBody = leftColumnAndBody;

            return this;
        }

        public MathTableBuilder lastRow(String lastRow) {
            this.lastRow = lastRow;

            return this;
        }

        public MathTable build() {
            return new MathTable(rangeStart, rangeEnd, header, leftColumnAndBody, lastRow);
        }
    }

    @Override
    public String toString() {
        return header + leftColumnAndBody + lastRow;
    }

    public String getInfo() {
        return this.toString() + this.getRangeStart() + this.getRangeEnd();
    }
}
