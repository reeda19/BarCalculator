import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collections;
import model.BarCalculatorModel;
import model.Drink;
import model.Person;
import org.junit.Test;

public class BarCalculatorModelTest {


  @Test
  public void testModelValid() {
    BarCalculatorModel model = new BarCalculatorModel();
    model.addPerson("alex");
    ArrayList<Person> people = new ArrayList<>(Collections.singletonList(new Person("alex")));
    assertEquals(people, model.getPeople());
    model.addDrink("bud", 12, 12, true);
    ArrayList<Drink> drinks = new ArrayList<>(Collections.singletonList(new Drink("bud", 1)));
    assertEquals(drinks, model.getDrinks());
    model.addDrinkToPerson("alex", "bud");
    model.toString();
    assertEquals("alex has had 1 drink(s) and owes $1.00", model.toString());
  }


  @Test
  public void testModelInvalid() {
    BarCalculatorModel model = new BarCalculatorModel();
    model.addPerson("alex");
    try {
      model.addPerson(null);
      fail();
    } catch (IllegalArgumentException e) {
      //exception successfully thrown
    }
    try {
      model.addPerson("");
      fail();
    } catch (IllegalArgumentException e) {
      //exception successfully thrown
    }
    model.addDrink("bud", 12, 12, true);
    try {
      model.addDrink("bud", -12, 12, true);
      fail();
    } catch (IllegalArgumentException e) {
      //exception successfully thrown
    }
    try {
      model.addDrink("bud", 12, -12, true);
      fail();
    } catch (IllegalArgumentException e) {
      //exception successfully thrown
    }
    try {
      model.addDrink("bud", 12, 12, true);
      fail();
    } catch (IllegalArgumentException e) {
      //exception successfully thrown
    }
    try {
      model.addDrinkToPerson("bud", "bud");
      fail();
    } catch (IllegalArgumentException e) {
      //exception successfully thrown
    }
    try {
      model.addDrinkToPerson("alex", "alex");
      fail();
    } catch (IllegalArgumentException e) {
      //exception successfully thrown
    }
    try {
      model.addDrinkToPerson("", "");
      fail();
    } catch (IllegalArgumentException e) {
      //exception successfully thrown
    }
    try {
      model.addDrinkToPerson(null, null);
      fail();
    } catch (IllegalArgumentException e) {
      //exception successfully thrown
    }
  }
}
