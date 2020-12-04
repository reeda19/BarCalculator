package model;

import java.util.ArrayList;

public class BarCalculatorModel implements IBarCalculatorModel<Person, Drink> {

  private final double SHOT_ML = 44.3603;
  private final ArrayList<Person> people;
  private final ArrayList<Drink> drinks;

  public BarCalculatorModel() {
    this.people = new ArrayList<>();
    this.drinks = new ArrayList<>();

  }


  @Override
  public void addPerson(String personName) throws IllegalArgumentException {
    Person person = new Person(personName);
    if (people.contains(person)) {
      throw new IllegalArgumentException("Person already exists");
    }
    people.add(person);
  }

  /**
   * Adds a drink to list of available drinks for a person to consume
   *
   * @param drinkName name of the drink
   * @param amount    amount of the drink, in ml
   * @param price     price of the drink
   * @throws IllegalArgumentException if the drink already exists in the list
   */
  @Override
  public void addDrink(String drinkName, int amount, double price, boolean beer)
      throws IllegalArgumentException {
    Drink drink;
    if (beer) {
      drink = new Drink(drinkName, price / amount);
    } else {
      drink = new Drink(drinkName, price / (amount / SHOT_ML));
    }
    if (this.drinks.contains(drink)) {
      throw new IllegalArgumentException("Drink already exists");
    }
    this.drinks.add(drink);
  }

  @Override
  public void addDrinkToPerson(String drinkName, String personName)
      throws IllegalArgumentException {
    Person person = new Person(personName);
    Drink drink = new Drink(drinkName, 0);
    ArrayList<Person> people = this.getPeople();
    if (this.getPeople().contains(person) && this.getDrinks().contains(drink)) {
      people.get(people.indexOf(person)).addDrink(drink);
    } else {
      throw new IllegalArgumentException("Person or does not exist");
    }
  }


  public ArrayList<Person> getPeople() {
    return new ArrayList<>(this.people);
  }

  public ArrayList<Drink> getDrinks() {
    return new ArrayList<>(this.drinks);
  }

  @Override
  public String toString() {
    StringBuilder totals = new StringBuilder();
    for(Person p : this.getPeople()){
      totals.append(p.toString()).append("\n");
    }
    if(totals.length()>0) {
      return totals.toString();
    }
    else{
      return "No tabs have been opened yet";
    }

  }

}
