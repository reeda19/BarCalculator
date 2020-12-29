package com.example.wap.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Used to map Many to Many relationship between Person and Drink. One person can have many drinks,
 * while one drink can be bought by many people.
 */
@Entity
@Table(name = "persons_drinks")
@IdClass(BoughtDrinkId.class)
public class BoughtDrink {
  BoughtDrink(int pid, int did){
    this.pid=pid;
    this.did=did;
  }

  public BoughtDrink() {

  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BoughtDrink that = (BoughtDrink) o;
    return did == that.did &&
        pid == that.pid;
  }

  @Override
  public int hashCode() {
    return Objects.hash(did, pid);
  }

  // Drink ID
  @Id
  @Column(name = "did")
  private int did;

  // Person ID
  @Id
  @Column(name = "pid")
  private int pid;

  @Column(name = "amountBought")
  private int amountBought;


  @ManyToOne
  @JsonIgnore
  @PrimaryKeyJoinColumn(name = "did", referencedColumnName = "drink")
  private Drink drink;

  @Id
  @ManyToOne
  @JsonIgnore
  @PrimaryKeyJoinColumn(name = "pid", referencedColumnName = "person")
  private Person person;

  public int getDrinkId() {
    return did;
  }

  public void setDrinkId(int drinkId) {
    this.did = drinkId;
  }

  public int getPersonId() {
    return pid;
  }

  public void setPersonId(int personId) {
    this.pid = personId;
  }

  public Drink getDrink() {
    return drink;
  }

  public void setDrink(Drink drink) {
    this.drink = drink;
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  public int getAmountBought() {
    return amountBought;
  }

  public void increaseAmount() {
    this.amountBought = amountBought+1;
  }
}
