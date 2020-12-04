package model;

import static java.util.Objects.requireNonNull;

import java.util.Objects;

public class Drink {


  String name;

  // price is per one drink. Should be calculated beforehand. 
  // For example, a drink of vodka is equal to one shot, not one handle, so it would be about 0.50, not 30
  double price;


  public Drink(String name, double price) throws IllegalArgumentException {
    this.name = requireNonNull(name);
    if (price < 0) {
      throw new IllegalArgumentException("Price cannot be negative");
    }
    this.price = price;
  }

  public double getPrice() {
    return this.price;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Drink drink = (Drink) o;
    return Objects.equals(name.toLowerCase(), drink.name.toLowerCase());
  }

  @Override
  public int hashCode() {
    return Objects.hash(name.toLowerCase());
  }
}
