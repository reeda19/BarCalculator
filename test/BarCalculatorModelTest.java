import static org.junit.Assert.assertEquals;

import model.BarCalculatorModel;
import org.junit.Test;

public class BarCalculatorModelTest {


  @Test
  public void testTotal(){
    BarCalculatorModel model = new BarCalculatorModel();
    model.addPerson("alex");
    model.addDrink("bud", 12, 12, true);
    model.addDrinkToPerson("alex", "bud");
    model.toString();
    assertEquals("alex has had 1 drink(s) and owes $1.0",model.toString());
  }
}
