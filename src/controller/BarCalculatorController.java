package controller;

import java.util.Scanner;
import model.Drink;
import model.IBarCalculatorModel;
import model.Person;

public class BarCalculatorController implements IBarCalculatorController {

  /*
  Command format:

  Drink [drinkName] [drinkPrice] [drinkSize (ml)] [beer? (boolean)]

  Person [personName]

  AddDrink [personName] [drinkName]
   */



IBarCalculatorModel<?,?> model;

  /**
   * Takes in commands to add people, add drinks, and display results
   *
   * @param scanner Readable to read commands from
   */
  @Override
  public void startCalculator(Scanner scanner, IBarCalculatorModel<?,?> model) {
    this.model=model;

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
    if(scanner.hasNext()){
      String drinkName = scanner.next();
      int drinkAmount = 0;
      if(scanner.hasNext()){
        try{
          drinkAmount = Integer.parseInt(scanner.next());
          double drinkPrice = 0.0;
          if(scanner.hasNext()){
            try{
              drinkPrice = Double.parseDouble(scanner.next());
              if(scanner.hasNext()){
                try{
                  boolean beer = Boolean.parseBoolean(scanner.next());
                  this.model.addDrink(drinkName,drinkAmount,drinkPrice, beer);
                } catch (IllegalArgumentException e) {
                  throw new IllegalArgumentException("Illegal input to beer for addDrink");
                }
              }
            } catch (NumberFormatException e) {
              throw new IllegalArgumentException("Illegal input to price for addDrink");
            }
          }
        } catch (NumberFormatException e) {
          throw new IllegalArgumentException("Illegal input to amount for addDrink");
        }

      }else{
        throw new IllegalArgumentException("not enough input to addDrink");
      }

    }
  }

  private void parsePerson(Scanner scanner) {
    if(scanner.hasNext()){
      this.model.addPerson(scanner.next().toString());
    }
    else{
      throw new IllegalArgumentException("Invalid input to Person");
    }
  }

  private void parseDrink(Scanner scanner) {
    if(scanner.hasNext()){
      String tempPerson = scanner.next();
      if(scanner.hasNext()){
        String tempDrink = scanner.next();
         this.model.addDrinkToPerson(tempDrink,tempPerson);
         return;
      }
    }
    throw new IllegalArgumentException("Not enough arguments to addDrink");
  }
}
