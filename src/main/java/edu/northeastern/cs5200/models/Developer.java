package edu.northeastern.cs5200.models;

import java.sql.Date;
import java.util.List;

public class Developer extends Person {

  private int id;
  private String developerKey;

  public Developer(){
    super();

  }
  public Developer(int id, String developerKey, String firstName, String lastName) {
    super(id,firstName, lastName);
    this.id = id;
    this.developerKey = developerKey;
  }

  public Developer(int id,String developerKey,String firstName, String lastName, String userName,String password,String email,
      Date dob, List<Address> address, List<Phone> phone){
    super(id,firstName,lastName,userName,password,email,dob,address,phone);
    this.id = id;
    this.developerKey = developerKey;
  }

  public Developer(int id,String developerKey,String firstName, String lastName, String userName,String password,String email,
      Date dob){
    super(id,firstName,lastName,userName,password,email,dob);
    this.id = id;
    this.developerKey = developerKey;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setDeveloperKey(String developer_key) {
    this.developerKey = developer_key;
  }

  public int getId() {
    return this.id;
  }

  public String getDeveloperKey() {
    return developerKey;
  }
}
