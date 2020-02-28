package edu.northeastern.cs5200.daos;

import edu.northeastern.cs5200.DBConnection;
import edu.northeastern.cs5200.models.Dtype;
import edu.northeastern.cs5200.models.Widget;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class WidgetImpl implements WidgetDao {

  Connection conn;
  PreparedStatement pstatement;

  @Override
  public void createWidgetForPage(int pageId, Widget widget) {
    try {
      conn = DBConnection.getConnection();

      switch (widget.getDtype()) {
        case "heading":
          String cmd1 = "INSERT INTO widget (id,name,text,sequence,width,height,pageid,dtype,"
              + "cssClass,cssStyle,size) "
              + "values (?,?,?,?,?,?,?,?,?,?,?)";
          pstatement = conn.prepareStatement(cmd1);
          pstatement.setInt(1, widget.getId());
          pstatement.setString(2, widget.getName());
          pstatement.setString(3, widget.getText());
          pstatement.setInt(4, widget.getSequence());
          pstatement.setInt(5, widget.getWidth());
          pstatement.setInt(6, widget.getHeight());
          pstatement.setInt(7, pageId);
          pstatement.setString(8, "heading");
          pstatement.setString(9, null);
          pstatement.setString(10, null);
          pstatement.setInt(11, 2);
          break;
        case "youtube":
          String cmd2 = "INSERT INTO widget (id,name,text,sequence,width,height,pageid,dtype,"
              + "cssClass,cssStyle,url,shareable,expandable) "
              + "values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
          pstatement = conn.prepareStatement(cmd2);
          pstatement.setInt(1, widget.getId());
          pstatement.setString(2, widget.getName());
          pstatement.setString(3, widget.getText());
          pstatement.setInt(4, widget.getSequence());
          pstatement.setInt(5, widget.getWidth());
          pstatement.setInt(6, widget.getHeight());
          pstatement.setInt(7, pageId);
          pstatement.setString(8, "youtube");
          pstatement.setString(9, widget.getCssClass());
          pstatement.setString(10, widget.getCssStyle());
          pstatement.setString(11, widget.getUrl());
          pstatement.setBoolean(12, widget.getShareable());
          pstatement.setBoolean(13, widget.getExpandable());
          break;
        case "html":
          String cmd3 = "INSERT INTO widget (id,name,text,sequence,width,height,pageid,dtype,"
              + "cssClass,cssStyle,html) "
              + "values (?,?,?,?,?,?,?,?,?,?,?)";
          pstatement = conn.prepareStatement(cmd3);
          pstatement.setInt(1, widget.getId());
          pstatement.setString(2, widget.getName());
          pstatement.setString(3, widget.getText());
          pstatement.setInt(4, widget.getSequence());
          pstatement.setInt(5, widget.getWidth());
          pstatement.setInt(6, widget.getHeight());
          pstatement.setInt(7, pageId);
          pstatement.setString(8, "html");
          pstatement.setString(9, widget.getCssClass());
          pstatement.setString(10, widget.getCssStyle());
          pstatement.setString(11, widget.getHtml());
          break;
        case "image":
          String cmd4 = "INSERT INTO widget (id,name,text,sequence,width,height,pageid,dtype,"
              + "cssClass,cssStyle,src) "
              + "values (?,?,?,?,?,?,?,?,?,?,?)";
          pstatement = conn.prepareStatement(cmd4);
          pstatement.setInt(1, widget.getId());
          pstatement.setString(2, widget.getName());
          pstatement.setString(3, widget.getText());
          pstatement.setInt(4, widget.getSequence());
          pstatement.setInt(5, widget.getWidth());
          pstatement.setInt(6, widget.getHeight());
          pstatement.setInt(7, pageId);
          pstatement.setString(8, "image");
          pstatement.setString(9, widget.getCssClass());
          pstatement.setString(10, widget.getCssStyle());
          pstatement.setString(11, widget.getSrc());
          break;
        default:
          break;
      }
      pstatement.execute();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }


  @Override
  public Collection<Widget> findAllWidgets() {

    try {
      List<Widget> list = new ArrayList<>();
      conn = DBConnection.getConnection();
      String cmd = "Select * from widget";
      pstatement=conn.prepareStatement(cmd);
      ResultSet rs = pstatement.executeQuery();
      while(rs.next()){
        Widget w = new Widget();
        w.setName(rs.getString("name"));
        w.setCssClass(rs.getString("cssclass"));
        w.setCssStyle(rs.getString("cssstyle"));
        w.setWidth(rs.getInt("width"));
        w.setHeight(rs.getInt("height"));
        w.setText(rs.getString("text"));
        w.setSequence(rs.getInt("sequence"));
        w.setUrl(rs.getString("url"));
        w.setShareable(rs.getBoolean("shareable"));
        w.setExpandable(rs.getBoolean("expandable"));
        w.setSrc(rs.getString("src"));
        w.setSize(rs.getInt("size"));
        w.setHtml(rs.getString("html"));
        w.setPageid(rs.getInt("pageid"));
        w.setDtype(rs.getString("dtype"));
        list.add(w);
      }
      return list;
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return null;
  }

  @Override
  public Widget findWidgetById(int widgetId) {

    try {
      Widget w = new Widget();
      conn = DBConnection.getConnection();
      String cmd = "Select * from widget where id =?";
      pstatement=conn.prepareStatement(cmd);
      pstatement.setInt(1,widgetId);
      ResultSet rs = pstatement.executeQuery();
      if(rs.next()){
        w.setName(rs.getString("name"));
        w.setCssClass(rs.getString("cssclass"));
        w.setCssStyle(rs.getString("cssstyle"));
        w.setWidth(rs.getInt("width"));
        w.setHeight(rs.getInt("height"));
        w.setText(rs.getString("text"));
        w.setSequence(rs.getInt("sequence"));
        w.setUrl(rs.getString("url"));
        w.setShareable(rs.getBoolean("shareable"));
        w.setExpandable(rs.getBoolean("expandable"));
        w.setSrc(rs.getString("src"));
        w.setSize(rs.getInt("size"));
        w.setHtml(rs.getString("html"));
        w.setPageid(rs.getInt("pageid"));
        w.setDtype(rs.getString("dtype"));
      }
      return w;
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }return null;
  }

  @Override
  public Collection<Widget> findWidgetsForPage(int pageId) {
    List<Widget> list = new ArrayList<>();
    try {
      conn = DBConnection.getConnection();
      String cmd = "Select * from widget where pageid = ?";
      pstatement = conn.prepareStatement(cmd);
      pstatement.setInt(1, pageId);
      ResultSet rs = pstatement.executeQuery();
      while (rs.next()) {
       Widget w1 = new Widget(rs.getInt("id"), rs.getString("name"),
            rs.getInt("width"), rs.getInt("height"),
            rs.getString("cssStyle"), rs.getString("cssClass"),
            rs.getString("text"), rs.getInt("sequence"), rs.getInt("size"),
            rs.getString("html"), rs.getString("src"), rs.getString("url"),
            rs.getBoolean("shareable"),
            rs.getBoolean("expandable"), rs.getString("dtype"));
        w1.setPageid(rs.getInt("pageid"));
        list.add(w1);
      }
      return list;
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public int updateWidget(int widgetId, Widget widget) {
    try {
      conn = DBConnection.getConnection();
      String cmd = "Update widget set name = ?,width=?,height=?,cssClass=?,cssStyle=?,text=?,size=?"
          + ",sequence=?,url=?,shareable=?,expandable=?,src=?,html=?,pageid=?,dtype=? where id =?";
      pstatement=conn.prepareStatement(cmd);
      pstatement.setString(1,widget.getName());
      pstatement.setInt(2,widget.getWidth());
      pstatement.setInt(3,widget.getHeight());
      pstatement.setString(4,widget.getCssClass());
      pstatement.setString(5,widget.getCssStyle());
      pstatement.setString(6,widget.getText());
      pstatement.setInt(7,widget.getSize());
      pstatement.setInt(8,widget.getSequence());
      pstatement.setString(9,widget.getUrl());
      pstatement.setBoolean(10,widget.getShareable());
      pstatement.setBoolean(11,widget.getExpandable());
      pstatement.setString(12,widget.getSrc());
      pstatement.setString(13,widget.getHtml());
      pstatement.setInt(14,widget.getPageid());
      pstatement.setString(15,widget.getDtype());
      pstatement.setInt(16,widget.getId());
      pstatement.executeUpdate();
      return 1;
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return -1;
  }

  @Override
  public int deleteWidget(int widgetId) {
    try {
      conn = DBConnection.getConnection();
      String cmd  ="Delete from widget where id = ?";
      pstatement = conn.prepareStatement(cmd);
      pstatement.setInt(1,widgetId);
      pstatement.executeUpdate();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return 0;
  }

  @Override
  public Widget findWidgetbyName(String name) {
    Widget w1 = null;
    try {
      conn = DBConnection.getConnection();
      String cmd = "Select * from widget where name = ?";
      pstatement = conn.prepareStatement(cmd);
      pstatement.setString(1, name);
      ResultSet rs = pstatement.executeQuery();
      if (rs.next()) {
        w1 = new Widget(rs.getInt("id"), rs.getString("name"),
            rs.getInt("width"), rs.getInt("height"),
            rs.getString("cssStyle"), rs.getString("cssClass"),
            rs.getString("text"), rs.getInt("sequence"), rs.getInt("size"),
            rs.getString("html"), rs.getString("src"), rs.getString("url"),
            rs.getBoolean("shareable"),
            rs.getBoolean("expandable"), rs.getString("dtype"));
       w1.setPageid(rs.getInt("pageid"));
      }
      return w1;
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

}
