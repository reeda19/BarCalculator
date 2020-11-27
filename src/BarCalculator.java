import controller.BarCalculatorController;
import java.io.InputStreamReader;
import model.BarCalculatorModel;

public class BarCalculator {

  public static void main(String[] args){
    BarCalculatorModel model = new BarCalculatorModel();


    StringBuilder ap = new StringBuilder();

    BarCalculatorController controller = new BarCalculatorController(new InputStreamReader(System.in), ap);


    controller.startCalculator(model);
  }

}
