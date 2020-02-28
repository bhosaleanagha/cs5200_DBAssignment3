package edu.northeastern.cs5200.daos;

import edu.northeastern.cs5200.DBConnection;
import edu.northeastern.cs5200.models.Address;
import edu.northeastern.cs5200.models.Phone;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhoneImpl implements PhoneDao {
  Connection conn;
  PreparedStatement pstatement;
  @Override
  public void createPhone(int id,Phone phone) {
    try {
      conn = DBConnection.getConnection();
      String cmd = "Insert into phone(id,phone,is_primary) values(?,?,?)";
      pstatement = conn.prepareStatement(cmd);
      pstatement.setInt(1,id);
      pstatement.setString(2,phone.getPhone());
      pstatement.setBoolean(3,phone.getIsprimary());
      pstatement.execute();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public int updatePhone(int id, Phone phone) {
    try {
      conn = DBConnection.getConnection();
      String cmd ="Update phone set phone = ? where id = ?  and phone =?";
      pstatement= conn.prepareStatement(cmd);
      pstatement.setString(1,phone.getPhone());
      pstatement.setInt(2,id);
      pstatement.setString(3,phone.getOldNumber());
      return pstatement.executeUpdate();

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return -1;
  }


  @Override
  public void deletePhone(int id, Phone phone) {
    try {
      conn = DBConnection.getConnection();
      String cmd = "Delete from phone where id = ? and phone =?";
      pstatement = conn.prepareStatement(cmd);
      pstatement.setInt(1,id);
      pstatement.setString(2,phone.getPhone());
      pstatement.executeUpdate();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public List<Phone> findAllPhoneById(int id) {
    try {
      List<Phone> list = new ArrayList<>();
      conn = DBConnection.getConnection();
      String cmd = "Select * from phone where id = ?";
      pstatement= conn.prepareStatement(cmd);
      pstatement.setInt(1,id);
      ResultSet rs = pstatement.executeQuery();
      while(rs.next()){
        Phone phone= new Phone(rs.getString("phone"),rs.getBoolean("is_primary"));
        phone.setId(rs.getInt("id"));
        list.add(phone);
      }
      return list;
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }
}
