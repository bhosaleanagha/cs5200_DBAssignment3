package edu.northeastern.cs5200.daos;

import edu.northeastern.cs5200.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PrvilegeImpl implements PrivilegeDao {
  Connection conn;
  PreparedStatement pstatement;
  @Override
  public void assignWebsitePrivilege(int developerId, int websiteId, String priviledge) {
    try {
      conn = DBConnection.getConnection();
      String cmd = "INSERT INTO website_privilege(developer_id,website_id,privilege) "
          + "values (?,?,?)";
      pstatement = conn.prepareStatement(cmd);
      pstatement.setInt(1,developerId);
      pstatement.setInt(2,websiteId);
      pstatement.setString(3,priviledge);
      pstatement.execute();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  @Override
  public void assignPagePriviledge(int developerId, int pageId, String priviledge) {
    try {
      conn = DBConnection.getConnection();
      String cmd = "INSERT INTO page_privilege(developer_id,page_id,privilege) "
          + "values (?,?,?)";
      pstatement = conn.prepareStatement(cmd);
      pstatement.setInt(1,developerId);
      pstatement.setInt(2,pageId);
      pstatement.setString(3,priviledge);
      pstatement.execute();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void deleteWebsitePriviledge(int developerId, int websiteId, String priviledge) {
    try {
      conn = DBConnection.getConnection();
      String cmd = "Delete from  website_privilege where  developer_id=? and website_id = ? and "
          + "privilege =?";
      pstatement = conn.prepareStatement(cmd);
      pstatement.setInt(1,developerId);
      pstatement.setInt(2,websiteId);
      pstatement.setString(3,priviledge);
      pstatement.executeUpdate();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void deletePagePriviledge(int developerId, int pageId, String priviledge) {
    try {
      conn = DBConnection.getConnection();
      String cmd = "Delete from  page_privilege where  developer_id=? and page_id = ? and "
          + "privilege =?";
      pstatement = conn.prepareStatement(cmd);
      pstatement.setInt(1,developerId);
      pstatement.setInt(2,pageId);
      pstatement.setString(3,priviledge);
      pstatement.executeUpdate();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
