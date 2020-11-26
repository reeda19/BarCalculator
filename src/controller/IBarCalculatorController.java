package controller;

import java.util.Scanner;
import model.IBarCalculatorModel;

public interface IBarCalculatorController {


  /**
   * Takes in commands to add people, add drinks, and display results
   *
   * @param scanner Readable to read commands from
   * @param model model to use
   */
  public void startCalculator(Scanner scanner, IBarCalculatorModel<?,?> model);


}
