package controller;

import java.util.Scanner;
import model.IBarCalculatorModel;

public class BarCalculatorController implements IBarCalculatorController {

  /*
  Command format:

  Drink [drinkName] [drinkPrice] [drinkSize (ml)]

  Person [personName]

  AddDrink [personName] [drinkName]


   */





  /**
   * Takes in commands to add people, add drinks, and display results
   *
   * @param scanner Readable to read commands from
   */
  @Override
  public void startCalculator(Scanner scanner, IBarCalculatorModel model) {

  while(scanner.hasNext()){
    String next = scanner.next().strip().toLowerCase();
    switch(next){
      case "drink":
        parseDrink(scanner);
        break;
      case "person":
        parsePerson(scanner);
        break;
      case "addDrink":
        parseAddDrink(scanner);
        break;
      default:
        throw new IllegalArgumentException("Illegal commands to scanner");
    }
  }




  }

  private void parseAddDrink(Scanner scanner) {
  }

  private void parsePerson(Scanner scanner) {
  }

  private void parseDrink(Scanner scanner) {
  }
}
