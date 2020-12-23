package model;


import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Representation of a person's tab at a bar.
 */

@Entity
@Table(name = "person")
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int personId;

  @Column(name = "name")
  private String name;

  @Column(name = "total")
  private double total;


  @OneToMany(mappedBy = "did")
  private HashMap<BoughtDrink, Integer> boughtDrinks;

  public Person() {

  }

  public int getLibrarianId() {
    return personId;
  }

  public void setLibrarianId(int librarianId) {
    this.personId = librarianId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getTotal() {
    return total;
  }

  public HashMap<BoughtDrink, Integer> getBoughtDrinks() {
    return boughtDrinks;
  }


  //not needed? --> addDrink will most likely be used instead
/*  public void setBoughtDrinks(
      List<BoughtDrinks> boughtDrinks) {
    this.boughtDrinks = boughtDrinks;
  }*/


  //old hashmap. need to replace all instances with new model
  //HashMap<Drink, Integer> drinks;

  public Person(String name) {
    this.name = name;
    this.total=0;
    this.boughtDrinks = new HashMap<>();
  }

  // adds one to drink of given type
  public void addDrink(BoughtDrink type) {
    this.boughtDrinks.put(type, this.boughtDrinks.getOrDefault(type, 0) + 1);
    computeTotal();
  }

  // Computes the total cost of drinks at the end of the night
  public void computeTotal() {
    double total = 0.0;
    for (BoughtDrink s : this.boughtDrinks.keySet()) {
      total += this.boughtDrinks.get(s) * s.getDrink().getPrice();
    }
    this.total=total;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Person person = (Person) o;
    return name.toLowerCase().equals(person.name.toLowerCase());
  }

  @Override
  public int hashCode() {
    return Objects.hash(name.toLowerCase());
  }

  @Override
  public String toString() {
    int total = 0;
    for (BoughtDrink s : this.boughtDrinks.keySet()) {
      total += this.boughtDrinks.get(s);
    }
    return this.name + " has had " + total + " drink(s) and owes $" + String.format("%.2f%n",this.getTotal());
  }
}

