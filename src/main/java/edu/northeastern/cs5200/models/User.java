package edu.northeastern.cs5200.models;

import java.sql.Date;

public class User extends Person{
  private int id;
  private Boolean userAgreement;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Boolean getUserAgreement() {
    return userAgreement;
  }

  public void setUserAgreement(boolean userAgreement) {
    this.userAgreement = userAgreement;
  }

  public User(int id, Boolean userAgreement,String firstName, String lastName){
    super(id,firstName,lastName);
    this.id = id;
    this.userAgreement = userAgreement;
  }
  public User(){

  }
  public User(int id, Boolean userAgreement,String firstName, String lastName,String username,String password,String email,Date dob){
    super(id,firstName,lastName,username,password,email,dob);
    this.id = id;
    this.userAgreement = userAgreement;
  }

}
