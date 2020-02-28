package edu.northeastern.cs5200.daos;


import edu.northeastern.cs5200.DBConnection;
import edu.northeastern.cs5200.models.Page;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PageImpl implements PageDao {
  Connection conn;
  PreparedStatement pstatement;

  @Override
  public void createPageForWebsite(int websiteId, Page page) {
    try {
      conn = DBConnection.getConnection();
      String cmd1 = "INSERT INTO page (id,title,description,created,updated,views,webid) "
          + "values (?,?,?,?,?,?,?)";
      pstatement = conn.prepareStatement(cmd1);
      pstatement.setInt(1, page.getId());
      pstatement.setString(2, page.getTitle());
      pstatement.setString(3, page.getDescription());
      pstatement.setDate(4, page.getCreated());
      pstatement.setDate(5, page.getUpdated());
      pstatement.setInt(6, page.getViews());
      pstatement.setInt(7, websiteId);
      pstatement.execute();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        if (conn != null)
          DBConnection.closeConnection();
        conn.close();

      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

  public Page findPageByPageName(String PageName){
    try {
      Page page = new Page();
      conn = DBConnection.getConnection();
      String cmd = "Select * from page where title = ?";
      pstatement= conn.prepareStatement(cmd);
      pstatement.setString(1,PageName);
      ResultSet result = pstatement.executeQuery();
      if(result.next()){
        page.setId(result.getInt("id"));
        page.setTitle(result.getString("title"));
        page.setDescription(result.getString("description"));
        page.setCreated(result.getDate("created"));
        page.setUpdated(result.getDate("updated"));
        page.setViews(result.getInt("views"));
      }
      return page;
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }
  @Override
  public List<Page> findAllPages() {
    try {
      List<Page> pageList = new ArrayList<>();
      conn = DBConnection.getConnection();
      String cmd = "Select * from page";
      pstatement= conn.prepareStatement(cmd);
      ResultSet result = pstatement.executeQuery();
      while(result.next()){
        Page page =new Page(result.getInt("id"),result.getString("title"),
            result.getString("description"),result.getDate("created"),
            result.getDate("updated"),result.getInt("views"));
        page.setWebid(result.getInt("webid"));
        pageList.add(page);
      }
      return pageList;
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }



  @Override
  public Page findPageById(int pageId) {
    try {
      Page page = null;
      conn = DBConnection.getConnection();
      String cmd = "Select * from page where id = ?";
      pstatement= conn.prepareStatement(cmd);
      pstatement.setInt(1,pageId);
      ResultSet result = pstatement.executeQuery();
      if(result.next()){
         page =new Page(result.getInt("id"),result.getString("title"),
            result.getString("description"),result.getDate("created"),
            result.getDate("updated"),result.getInt("views"));
        page.setWebid(result.getInt("webid"));
      }
      return page;
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public Collection<Page> findPagesForWebsite(int websiteId) {

    try {
      List<Page> page = new ArrayList<>();
      conn = DBConnection.getConnection();
      String cmd = "Select * from page where webid = ?";
      pstatement= conn.prepareStatement(cmd);
      pstatement.setInt(1,websiteId);
      ResultSet rs = pstatement.executeQuery();
      while(rs.next()){
        page.add(new Page(rs.getInt("id"),rs.getString("title"),
            rs.getString("description"),rs.getDate("created"),
            rs.getDate("updated"),rs.getInt("views")));
      }
      return page;
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return null;
  }

  @Override
  public int deletePage(int pageId) {
    try {
      conn = DBConnection.getConnection();
      String cmd = "Delete from page where id = ?";
      pstatement = conn.prepareStatement(cmd);
      pstatement.setInt(1,pageId);
      int result = pstatement.executeUpdate();
      return result;
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return 0;
  }

  @Override
  public int updatePage(int pageId, Page page) {
    try {
      conn = DBConnection.getConnection();
      String cmd = "update page set title = ?,description = ?, created = ?, updated = ?,views = ? "
          + "where id = ?";
      pstatement =conn.prepareStatement(cmd);
        pstatement.setString(1,page.getTitle());
        pstatement.setString(2,page.getDescription());
        pstatement.setDate(3,page.getCreated());
      pstatement.setDate(4,page.getUpdated());
      pstatement.setInt(5,page.getViews());
      pstatement.setInt(6,pageId);
        pstatement.executeUpdate();

      }
     catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    finally {
      try {
        if (conn != null)
          DBConnection.closeConnection();
        conn.close();

      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return 0;
  }
}
