package com.mcnichol.math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class QuestionServiceTest {

    public class MockMathNumberGenerator implements MathNumberGenerator{
        int[] pseudoRandomNumbers = {1, 2};
        int pointer;

        MockMathNumberGenerator(){
            int pointer = 0;
        }

        @Override
        public int getRandomNumber() {
            return pseudoRandomNumbers[pointer++];
        }
    }

    @DisplayName("getQuestion")
    @Nested
    class GetQuestion {
        private QuestionService questionService;

        @BeforeEach
        void setUp() {
            MathNumberGenerator mockMathNumberGenerator = new MockMathNumberGenerator();
            questionService = new QuestionService(mockMathNumberGenerator);
        }

        @DisplayName("returns an object of question type")
        @Test
        void ofTypeQuestion() {
            assertThat(questionService.getQuestion()).isOfAnyClassIn(Question.class);
        }

        @DisplayName("Returns a question object with populated question fields")
        @Test
        void questionIsPopulated() {

            Question actualQuestion = questionService.getQuestion();

            assertAll(
                    () -> assertThat(actualQuestion.getAugend()).isBetween(0, 1000),
                    () -> assertThat(actualQuestion.getAddend()).isBetween(0, 1000),
                    () -> assertThat(actualQuestion.getOperand()).isEqualTo('+')
            );
        }

    }
}