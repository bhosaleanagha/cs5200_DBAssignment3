package edu.northeastern.cs5200.daos;

import edu.northeastern.cs5200.DBConnection;
import edu.northeastern.cs5200.models.Address;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressImpl implements  AddressDao {
  Connection conn;
  PreparedStatement pstatement;
  @Override
  public void createAddress(int developerid, Address address) {
    try {
      conn = DBConnection.getConnection();
      String cmd = "Insert into address(id,is_primary,street1,street2,city,state,zip) "
          + "values(?,?,?,?,?,?,?)";
      pstatement = conn.prepareStatement(cmd);
      pstatement.setInt(1,developerid);
      pstatement.setBoolean(2,address.getIsprimary());
      pstatement.setString(3,address.getStreet1());
      pstatement.setString(4,address.getStreet2());
      pstatement.setString(5,address.getCity());
      pstatement.setString(6,address.getState());
      pstatement.setInt(7,address.getZip());
      pstatement.execute();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void deleteAddress(int developerid, Address address) {
    try {
      conn = DBConnection.getConnection();
      String cmd = "Delete from address where id = ? and is_primary = ?";
      pstatement = conn.prepareStatement(cmd);
      pstatement.setInt(1,developerid);
      pstatement.setBoolean(2,address.getIsprimary());
      pstatement.executeUpdate();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  @Override
  public int updateAddress(int id, Address address) {
    try {
      conn = DBConnection.getConnection();
      String cmd = " Update address set street1= ?, street2=?,city=?,state=?,zip=?,is_primary=? where "
          + "id =? and street1= ? and street2=? and city=? and state=? and zip=? and is_primary=?";
      pstatement= conn.prepareStatement(cmd);
      pstatement.setString(1,address.getStreet1());
      pstatement.setString(2,address.getStreet2());
      pstatement.setString(3,address.getCity());
      pstatement.setString(4,address.getState());
      pstatement.setInt(5,address.getZip());
      pstatement.setBoolean(6,address.getIsprimary());
      pstatement.setInt(7,id);
      pstatement.setString(8,address.getOldstreet1());
      pstatement.setString(9,address.getOldstreet2());
      pstatement.setString(10,address.getOldcity());
      pstatement.setString(11,address.getOldstate());
      pstatement.setInt(12,address.getZip());
      pstatement.setBoolean(13,address.getOldisprimary());
      pstatement.executeUpdate();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return 0;
  }

  @Override
  public List<Address> findAll(int userid) {
    try {
      List<Address> list = new ArrayList<>();
      conn = DBConnection.getConnection();
      String cmd = "Select * from address where id = ?";
      pstatement= conn.prepareStatement(cmd);
      pstatement.setInt(1,userid);
      ResultSet rs = pstatement.executeQuery();
      while(rs.next()){
        Address address= new Address(rs.getString("street1"),
            rs.getString("street2"),rs.getString("city"),rs.getString("state"),
       rs.getInt("zip"), rs.getBoolean("isprimary"));
        address .setId(rs.getInt("id"));
        list.add(address);
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
