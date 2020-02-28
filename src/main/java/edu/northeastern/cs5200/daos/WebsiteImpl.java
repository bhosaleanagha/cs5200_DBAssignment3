package edu.northeastern.cs5200.daos;

import edu.northeastern.cs5200.DBConnection;
import edu.northeastern.cs5200.models.Website;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.validation.constraints.Null;

public class WebsiteImpl implements WebsiteDao {
  Connection conn;
  PreparedStatement pstatement;
  @Override
  public void createWebsiteForDeveloper(int developerId, Website website) {
    try {
      conn = DBConnection.getConnection();
      String cmd1 = "INSERT INTO website (id,name,description,visits,developerid) "
          + "values (?,?,?,?,?)";
      pstatement = conn.prepareStatement(cmd1);
      pstatement.setInt(1,website.getId());
      pstatement.setString(2,website.getName());
      pstatement.setString(3,website.getDescription());
      pstatement.setInt(4,website.getVisit());
      pstatement.setInt(5,developerId);
      pstatement.execute();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public Collection<Website> findAllWebsites() {

    try {
      List<Website> website = new ArrayList<>();
      conn= DBConnection.getConnection();
      String cmd ="Select * from website";
      pstatement =conn.prepareStatement(cmd);
      ResultSet rs = pstatement.executeQuery();
      while(rs.next()){
        Website web = new Website();
        web.setName(rs.getString("name"));
        web.setDescription(rs.getString("description"));
        web.setCreated(rs.getDate("created"));
        web.setUpdated(rs.getDate("updated"));
        web.setVisit(rs.getInt("visits"));
        web.setDeveloperid(rs.getInt("developerid"));
        website.add(web);
      }
      return website;
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;

  }

  @Override
  public Collection<Website> findWebsitesForDeveloper(int developerId) {
    try {
      List<Website> website = new ArrayList<>();
      conn= DBConnection.getConnection();
      String cmd ="Select * from website where developerid = ?";
      pstatement =conn.prepareStatement(cmd);
      pstatement.setInt(1,developerId);
      ResultSet rs = pstatement.executeQuery();
      while(rs.next()){
        Website web = new Website();
        web.setName(rs.getString("name"));
        web.setDescription(rs.getString("description"));
        web.setCreated(rs.getDate("created"));
        web.setUpdated(rs.getDate("updated"));
        web.setVisit(rs.getInt("visits"));
        web.setDeveloperid(rs.getInt("developerid"));
        website.add(web);
      }
      return website;
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public Website findWebsiteById(int websiteId) {
    try {
      conn = DBConnection.getConnection();
      String cmd = "Select * from website where id = ?";
      pstatement=conn.prepareStatement(cmd);
      pstatement.setInt(1,websiteId);
      ResultSet result = pstatement.executeQuery();
      if(result.next()){
        Website website = new Website(result.getInt("id"),result.getString("name"),
            result.getString("description"),result.getDate("created"),
            result.getDate("updated"),result.getInt("visits"));
        website.setDeveloperid(result.getInt("developerid"));
        return website;
      }
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return null;
  }

  @Override
  public List<Integer> findDevelopersByWebsiteId(int websiteId) {

    try {
      List<Integer> developerList = new ArrayList<>();
      conn = DBConnection.getConnection();
      String cmd = "Select developerid from website where id = ? ";
      pstatement = conn.prepareStatement(cmd);
      pstatement.setInt(1,websiteId);
      ResultSet rs = pstatement.executeQuery();
      while(rs.next()){
        developerList.add(rs.getInt("developerid"));
      }
      return developerList;
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }


    return null;
  }

  @Override
  public int findWebsiteIdByName(String name) {

    try {
      conn = DBConnection.getConnection();
      String cmd = "Select * from website where name = ?";
      pstatement = conn.prepareStatement(cmd);
      pstatement.setString(1,name);
      ResultSet rs = pstatement.executeQuery();
      if(rs.next()){
        return rs.getInt("id");
      }
      else{
        throw new NullPointerException();
      }
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (NullPointerException e) {
      System.out.println("No Id found");
    }

    return 0;
  }

  @Override
  public int updateWebsite(int websiteId, Website website) {

    try {
      conn= DBConnection.getConnection();
      String cmd = "update website set name =?, description=?,created =?, updated =?, visits=?, developerid=?"
          + "where id =?";
      pstatement= conn.prepareStatement(cmd);
      pstatement.setString(1,website.getName());
      pstatement.setString(2,website.getDescription());
      pstatement.setDate(3,website.getCreated());
      pstatement.setDate(4,website.getUpdated());
      pstatement.setInt(5,website.getVisit());
      pstatement.setInt(6,website.getDeveloperid());
      pstatement.setInt(7,websiteId);
      return pstatement.executeUpdate();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return 0;
  }

  @Override
  public int deleteWebsite(int websiteId) {
    try {
      conn=DBConnection.getConnection();
      String cmd = "Delete from website where id = ?";
      pstatement = conn.prepareStatement(cmd);
      pstatement.setInt(1,websiteId);
      int result = pstatement.executeUpdate();
      return result;
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }


    return 0;
  }
}
