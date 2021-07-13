import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Calculator {

    private static final Logger log = LogManager.getLogger(Logger.class);

    public int Sum(int A, int B) {
        log.info("Addition {} and {}", A, B);
        System.out.println("Res addition = " + (A + B));
        return (A + B);
    }

    public int Subtraction(int A, int B) {
        log.info("Subtraction {} from {}", B, A);
        System.out.println("Res subtraction = " + (A - B));
        return (A - B);
    }

    public int Multiplication(int A, int B) {
        log.info("Multiplication {} by {}", A, B);
        System.out.println("Res multiplication = " + (A * B));
        return (A * B);
    }

    public int Division(int A, int B) {
        log.info("Division {} by {}", A, B);
        if (B == 0) {
            log.warn("Division by ZERO!!!");
            log.fatal("Division by ZERO!!!");
            log.error("Division by ZERO!!!");
            throw new ArithmeticException();
        } else {
            System.out.println("Res division = " + (double) (A / B));
            return (A / B);
        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        calculator.Sum(7, 9);
        calculator.Subtraction(8, 4);
        calculator.Multiplication(3, 2);
        calculator.Division(8, 2);
        calculator.Division(3, 0);
    }
}
