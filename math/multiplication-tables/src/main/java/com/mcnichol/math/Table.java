package com.mcnichol.math;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class Table {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int rangeStart;
    private int rangeEnd;
    private String header;
    private String leftColumnAndBody;
    private String lastRow;

    @Override
    public String toString() {
        return header + leftColumnAndBody + lastRow;
    }
}
