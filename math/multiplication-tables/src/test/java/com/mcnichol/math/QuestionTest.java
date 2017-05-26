package com.mcnichol.math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitPlatform.class)
class QuestionTest {

    private Question question;

    @BeforeEach
    void setUp() {
        question = new Question.QuestionBuilder()
                .augend(1)
                .operand('+')
                .addend(2)
                .build();
    }

    @DisplayName("question builder correctly computes the sum")
    @Test
    void questionIsFormattedProperly() {

        assertThat(question.toString()).isEqualTo("1 + 2 =");

    }

    @DisplayName("question builder correctly computes the sum")
    @Test
    void sumIsCorrectForQuestion() {

        assertThat(question.getSum()).isEqualTo(question.getAugend() + question.getAddend());

    }

}