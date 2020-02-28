package edu.northeastern.cs5200.daos;

import edu.northeastern.cs5200.DBConnection;
import edu.northeastern.cs5200.models.Address;
import edu.northeastern.cs5200.models.Developer;
import edu.northeastern.cs5200.models.Phone;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class DeveloperImpl implements DeveloperDao {

  Connection conn;
  PreparedStatement pstatement;
  PhoneDao phone = new PhoneImpl();
  ResultSet result;

  @Override
  public void createDeveloper(Developer developer) {
    try {
      conn = DBConnection.getConnection();
      String cmd1 = "Insert into person (id,firstname,lastname,username,password,email,dob) "
          + "values(?,?,?,?,?,?,?)";
      pstatement = conn.prepareStatement(cmd1);
      pstatement.setInt(1, developer.getId());
      pstatement.setString(2, developer.getFirstName());
      pstatement.setString(3, developer.getLastName());
      pstatement.setString(4, developer.getUserName());
      pstatement.setString(5, developer.getPassword());
      pstatement.setString(6, developer.getEmail());
      pstatement.setDate(7, developer.getDob());
      pstatement.execute();
      String cmd = "Insert into developer values (?,?)";
      pstatement = conn.prepareStatement(cmd);
      pstatement.setInt(2, developer.getId());
      pstatement.setString(1, developer.getDeveloperKey());
      pstatement.execute();


    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        if (conn != null) {
          DBConnection.closeConnection();
        }
        conn.close();

      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

  @Override
  public Collection<Developer> findAllDevelopers() {

    try {

      List<Developer> list = new ArrayList<>();
      AddressDao addressDao = new AddressImpl();
      PhoneDao phoneDao = new PhoneImpl();
      conn = DBConnection.getConnection();
      String cmd = "Select * from developer";
      pstatement = conn.prepareStatement(cmd);
      ResultSet rs = pstatement.executeQuery();
      while (rs.next()) {
        Developer d = new Developer();
        d.setId(rs.getInt("id"));
        d.setDeveloperKey("developer_key");
        list.add(d);
      }

      for (Developer d : list) {
        String cmd1 = "Select * from person where id = ?";
        pstatement = conn.prepareStatement(cmd1);
        pstatement.setInt(1, d.getId());
        rs = pstatement.executeQuery();
        if (rs.next()) {
          d.setId(rs.getInt("id"));
          d.setFirstName(rs.getString("firstname"));
          d.setLastName(rs.getString("lastname"));
          d.setUserName(rs.getString("username"));
          d.setPassword(rs.getString("password"));
          d.setEmail(rs.getString("email"));
          d.setDob(rs.getDate("dob"));
          list.add(d);
          d.setAddress(addressDao.findAll(d.getId()));
          d.setPhones(phoneDao.findAllPhoneById(d.getId()));
        }
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
  public Developer findDeveloperById(int developerId) {

    try {

      Developer d = new Developer();
      AddressDao addressDao = new AddressImpl();
      PhoneDao phoneDao = new PhoneImpl();
      conn = DBConnection.getConnection();
      String cmd = "Select * from developer where id =?";
      pstatement = conn.prepareStatement(cmd);
      pstatement.setInt(1, developerId);
      ResultSet rs = pstatement.executeQuery();
      if (rs.next()) {
        d.setId(rs.getInt("id"));
        d.setDeveloperKey("developer_key");
      }

      String cmd1 = "Select * from person where id = ?";
      pstatement = conn.prepareStatement(cmd1);
      pstatement.setInt(1, d.getId());
      rs = pstatement.executeQuery();
      if (rs.next()) {
        d.setId(rs.getInt("id"));
        d.setFirstName(rs.getString("firstname"));
        d.setLastName(rs.getString("lastname"));
        d.setUserName(rs.getString("username"));
        d.setPassword(rs.getString("password"));
        d.setEmail(rs.getString("email"));
        d.setDob(rs.getDate("dob"));

        d.setAddress(addressDao.findAll(d.getId()));
        d.setPhones(phoneDao.findAllPhoneById(d.getId()));
      }

      return d;
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return null;
  }

  @Override
  public Developer findDeveloperByUsername(String username) {
    try {
      Developer developer = new Developer();
      conn = DBConnection.getConnection();
      String cmd2 = "Select * from person where username = ?";
      pstatement = conn.prepareStatement(cmd2);
      pstatement.setString(1, username);
      result = pstatement.executeQuery();
      if (result.next()) {
        developer.setId(result.getInt("id"));
        developer.setFirstName(result.getString("firstname"));
        developer.setLastName(result.getString("lastname"));
        developer.setUserName(result.getString("username"));
        developer.setPassword(result.getString("password"));
        developer.setEmail(result.getString("email"));
        developer.setDob(result.getDate("dob"));
      }
      String cmd1 = "Select * from developer where id = ?";
      pstatement = conn.prepareStatement(cmd1);
      pstatement.setInt(1, developer.getId());
      result = pstatement.executeQuery();
      if (result.next()) {
        developer.setDeveloperKey(result.getString("developer_key"));
      }

      String cmd3 = "Select * from address where id = ?";
      pstatement = conn.prepareStatement(cmd3);
      pstatement.setInt(1, developer.getId());
      result = pstatement.executeQuery();
      List<Address> listaddress = new ArrayList<>();
      while (result.next()) {
        Address addr = new Address(result.getString("street1"), result.getString("street2"),
            result.getString("city"), result.getString("state"), result.getInt("zip"),
            result.getBoolean("is_primary")
        );
        listaddress.add(addr);
      }
      developer.setAddress(listaddress);

      String cmd4 = "Select * from phone where id = ?";
      pstatement = conn.prepareStatement(cmd4);
      pstatement.setInt(1, developer.getId());
      result = pstatement.executeQuery();
      List<Phone> listphone = new ArrayList<>();
      while (result.next()) {
        Phone phone = new Phone(result.getString("phone"),
            result.getBoolean("is_primary")
        );
        listphone.add(phone);
      }
      developer.setPhones(listphone);
      return developer;
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    } /*finally {
      try {
        if (conn != null)
        conn.close();

      } catch (SQLException e) {
        e.printStackTrace();
      }
    }*/
    return null;
  }

  @Override
  public Developer findDeveloperByCredentials(String username, String password) {
    try {

      Developer d = new Developer();
      AddressDao addressDao = new AddressImpl();
      PhoneDao phoneDao = new PhoneImpl();
      conn = DBConnection.getConnection();
      String cmd = "Select * from developer where username = ? and password = ?";
      pstatement = conn.prepareStatement(cmd);
      pstatement.setString(1, username);
      pstatement.setString(2, password);
      ResultSet rs = pstatement.executeQuery();
      if (rs.next()) {
        d.setId(rs.getInt("id"));
        d.setDeveloperKey("developer_key");
      }

      String cmd1 = "Select * from person where id = ?";
      pstatement = conn.prepareStatement(cmd1);
      pstatement.setInt(1, d.getId());
      rs = pstatement.executeQuery();
      if (rs.next()) {
        d.setId(rs.getInt("id"));
        d.setFirstName(rs.getString("firstname"));
        d.setLastName(rs.getString("lastname"));
        d.setUserName(rs.getString("username"));
        d.setPassword(rs.getString("password"));
        d.setEmail(rs.getString("email"));
        d.setDob(rs.getDate("dob"));

        d.setAddress(addressDao.findAll(d.getId()));
        d.setPhones(phoneDao.findAllPhoneById(d.getId()));
      }

      return d;
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return null;

  }

  @Override
  public int updateDeveloper(int developerId, Developer developer) {
    try {
      conn = DBConnection.getConnection();
      PhoneDao phoneDao = new PhoneImpl();
      AddressDao addressDao = new AddressImpl();
      String cmd = "update person set firstname = ?, lastname = ?,username = ?,password = ?,"
          + "email = ?, dob=? where id = ?";
      pstatement = conn.prepareStatement(cmd);
      pstatement.setString(1, developer.getFirstName());
      pstatement.setString(2, developer.getLastName());
      pstatement.setString(3, developer.getUserName());
      pstatement.setString(4, developer.getPassword());
      pstatement.setString(5, developer.getEmail());
      pstatement.setDate(6, developer.getDob());
      pstatement.setInt(7, developerId);
      pstatement.executeUpdate();

      String cmd1 = "update developer set developer_key =? where id = ?";
      pstatement = conn.prepareStatement(cmd1);
      pstatement.setString(1, developer.getDeveloperKey());
      pstatement.setInt(2, developerId);
      pstatement.executeUpdate();
      Developer developerold = findDeveloperByUsername(developer.getUserName());

      for (int i = 0; i < developer.getPhones().size(); i++) {
        if (developer.getPhones().get(i).isChanged() == true) {
          phoneDao.updatePhone(developer.getId(), developer.getPhones().get(i));
        }

      }
      for (int i = 0; i < developer.getAddress().size(); i++) {
        if (developer.getAddress().get(i).isChanged() == true) {
          addressDao.updateAddress(developerId, developer.getAddress().get(i));
        }
      }

      return 1;
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    return 0;
  }

  @Override
  public int deleteDeveloper(int developerId) {
    try {
      conn = DBConnection.getConnection();
      String cmd = "Delete from developer where id = ?";
      pstatement = conn.prepareStatement(cmd);
      pstatement.setInt(1, developerId);
      return pstatement.executeUpdate();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return -1;
  }
}
