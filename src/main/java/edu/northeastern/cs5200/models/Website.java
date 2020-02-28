package edu.northeastern.cs5200.models;

import java.sql.Date;
import java.util.List;

public class Website {
private int id;
private String name;
private String description;
Date created;
Date updated;
int visit;
int developerid;

  public int getDeveloperid() {
    return developerid;
  }

  public void setDeveloperid(int developerid) {
    this.developerid = developerid;
  }

  public Website(){

}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  public Date getUpdated() {
    return updated;
  }

  public void setUpdated(Date updated) {
    this.updated = updated;
  }

  public int getVisit() {
    return visit;
  }

  public void setVisit(int visit) {
    this.visit = visit;
  }

  public Website(int id,String name,String description, java.sql.Date created,
      java.sql.Date updated,int visits){
    this.id= id;
    this.name = name;
    this.description = description;
    this.created = created;
    this.updated = updated;
    this.visit = visits;
  }
}
