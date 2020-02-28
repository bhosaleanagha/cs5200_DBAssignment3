package edu.northeastern.cs5200.daos;

import edu.northeastern.cs5200.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleImpl implements RoleDao {
  Connection conn;
  PreparedStatement pstatement;
  PrivilegeDao p = new PrvilegeImpl();;
  @Override
  public void assignWebsiteRole(int developerId, int websiteId, int roleId) {
    try {
      p = new PrvilegeImpl();
      conn = DBConnection.getConnection();
      String cmd = "INSERT INTO website_role (developer_id,website_id,role_id) "
          + "values (?,?,?)";
      pstatement = conn.prepareStatement(cmd);
      pstatement.setInt(1,developerId);
      pstatement.setInt(2,websiteId);
      pstatement.setInt(3,roleId);
      pstatement.execute();

      switch(roleId){
        case 1:
        case 2:
          p.assignWebsitePrivilege(developerId,websiteId,"create");
          p.assignWebsitePrivilege(developerId,websiteId,"read");
          p.assignWebsitePrivilege(developerId,websiteId,"update");
          p.assignWebsitePrivilege(developerId,websiteId,"delete");
          break;
        case 3:p.assignWebsitePrivilege(developerId,websiteId,"create");
          p.assignWebsitePrivilege(developerId,websiteId,"read");
          p.assignWebsitePrivilege(developerId,websiteId,"update");
          break;
        case 4:p.assignWebsitePrivilege(developerId,websiteId,"read");
          p.assignWebsitePrivilege(developerId,websiteId,"update");
          break;
        case 5:p.assignWebsitePrivilege(developerId,websiteId,"read");
          break;
        default:
          break;
      }
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }



  @Override
  public void assignPageRole(int developerId, int pageId, int roleId) {
    try {
      conn = DBConnection.getConnection();
      String cmd = "INSERT INTO page_role (developer_id,page_id,role_id) "
          + "values (?,?,?)";
      pstatement = conn.prepareStatement(cmd);
      pstatement.setInt(1,developerId);
      pstatement.setInt(2,pageId);
      pstatement.setInt(3,roleId);
      pstatement.execute();

      switch(roleId){
        case 1:
        case 2:
          p.assignPagePriviledge(developerId,pageId,"create");
          p.assignPagePriviledge(developerId,pageId,"read");
          p.assignPagePriviledge(developerId,pageId,"update");
          p.assignPagePriviledge(developerId,pageId,"delete");
          break;
        case 3:p.assignPagePriviledge(developerId,pageId,"create");
          p.assignPagePriviledge(developerId,pageId,"read");
          p.assignPagePriviledge(developerId,pageId,"update");
          break;
        case 4:p.assignPagePriviledge(developerId,pageId,"read");
          p.assignPagePriviledge(developerId,pageId,"update");
          break;
        case 5:p.assignPagePriviledge(developerId,pageId,"read");
          break;
        default:
          break;
      }
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void deleteWebsiteRole(int developerId, int websiteId, int roleId) {
    try {
      conn = DBConnection.getConnection();
      String cmd = "Delete from website_role where developer_id = ? and website_id= ? and role_id = ?";
      pstatement = conn.prepareStatement(cmd);
      pstatement.setInt(1,developerId);
      pstatement.setInt(2,websiteId);
      pstatement.setInt(3,roleId);
      pstatement.executeUpdate();
      switch(roleId){
        case 1:
        case 2:
          p.deleteWebsitePriviledge(developerId,websiteId,"create");
          p.deleteWebsitePriviledge(developerId,websiteId,"read");
          p.deleteWebsitePriviledge(developerId,websiteId,"update");
          p.deleteWebsitePriviledge(developerId,websiteId,"delete");
          break;
        case 3:p.deleteWebsitePriviledge(developerId,websiteId,"create");
          p.deleteWebsitePriviledge(developerId,websiteId,"read");
          p.deleteWebsitePriviledge(developerId,websiteId,"update");
          break;
        case 4:p.deleteWebsitePriviledge(developerId,websiteId,"read");
          p.deleteWebsitePriviledge(developerId,websiteId,"update");
          break;
        case 5:p.deleteWebsitePriviledge(developerId,websiteId,"read");
          break;
        default:
          break;
      }
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  @Override
  public void deletePageRole(int developerId, int pageId, int roleId) {
    try {

      conn = DBConnection.getConnection();
      String cmd = "Delete from page_role where developer_id = ? and page_id = ? and role_id = ?";
      pstatement = conn.prepareStatement(cmd);
      pstatement.setInt(1, developerId);
      pstatement.setInt(2, pageId);
      pstatement.setInt(3, roleId);
      pstatement.executeUpdate();
      switch (roleId) {
        case 1:
        case 2:
          p.deletePagePriviledge(developerId, pageId, "create");
          p.deletePagePriviledge(developerId, pageId, "read");
          p.deletePagePriviledge(developerId, pageId, "update");
          p.deletePagePriviledge(developerId, pageId, "delete");
          break;
        case 3:
          p.deletePagePriviledge(developerId, pageId, "create");
          p.deletePagePriviledge(developerId, pageId, "read");
          p.deletePagePriviledge(developerId, pageId, "update");
          break;
        case 4:
          p.deletePagePriviledge(developerId, pageId, "read");
          p.deletePagePriviledge(developerId, pageId, "update");
          break;
        case 5:
          p.deletePagePriviledge(developerId, pageId, "read");
          break;
        default:
          break;
      }

    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

    public int findRoleIdForPage(int developerId,int pageId){
    try {
      conn = DBConnection.getConnection();
      String cmd = "Select * from page_role where developer_id = ? and page_id = ?";
      pstatement = conn.prepareStatement(cmd);
      pstatement.setInt(1,developerId);
      pstatement.setInt(2,pageId);
      ResultSet rs = pstatement.executeQuery();
      if (rs.next()){
        return rs.getInt("role_id");
      }

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return 0;
  }

  public int findRoleIdForWebsite(int developerId,int websiteid){
    try {
      conn = DBConnection.getConnection();
      String cmd = "Select * from website_role where developer_id = ? and website_id = ?";
      pstatement = conn.prepareStatement(cmd);
      pstatement.setInt(1,developerId);
      pstatement.setInt(2,websiteid);
      ResultSet rs = pstatement.executeQuery();
      if (rs.next()){
        return rs.getInt("role_id");
      }

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return 0;
  }
}
