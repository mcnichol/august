package com.mcnichol.math;

public class QuestionService {

    private MathNumberGenerator mng;

    public QuestionService(MathNumberGenerator mng) {
        this.mng = mng;
    }

    public Question getQuestion() {
        return new Question.QuestionBuilder()
                .augend(mng.getRandomNumber())
                .operand('+')
                .addend(mng.getRandomNumber())
                .build();
    }
}
