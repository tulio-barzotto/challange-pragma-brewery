package br.tuliobar.utils;

import java.util.Random;

public final class TemperatureGenerator {

    /**
     * Gera um inteiro randomicamente entre -10 e 10
     */
    public static int getRandomTemperature() {
        Random r = new Random();
        return r.nextInt((10 - (-10)) + 1) + (-10);
    }
}
