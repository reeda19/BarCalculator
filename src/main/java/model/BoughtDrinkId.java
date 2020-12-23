package model;


import java.io.Serializable;

public class BoughtDrinkId implements Serializable {

  private int did;
  private int pid;

  public BoughtDrinkId(int did, int pid) {
    this.did = did;
    this.pid = pid;
  }

  public BoughtDrinkId() {}


}