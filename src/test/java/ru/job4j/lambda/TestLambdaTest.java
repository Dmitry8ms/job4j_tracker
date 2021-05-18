package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TestLambdaTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = TestLambda.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSquareFunctionThenSquareResults() {
        List<Double> result = TestLambda.diapason(5, 8, x -> x * x + 1);
        List<Double> expected = Arrays.asList(26.0, 37.0, 50.0);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenExponentialResults() {
        List<Double> result = TestLambda.diapason(5, 8, x -> Math.pow(2, x) + 1);
        List<Double> expected = Arrays.asList(33.0, 65.0, 129.0);
        assertThat(result, is(expected));
    }
}