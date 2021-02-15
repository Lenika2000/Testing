package FunctionTest;

import function.FunctionSinUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class FunctionSinUtilTest extends Assert {
    private HashMap<Double, Double> arrayTestValues = new HashMap<Double, Double>();
    private HashMap<Double, Double> arrayWrongTestValues = new HashMap<Double, Double>();
    private static final double DELTA = 0.001;

    @Before
    public void setUp() {
        // ключ - результат из тестового сценария, значение - введенное значение

        //проверка нулевого значения
        arrayTestValues.put((double) 0, (double) 0);

        //проверка правой стороны
        arrayTestValues.put(0.5, Math.PI / 6);
        arrayTestValues.put(Math.sqrt(2) / 2, Math.PI / 4);
        arrayTestValues.put(Math.sqrt(3) / 2, Math.PI / 3);
        arrayTestValues.put((double) 1, Math.PI / 2);
        arrayTestValues.put(Math.sqrt(3) / 2, 2*Math.PI / 3);
        arrayTestValues.put(Math.sqrt(2) / 2, 3* Math.PI / 4);
        arrayTestValues.put(0.5, 5*Math.PI / 6);

        //проверка левой стороны (на четность)
        arrayTestValues.put(-0.5, -Math.PI / 6);
        arrayTestValues.put(-Math.sqrt(2) / 2, -Math.PI / 4);
        arrayTestValues.put(-Math.sqrt(3) / 2, -Math.PI / 3);
        arrayTestValues.put((double) -1, -Math.PI / 2);
        arrayTestValues.put(-Math.sqrt(3) / 2, -2*Math.PI / 3);
        arrayTestValues.put(-Math.sqrt(2) / 2, -3* Math.PI / 4);
        arrayTestValues.put(-0.5, -5*Math.PI / 6);

        //проверка граничных значений
        arrayTestValues.put((double) 0, -Math.PI);
        arrayTestValues.put((double) 0, Math.PI);

        //тестирование NaN, Infinity
        arrayTestValues.put(Double.NaN, Double.NaN);
        arrayTestValues.put(Double.NaN, Double.POSITIVE_INFINITY);

        //тестовые значения вне границы покрытия
        arrayWrongTestValues.put(- Math.sqrt(3) / 2, 4 * Math.PI / 3);
        arrayWrongTestValues.put(Math.sqrt(3) / 2, -4 * Math.PI / 3);
    }

    @After
    public void tearDown() {
        arrayTestValues.clear();
    }

    @Test
    public void testSin() {
        double expected, actual;
        for (Map.Entry entry : arrayTestValues.entrySet()) {
            expected = ((Double) entry.getKey()).doubleValue();

            actual = FunctionSinUtil.sin(((Double) entry.getValue()).doubleValue());
            assertEquals(expected, actual, DELTA);
        }
        for (Map.Entry entry : arrayWrongTestValues.entrySet()) {
            expected = ((Double) entry.getKey()).doubleValue();
            actual = FunctionSinUtil.sin(((Double) entry.getValue()).doubleValue());
            assertNotEquals(expected, actual, DELTA);
        }
    }
}
