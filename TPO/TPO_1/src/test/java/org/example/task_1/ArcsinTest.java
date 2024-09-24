package org.example.task_1;

import com.google.common.math.BigIntegerMath;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;



import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArcsinTest {

    @Test
    public void testArcsinIndependently() {
        Arcsin arcsinMock = Mockito.mock(Arcsin.class);
        for (int i = 0; i < 50; i++){
            Mockito.when(arcsinMock.factorial(i)).thenReturn(BigIntegerMath.factorial(i).intValue());
        }
        Arcsin arcsin = new Arcsin();

        assertEquals(Math.asin(0.5), arcsin.toPowerSeries(0.5), 0.01);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    public void factorialTest(int number){
        Arcsin arcsin = new Arcsin();
        assertEquals(BigIntegerMath.factorial(number).intValue(), arcsin.factorial(number));
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.9, 0.8, 0.7, 0.5, 0.3, 0.2, 0.1, 0, -0.2, -0.4, -0.5, -0.7, -0.8, -0.9})
    void testArcsinValues(double number) {
        Arcsin arcsin = new Arcsin();
        assertEquals(Math.asin(number), arcsin.toPowerSeries(number), 0.01);
    }

    @ParameterizedTest
    @ValueSource(doubles = {1.0, -1.0})
    void testArcsinBorders(double number) {
        Arcsin arcsin = new Arcsin();
        assertEquals(Double.NaN, arcsin.toPowerSeries(number));
    }

    @ParameterizedTest
    @ValueSource(doubles = {2.0, -2.0})
    void testArcsinOutOfBorders(double number) {
        Arcsin arcsin = new Arcsin();
        assertEquals(Double.NaN, arcsin.toPowerSeries(number));
    }
}
