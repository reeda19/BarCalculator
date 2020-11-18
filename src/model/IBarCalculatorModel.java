package model;

public interface IBarCalculatorModel<P, D> {


  /**
   * Adds a person to the tab
   *
   * @param person the given object of type P to be added to tab
   * @throws IllegalArgumentException thrown if the given object is null or if it already exists in
   *                                  the map
   */
  public void addPerson(P person) throws IllegalArgumentException;


  /**
   * Adds a drink to a specific persons tab
   *
   * @param person the person to add a drink to their tab
   * @param drink  the drink to be added to the person's tab
   * @throws IllegalArgumentException thrown if the given drink or person are null or if person does
   *                                  not exist in the tab
   */
  public void addDrinkToPerson(D drink, P person);



}
