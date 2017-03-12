package com.mcnichol.math;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

class QuestionServiceTest {

    @DisplayName("getQuestion")
    @Nested
    class getQuestion {
        @DisplayName("returns an object of question type")
        @Test
        void ofTypeQuestion() {
            QuestionService questionService = new QuestionService();

            assertThat(questionService.getQuestion()).isOfAnyClassIn(Question.class);
        }
    }
}