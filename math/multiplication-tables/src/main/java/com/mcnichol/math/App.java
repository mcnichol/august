package com.mcnichol.math;

public class App {
    public static void main(String[] args) {
        QuestionService questionService = new QuestionService(new MathNumberGeneratorImpl());

        Question question = questionService.getQuestion();
        System.out.println(question.toString());
        System.out.println(question.getSum());
    }


}
