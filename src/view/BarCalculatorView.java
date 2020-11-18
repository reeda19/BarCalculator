package view;

import static java.util.Objects.requireNonNull;

import java.io.IOException;
import java.util.ArrayList;
import model.IBarCalculatorModel;

public class BarCalculatorView<P, D> implements IBarCalculatorView {

  IBarCalculatorModel<P, D> model;
  Appendable ap;
  public BarCalculatorView(IBarCalculatorModel<P, D> model, Appendable ap) throws NullPointerException{
    this.model=requireNonNull(model);
    this.ap=ap;
  }


  @Override
  public void render() throws IOException {
    this.ap.append(this.toString());
  }

  @Override
  public String toString(){
    ArrayList<P> people = this.model.getPeople();
    StringBuilder ret = new StringBuilder();
    for(P p : people){
      ret.append(p.toString()).append("\n");
    }
    return ret.toString();
  }
}
