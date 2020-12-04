package model;

import java.util.ArrayList;

public interface IBarCalculatorModel<P, D> {


  /**
   * Adds a person to the tab
   *
   * @param personName the name of the given object of type P to be added to tab
   * @throws IllegalArgumentException thrown if the given object is null or if it already exists in
   *                                  the map
   */
  public void addPerson(String personName) throws IllegalArgumentException;


  /**
   * Adds a drink to list of available drinks for a person to consume
   *
   * @param drinkName name of the drink
   * @param amount    amount of the drink, in ml
   * @param price     price of the drink
   * @param beer      true if given drink is soft, false if liquor
   * @throws IllegalArgumentException if the drink already exists in the list
   */
  public void addDrink(String drinkName, int amount, double price, boolean beer)
      throws IllegalArgumentException;

  /**
   * Adds a drink to a specific persons tab
   *
   * @param personName name of the person to add a drink to their tab
   * @param drinkName  name of the drink to be added to the person's tab
   * @throws IllegalArgumentException thrown if the given drink or person are null or if person does
   *                                  not exist in the tab
   */
  public void addDrinkToPerson(String personName, String drinkName);


  /**
   * Returns the ArrayList of people who currently have an open tab at the bar.
   *
   * @return ArrayList of P objects
   */
  public ArrayList<P> getPeople();

  /**
   * Returns the ArrayList of available drinks at the bar.
   *
   * @return ArrayList of D objects
   */
  public ArrayList<D> getDrinks();


}
