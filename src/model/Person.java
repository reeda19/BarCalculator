package model;

import java.util.HashMap;
import java.util.Objects;

/**
 * Representation of a person's tab at a bar.
 */
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

  // Computes the total cost of drinks at the end of the night
  public double computeTotal() {
    double total = 0;
    for (Drink s : this.drinks.keySet()) {
      total += this.drinks.get(s) * s.getPrice();
    }
    return total;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Person person = (Person) o;
    return name.toLowerCase().equals(person.name.toLowerCase());
  }

  @Override
  public int hashCode() {
    return Objects.hash(name.toLowerCase());
  }

  @Override
  public String toString() {
    int total = 0;
    for (Drink s : this.drinks.keySet()) {
      total += this.drinks.get(s);
    }
    return this.name + " has had " + total + " drink(s) and owes $" + this.computeTotal();
  }


}
