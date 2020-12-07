package view;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JSpinner.ListEditor;
import javax.swing.JTextArea;
import model.BarCalculatorModel;
import model.Drink;
import model.IBarCalculatorModel;
import model.Person;

public class BarCalculatorVisualView implements IBarCalculatorView {

  IBarCalculatorModel<Person, Drink> model;
  JFrame frame;
  JPanel globe;
  JPanel top;
  JPanel bottom;
  JPanel middle;

  public BarCalculatorVisualView(IBarCalculatorModel<Person, Drink> model){
    this.model = model;
    setFrame();
    try {
      render();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args){
    BarCalculatorModel mod = new BarCalculatorModel();
    mod.addPerson("Alex");
    mod.addPerson("Shreya");
    mod.addPerson("Georgy");
    mod.addPerson("Evan");
    mod.addPerson("Jason");
    mod.addPerson("Justin");
    mod.addPerson("Anusha");
    mod.addDrink("New Amsterdam", 1750, 20.00, false);
    mod.addDrink("Budweiser", 18, 19.00, true);
    new BarCalculatorVisualView(mod);
  }

  private void setFrame(){
    frame = new JFrame("Bar Calculator");
    globe = new JPanel();
    top = new JPanel();
    middle = new JPanel();
    bottom = new JPanel();
    globe.setLayout(new BoxLayout(globe, BoxLayout.Y_AXIS));
    top.setAlignmentY(Component.CENTER_ALIGNMENT);
    middle.setAlignmentY(Component.CENTER_ALIGNMENT);
    bottom.setAlignmentY(Component.CENTER_ALIGNMENT);
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    frame.setExtendedState(JFrame.EXIT_ON_CLOSE);
  }

  @Override
  public void render() throws IOException {
    JLabel title = new JLabel("Welcome to Bar Calculator.\nWhat can I get you?");
    title.setSize(650, 300);
    title.setAlignmentY(Component.CENTER_ALIGNMENT);
    globe.add(title);

    JLabel promptPerson = new JLabel("Who are you?:");
    List<Person> peopleList = model.getPeople();
    JComboBox<String> people = new JComboBox<>();
    for(Person p: peopleList){
      people.addItem(p.getName());
    }
    JLabel promptDrink = new JLabel("What are you having?:");
    List<Drink> drinkList = model.getDrinks();
    JComboBox<String> drinks = new JComboBox<>();
    for(Drink d: drinkList){
      drinks.addItem(d.toString());
    }
    JButton order = new JButton("Order");
    top.add(promptPerson);
    top.add(people);
    top.add(promptDrink);
    top.add(drinks);
    top.add(order);

    JLabel promptNew = new JLabel("Dont see something? Add it!");
    JButton addPerson = new JButton("Add a person");
    addPerson.addActionListener(e -> addPersonScreen());
    JButton addDrink = new JButton("Add a drink");

    JTextArea tab = new JTextArea(this.model.toString());
    middle.add(tab);

    addDrink.addActionListener(e -> addDrinkScreen());
    bottom.add(promptNew);
    bottom.add(addPerson);
    bottom.add(addDrink);

    globe.add(top);
    globe.add(middle);
    globe.add(bottom);
    frame.add(globe);
    frame.setVisible(true);
  }

  public void addPersonScreen(){

  }

  public void addDrinkScreen(){

  }
}
