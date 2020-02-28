package edu.northeastern.cs5200.models;

public class Phone {
private String phone;
private boolean isprimary;
private String oldNumber;

  public String getOldNumber() {
    return oldNumber;
  }

  public void setOldNumber(String oldNumber) {
    this.oldNumber = oldNumber;
  }

  public boolean isChanged() {
    return changed;
  }

  public void setChanged(boolean changed) {
    this.changed = changed;
  }

  private boolean changed;
private int id;

public Phone(){

}
public Phone(String phone, boolean isprimary){
  this.phone = phone;
  this.isprimary = isprimary;
  changed = false;
  oldNumber = null;
}
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone1) {

  oldNumber = this.phone;
  changed = true;
  this.phone = phone1;
  }

  public boolean getIsprimary() {
    return isprimary;
  }

  public void setIsprimary(boolean isprimary) {
    this.isprimary = isprimary;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
