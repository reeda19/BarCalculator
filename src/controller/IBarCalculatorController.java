package controller;

import model.IBarCalculatorModel;

public interface IBarCalculatorController {


  /**
   * Takes in commands to add people, add drinks, and display results
   *
   * @param model model implementation that is being used
   */
  public void startCalculator(IBarCalculatorModel<?,?> model);


}
