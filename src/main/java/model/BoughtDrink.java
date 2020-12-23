package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "persons_drinks")
@IdClass(BoughtDrinkId.class)
public class BoughtDrink {

  
  
  // Drink ID
  @Id
  @Column(name = "did")
  private int did;

  // Person ID
  @Id
  @Column(name = "pid")
  private int pid;


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
}
