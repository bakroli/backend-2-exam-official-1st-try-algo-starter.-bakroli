package hu.nive.ujratervezes.multavgsignum;

import java.util.Arrays;

public class Calculation {

    public int[] multBySignum(int[] numbers, int n) {
        if (numbers == null || n < 1) {
            throw new IllegalArgumentException();
        }
        if (numbers.length == 0) {
            return new int[0];
        }
        int[] result = new int[numbers.length];
        int average = averageCalculator(numbers);
        for (int i = 0; i < numbers.length; i++) {
            if ((i + 1) % n == 0) {
                result[i] = numbers[i] * functionSignum(average, numbers[i]);
            } else {
                result[i] = numbers[i];
            }
        }
        return result;
    }

    private int functionSignum(int average, int number) {
        int num = number - average;
        if (num < 0) {
            return -1;
        } else if (num > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    private int averageCalculator(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum / numbers.length;
    }

}
