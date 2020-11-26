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
   * Adds a drink to a specific persons tab
   *
   * @param person the person to add a drink to their tab
   * @param drink  the drink to be added to the person's tab
   * @throws IllegalArgumentException thrown if the given drink or person are null or if person does
   *                                  not exist in the tab
   */
  public void addDrinkToPerson(D drink, P person);


  /**
   * Returns the ArrayList of people who currently have an open tab at the bar.
   *
   * @return ArrayList of P objects
   */
  public ArrayList<P> getPeople();


}
