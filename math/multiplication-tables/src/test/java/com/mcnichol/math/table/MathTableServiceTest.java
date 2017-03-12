package com.mcnichol.math.table;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MathTableServiceTest {

    @Test
    void generatesDefaultMultiplicationTable() {
        MathTableService mathTableService = new MathTableService();
        MathTable expected = new MathTable.MathTableBuilder()
                .rangeStart(1)
                .rangeEnd(10).build();

        MathTable mathTable = mathTableService.createMathTable();

        assertThat(mathTable.getInfo()).isEqualTo(expected.getInfo());
    }
}