package com.example.wap.model;


import java.util.ArrayList;
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
  @Column(name="person_id")
  private int personId;

  @Column(name = "name")
  private String name;

  @Column(name = "total")
  private double total;


  @OneToMany(mappedBy = "did")
  private List<BoughtDrink> boughtDrinks;

  public Person() {

  }

  public Person(String name) {
    this.name = name;
    this.total = 0;
    this.boughtDrinks = new ArrayList<>();
  }

  public int getPersonId() {
    return personId;
  }

  public void setPersonId(int personId) {
    this.personId = personId;
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

  //not needed? --> addDrink will most likely be used instead
/*  public void setBoughtDrinks(
      List<BoughtDrinks> boughtDrinks) {
    this.boughtDrinks = boughtDrinks;
  }*/

  public List<BoughtDrink> getBoughtDrinks() {
    return boughtDrinks;
  }

  // adds one to drink of given type
  public void addDrink(Drink drink) {
    BoughtDrink type = new BoughtDrink(this.personId, drink.getDrinkId());
    if (this.boughtDrinks.contains(type)) {
      this.boughtDrinks.get(boughtDrinks.indexOf(type)).increaseAmount();
    } else {
      this.boughtDrinks.add(type);
    }
    computeTotal();
  }

  // Computes the total cost of drinks at the end of the night
  public void computeTotal() {
    double total = 0.0;
    for (BoughtDrink s : this.boughtDrinks) {
      total += s.getAmountBought() * s.getDrink().getPrice();
    }
    this.total = total;
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
    for (BoughtDrink s : this.boughtDrinks) {
      total += s.getAmountBought();
    }
    return this.name + " has had " + total + " drink(s) and owes $" + String
        .format("%.2f%n", this.getTotal());
  }
}

