import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {
  @Test
  public void testSum() {
    Calculator calculator = new Calculator();
    int total = calculator.sum("1+2+3");
    assertEquals(6, total);
  }
  
  @Test
  public void testSub() {
    Calculator calculator = new Calculator();
    int total = calculator.sub("1-2-3");
    assertEquals(6, total);
  }
}
