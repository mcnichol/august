package com.mcnichol.math;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Question {

    private Integer augend;
    private Integer addend;
    private Character operand;
    private Integer sum;

    private Question(Integer augend, Integer addend, Character operand, Integer sum) {
        this.augend = augend;
        this.addend = addend;
        this.operand = operand;
        this.sum = sum;
    }

    public static class QuestionBuilder {

        private Integer augend;
        private Integer addend;
        private Character operand;

        public QuestionBuilder augend(Integer augend) {
            this.augend = augend;
            return this;
        }

        public QuestionBuilder addend(Integer addend) {
            this.addend = addend;
            return this;
        }

        public QuestionBuilder operand(Character operand) {
            this.operand = operand;
            return this;
        }

        public Question build() throws UnableToComputeSumException {
            ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
            ScriptEngine jsEngine = scriptEngineManager.getEngineByName("js");

            Integer sum = null;
            try {
                sum = (Integer) jsEngine.eval(String.valueOf(augend) + String.valueOf(operand) + String.valueOf(addend));
            } catch (ScriptException e) {
                throw new UnableToComputeSumException(e.toString());
            }

            return new Question(augend, addend, operand, sum);
        }

    }

    public Integer getAugend() {
        return augend;
    }

    public Integer getAddend() {
        return addend;
    }

    public Character getOperand() {
        return operand;
    }

    public Integer getSum() {
        return sum;
    }

    @Override
    public String toString() {
        return augend + " " + operand + " " + addend + " =";
    }
}