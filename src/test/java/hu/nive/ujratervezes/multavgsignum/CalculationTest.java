package hu.nive.ujratervezes.multavgsignum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
| `numbers`             | `n`  | Eredmény                            |
| :-------------------- | :--: | :---------------------------------- |
| `[-2, -1, 0, 1, 2]`   | `2`  | `[-2, 0, 0, 0, 2]`                  |
| `[3, 1, 5, 3, 4]`     | `1`  | `[9, 3, 15, 9, 12]`                   |
| `[2, 12]`             | `2`  | `[2, 84]`                           |
| `[]`                  | `1`  | `[]`                                |
| `null`                | `1`  | `IllegalArgumentException`          |
| `[2, 12]`             | `0`  | `IllegalArgumentException`          |
| `[2, 12]`             | `-1` | `IllegalArgumentException`          |
*/

class CalculationTest {

    @Test
    void testCalculation_validInput() {
        Assertions.assertArrayEquals(new int[]{-2, 1, 0, 1, 2}, new Calculation().multBySignum(new int[]{-2, -1, 0, 1, 2}, 2));
    }

    @Test
    void testCalculation_validInput1() {
        Assertions.assertArrayEquals(new int[]{0, -1, 5, 0, 4}, new Calculation().multBySignum(new int[]{3, 1, 5, 3, 4}, 1));
    }

    @Test
    void testCalculation_validInput2() {
        Assertions.assertArrayEquals(new int[]{-2, 12}, new Calculation().multBySignum(new int[]{2, 12}, 1));
    }

    @Test
    void testCalculation_emptyArray() {
        Assertions.assertArrayEquals(new int[]{}, new Calculation().multBySignum(new int[]{}, 1));
    }

    @Test
    void testCalculation_throwsIllegalArgumentExceptionForNullParameter() {
        Calculation calculation = new Calculation();
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculation.multBySignum(null, 1));
    }

    @Test
    void testCalculation_throwsIllegalArgumentExceptionForZero() {
        Calculation calculation = new Calculation();
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculation.multBySignum(new int[]{2, 12}, 0));
    }

    @Test
    void testCalculation_throwsIllegalArgumentExceptionForNegative() {
        Calculation calculation = new Calculation();
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculation.multBySignum(new int[]{2, 12}, -1));
    }
}