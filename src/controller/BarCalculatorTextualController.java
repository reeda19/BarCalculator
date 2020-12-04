package controller;

import java.io.IOException;
import java.util.Scanner;
import model.IBarCalculatorModel;
import view.BarCalculatorTextualView;
import view.IBarCalculatorView;

import static java.util.Objects.requireNonNull;

public class BarCalculatorTextualController implements IBarCalculatorController {

  /*
  Command format:

  Drink [drinkName] [drinkPrice] [drinkSize (ml)] [beer? (boolean)] -> Creates new drink

  Person [personName] -> Opens new tab

  AddDrink [personName] [drinkName] -> Adds existing drink to existing tab

  Total -> outputs totals of all tabs
   */

Readable rd;
Appendable ap;

IBarCalculatorModel<?,?> model;

public BarCalculatorTextualController(Readable rd, Appendable ap){
  this.rd=requireNonNull(rd);
  this.ap=requireNonNull(ap);
}


  /**
   * Takes in commands to add people, add drinks, and display results
   *
   * @param model model implementation that is being used
   */
  @Override
  public void startCalculator(IBarCalculatorModel<?,?> model) throws IOException {
    this.model=model;
    Scanner scanner = new Scanner(this.rd);
    IBarCalculatorView view = new BarCalculatorTextualView<>(this.model, this.ap);
  while(scanner.hasNext()){
    String next = scanner.next().strip().toLowerCase();
    switch(next.strip().toLowerCase()){
      case "drink":
        parseAddDrink(scanner);
        break;
      case "person":
        parsePerson(scanner);
        break;
      case "adddrink":
        parseDrink(scanner);
        break;
      case "total":
        this.ap.append(this.model.toString());
        break;
      default:
        throw new IllegalArgumentException("Illegal commands to scanner");

    }
   // view.render();

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
                  this.ap.append("drink added: ").append(drinkName);
                } catch (IllegalArgumentException e) {
                  throw new IllegalArgumentException("Illegal input to beer for addDrink");
                } catch (IOException e) {
                  e.printStackTrace();
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

  private void parsePerson(Scanner scanner) throws IOException {
    if(scanner.hasNext()){
      String personName = scanner.next();
      this.model.addPerson(personName);
      this.ap.append("person added: ").append(personName);
    }
    else{
      throw new IllegalArgumentException("Invalid input to Person");
    }
  }

  private void parseDrink(Scanner scanner) throws IOException {
    if(scanner.hasNext()){
      String tempPerson = scanner.next();
      if(scanner.hasNext()){
        String tempDrink = scanner.next();
         this.model.addDrinkToPerson(tempDrink,tempPerson);
        this.ap.append("drink ").append(tempDrink).append(" added to ").append(tempPerson).append("'s tab");
        return;
      }
    }
    throw new IllegalArgumentException("Not enough arguments to addDrink");
  }
}
