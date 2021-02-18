package functionTest;

import function.FunctionSinUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class FunctionSinUtilTest extends Assert {
    private HashMap<Double, Double> arrayTestValues = new HashMap<Double, Double>();
    private static final double DELTA = 0.01;

    @Before
    public void setUp() {
        // ключ - x, значение - введенное значение - y

        //проверка нулевого значения
        arrayTestValues.put( 0d, 0d);

        //проверка правой стороны
        arrayTestValues.put(Math.PI / 6, 0.5);
        arrayTestValues.put(Math.PI / 4, Math.sqrt(2) / 2);
        arrayTestValues.put(Math.PI / 3, Math.sqrt(3) / 2);
        arrayTestValues.put(Math.PI / 2, 1d);
        arrayTestValues.put(2*Math.PI / 3, Math.sqrt(3) / 2);
        arrayTestValues.put(3* Math.PI / 4, Math.sqrt(2) / 2);
        arrayTestValues.put(5*Math.PI / 6, 0.5);

        //проверка левой стороны (на четность)
        arrayTestValues.put(-Math.PI / 6, -0.5);
        arrayTestValues.put(-Math.PI / 4, -Math.sqrt(2) / 2);
        arrayTestValues.put(-Math.PI / 3, -Math.sqrt(3) / 2);
        arrayTestValues.put(-Math.PI / 2, -1d);
        arrayTestValues.put(-2*Math.PI / 3, -Math.sqrt(3) / 2);
        arrayTestValues.put(-3* Math.PI / 4, -Math.sqrt(2) / 2);
        arrayTestValues.put(-5*Math.PI / 6, -0.5);

        //проверка граничных значений
        arrayTestValues.put(-Math.PI, 0d);
        arrayTestValues.put(Math.PI, 0d);

        //тестирование NaN, Infinity
        arrayTestValues.put(Double.NaN, Double.NaN);
        arrayTestValues.put(Double.POSITIVE_INFINITY, Double.NaN);
        arrayTestValues.put(Double.NEGATIVE_INFINITY, Double.NaN);

        //тестовые значения вне границы покрытия
        arrayTestValues.put(7*Math.PI / 6, -0.5);
        arrayTestValues.put(-7*Math.PI / 6, 0.5);

    }

    @After
    public void tearDown() {
        arrayTestValues.clear();
    }

    @Test
    public void testSin() {
        double expected, actual;
        for (Map.Entry entry : arrayTestValues.entrySet()) {
            expected = ((Double) entry.getValue()).doubleValue();

            actual = FunctionSinUtil.sin(((Double) entry.getKey()).doubleValue());
            System.out.println("x = " +  ((Double) entry.getKey()).doubleValue() + " actual = " + actual
                    + " expected = " + expected);
            assertEquals(expected, actual, DELTA);
        }
    }
}

