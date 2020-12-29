package com.example.wap.model;

import static java.util.Objects.requireNonNull;

import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "drink")
public class Drink {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="drink_id")
  private int drinkId;
  @Column(name="size")
  private int size;
  @Column(name = "name")
  private String name;
  // price is per one drink. Should be calculated beforehand.
  // For example, a drink of vodka is equal to one shot, not one handle, so it would be about 0.50, not 30
  @Column(name = "price")
  private double price;
  @OneToMany(mappedBy = "did")
  private List<BoughtDrink> boughtDrinks;

  public Drink(String name, double price) throws IllegalArgumentException {
    this.name = requireNonNull(name);
    if (price < 0) {
      throw new IllegalArgumentException("Price cannot be negative");
    }
    this.price = price;
  }


  public Drink() {

  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Drink drink = (Drink) o;
    return Objects.equals(name.toLowerCase(), drink.name.toLowerCase());
  }

  @Override
  public int hashCode() {
    return Objects.hash(name.toLowerCase());
  }

  @Override
  public String toString() {
    return name;
  }

  public int getDrinkId() {
    return this.drinkId;
  }

  public void setDrinkId(int drinkId) {
    this.drinkId = drinkId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return this.price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public List<BoughtDrink> getBoughtDrinks() {
    return this.boughtDrinks;
  }

  public void setBoughtDrinks(
      List<BoughtDrink> boughtDrinks) {
    this.boughtDrinks = boughtDrinks;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }
}
