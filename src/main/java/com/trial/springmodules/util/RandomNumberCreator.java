package com.trial.springmodules.util;

import java.util.Random;

public final class RandomNumberCreator {
    public static Integer createNumberInRange(Integer firstRange, Integer lastRange) {
        Random random = new Random();
        return random.nextInt(lastRange - firstRange) + firstRange;
    }

}
