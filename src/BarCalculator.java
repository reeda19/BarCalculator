import controller.BarCalculatorTextualController;
import java.io.IOException;
import java.io.InputStreamReader;
import model.BarCalculatorModel;

public class BarCalculator {

  public static void main(String[] args) throws IOException {
    BarCalculatorModel model = new BarCalculatorModel();



    BarCalculatorTextualController controller = new BarCalculatorTextualController(new InputStreamReader(System.in), System.out);


    controller.startCalculator(model);
  }

}
