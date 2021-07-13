import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTester {
    private Calculator calculator;

    @Before
    public void init() {
        calculator = new Calculator();
    }

    @Test
    public void testSum() {
        Assert.assertEquals(20, calculator.Sum(13, 7));
    }

    @Test
    public void testMultiplication() {
        Assert.assertEquals(24, calculator.Multiplication(12, 2));
    }

    @Test
    public void testSubtraction() {
        Assert.assertEquals(64, calculator.Subtraction(88, 24));
    }

    @Test
    public void testDivision() {
        Assert.assertEquals(8, calculator.Division(56, 7), 0);
    }

    @After
    public void cleanUp() {
        calculator = null;
    }
}
