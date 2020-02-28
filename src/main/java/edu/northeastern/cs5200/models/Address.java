package edu.northeastern.cs5200.models;

public class Address {

  private String street1;
  private String street2;
  private String city;
  private String state;
  private int zip;
  private boolean isprimary;
  private int id;
  private boolean changed;
  private String oldstreet1;
  private String oldstreet2;
  private String oldcity;
  private String oldstate;
  private int oldzip;
  private boolean oldisprimary;

  public boolean isChanged() {
    return changed;
  }

  public void setChanged(boolean changed) {
    this.changed = changed;
  }

  public String getOldstreet1() {
    return oldstreet1;
  }

  public void setOldstreet1(String oldstreet1) {
    this.oldstreet1 = oldstreet1;
  }

  public String getOldstreet2() {
    return oldstreet2;
  }

  public void setOldstreet2(String oldstreet2) {
    this.oldstreet2 = oldstreet2;
  }

  public String getOldcity() {
    return oldcity;
  }

  public void setOldcity(String oldcity) {
    this.oldcity = oldcity;
  }

  public String getOldstate() {
    return oldstate;
  }

  public void setOldstate(String oldstate) {
    this.oldstate = oldstate;
  }

  public int getOldzip() {
    return oldzip;
  }

  public void setOldzip(int oldzip) {
    this.oldzip = oldzip;
  }

  public boolean getOldisprimary() {
    return oldisprimary;
  }

  public void setOldisprimary(boolean oldisprimary) {
    this.oldisprimary = oldisprimary;
  }


  public Address() {

  }

  public Address(String street1, String street2, String city, String state, int zip,
      boolean isprimary) {
    this.street1 = street1;
    this.street2 = street2;
    this.city = city;
    this.state = state;
    this.zip = zip;
    this.isprimary = isprimary;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getStreet1() {
    return street1;
  }

  public void setStreet1(String street1) {
    changed = true;
    oldstreet1 = this.street1;
    this.street1 = street1;
  }

  public String getStreet2() {
    return street2;
  }

  public void setStreet2(String street2) {
    changed = true;
    oldstreet2 = this.street2;
    this.street2 = street2;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {

    changed = true;
    oldcity = this.city;
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {

    changed = true;
    oldstate = this.state;
    this.state = state;
  }

  public int getZip() {
    return zip;
  }

  public void setZip(int zip) {
    changed = true;
    oldzip = this.zip;
    this.zip = zip;
  }

  public boolean getIsprimary() {
    return isprimary;
  }

  public void setIsprimary(boolean isprimary) {
    changed = true;
    oldisprimary = this.isprimary;
    this.isprimary = isprimary;
  }
}
