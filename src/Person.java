import java.util.HashMap;

public class Person {

  HashMap<Drink, Integer> drinks;
  String name;

  public Person(String name) {
    this.name = name;
    this.drinks = new HashMap<>();
  }


  // adds one to drink of given type
  public void addDrink(Drink type) {
    this.drinks.put(type, this.drinks.getOrDefault(type, 0) + 1);
  }


  public double computeTotal() {
    double total = 0;
    for (Drink s : this.drinks.keySet()) {
      total += this.drinks.get(s) * s.getPrice();
    }
    return total;
  }


}
