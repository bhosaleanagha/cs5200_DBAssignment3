package edu.northeastern.cs5200.models;

import java.sql.Date;
import java.util.List;

public class Person {
  private int id;
  private String firstName;
  private String lastName;
  private String userName;
  private String password;
  private String email;
  private Date dob;
  private List<Phone> phones;
  private List<Address> address;

  public List<Phone> getPhones() {
    return phones;
  }

  public void setPhones(List<Phone> phones) {
    this.phones = phones;
  }

  public List<Address> getAddress() {
    return address;
  }

  public void setAddress(List<Address> address) {
    this.address = address;
  }

  public Person(){

  }

  public Person(int id,String firstName, String lastName) {
    this.id = id;
    this.firstName=firstName;
    this.lastName=lastName;
  }

  public Person(int id, String firstName, String lastName, String userName, String password, String email, Date dob) {
    this.id=id;
    this.firstName=firstName;
    this.lastName=lastName;
    this.userName=userName;
    this.password=password;
    this.email=email;
    this.dob=dob;
  }

  public Person(int id,String firstName, String lastName, String userName, String password, String email, Date dob,List<Address> address,List<Phone> phones) {
    this.id = id;
    this.firstName=firstName;
    this.lastName=lastName;
    this.userName=userName;
    this.password=password;
    this.email=email;
    this.dob=dob;
    this.address = address;
    this.phones = phones;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getDob() {
    return dob;
  }

  public void setDob(Date dob) {
    this.dob = dob;
  }

}
