package com.mcnichol.math;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class Table {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    int rangeStart;
    int rangeEnd;
    String topRow;
}
