package com.mcnichol.math;

import java.util.Random;

public class MathNumberGeneratorImpl implements MathNumberGenerator {
    @Override
    public int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(1000);
    }

}
