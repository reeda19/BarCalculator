package com.example.wap.controller;

import java.io.IOException;
import com.example.wap.model.IBarCalculatorModel;

public interface IBarCalculatorController {


  /**
   * Takes in commands to add people, add drinks, and display results
   *
   * @param model com.example.wap.model implementation that is being used
   */
  public void startCalculator(IBarCalculatorModel<?,?> model) throws IOException;


}
