package edu.northeastern.cs5200.daos;

import edu.northeastern.cs5200.DBConnection;
import edu.northeastern.cs5200.models.Developer;
import edu.northeastern.cs5200.models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserImpl implements UserDao {
  Connection conn;
  PreparedStatement pstatement;
  @Override
  public void createUser(User user) {

    try {
      conn = DBConnection.getConnection();
      String cmd1 = "Insert into person (id,firstname,lastname,username,password,email,dob) "
          + "values(?,?,?,?,?,?,?)";
      pstatement = conn.prepareStatement(cmd1);
      pstatement.setInt(1,user.getId());
      pstatement.setString(2,user.getFirstName());
      pstatement.setString(3,user.getLastName());
      pstatement.setString(4,user.getUserName());
      pstatement.setString(5,user.getPassword());
      pstatement.setString(6,user.getEmail());
      pstatement.setDate(7,user.getDob());
      pstatement.execute();
      String cmd = "Insert into user values(?,?)";
      pstatement = conn.prepareStatement(cmd);
      pstatement.setBoolean(1,user.getUserAgreement());
      pstatement.setInt(2,user.getId());
      pstatement.execute();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  @Override
  public Collection<User> findAllUser() {
    try {

      List<User> list = new ArrayList<>();
      AddressDao addressDao = new AddressImpl();
      PhoneDao phoneDao = new PhoneImpl();
      conn = DBConnection.getConnection();
      String cmd = "Select * from user";
      pstatement = conn.prepareStatement(cmd);
      ResultSet rs = pstatement.executeQuery();
      while(rs.next()) {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setUserAgreement(rs.getBoolean("user_agreement"));
        list.add(user);
      }

      for(User user: list){
        String cmd1 = "Select * from person where id = ?";
        pstatement = conn.prepareStatement(cmd1);
        pstatement.setInt(1,user.getId());
        rs = pstatement.executeQuery();
        if(rs.next()){
          user.setId(rs.getInt("id"));
          user.setFirstName(rs.getString("firstname"));
          user.setLastName(rs.getString("lastname"));
          user.setUserName(rs.getString("username"));
          user.setPassword(rs.getString("password"));
          user.setEmail(rs.getString("email"));
          user.setDob(rs.getDate("dob"));
          list.add(user);
          user.setAddress(addressDao.findAll(user.getId()));
          user.setPhones(phoneDao.findAllPhoneById(user.getId()));
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
  public User findUserById(int userId) {
    try {

      User user = new User();
      AddressDao addressDao = new AddressImpl();
      PhoneDao phoneDao = new PhoneImpl();
      conn = DBConnection.getConnection();
      String cmd = "Select * from user where id =?";
      pstatement = conn.prepareStatement(cmd);
      pstatement.setInt(1,userId);
      ResultSet rs = pstatement.executeQuery();
      if(rs.next()) {
        user.setId(rs.getInt("id"));
        user.setUserAgreement(rs.getBoolean("user_agreement"));
      }

        String cmd1 = "Select * from person where id = ?";
        pstatement = conn.prepareStatement(cmd1);
        pstatement.setInt(1,user.getId());
        rs = pstatement.executeQuery();
        if(rs.next()){
          user.setId(rs.getInt("id"));
          user.setFirstName(rs.getString("firstname"));
          user.setLastName(rs.getString("lastname"));
          user.setUserName(rs.getString("username"));
          user.setPassword(rs.getString("password"));
          user.setEmail(rs.getString("email"));
          user.setDob(rs.getDate("dob"));

          user.setAddress(addressDao.findAll(user.getId()));
          user.setPhones(phoneDao.findAllPhoneById(user.getId()));
        }

      return user;
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return null;
  }


  @Override
  public int updateUser(int userId, User user) {
    try {
      conn = DBConnection.getConnection();
      PhoneDao phoneDao = new PhoneImpl();
      AddressDao addressDao = new AddressImpl();
      String cmd = "update person set firstname = ?, lastname = ?,username = ?,password = ?,"
          + "email = ?, dob=? where id = ?";
      pstatement = conn.prepareStatement(cmd);
      pstatement.setString(1, user.getFirstName());
      pstatement.setString(2, user.getLastName());
      pstatement.setString(3, user.getUserName());
      pstatement.setString(4, user.getPassword());
      pstatement.setString(5, user.getEmail());
      pstatement.setDate(6, user.getDob());
      pstatement.setInt(7, userId);
      pstatement.executeUpdate();

      String cmd1 = "update user set user_agreement =? where id = ?";
      pstatement = conn.prepareStatement(cmd1);
      pstatement.setBoolean(1, user.getUserAgreement());
      pstatement.setInt(2,userId);
      pstatement.executeUpdate();

      for (int i = 0; i < user.getPhones().size(); i++) {
        if (user.getPhones().get(i).isChanged() == true) {
          phoneDao.updatePhone(user.getId(), user.getPhones().get(i));
        }

      }
      for (int i = 0; i < user.getAddress().size(); i++) {
        if (user.getAddress().get(i).isChanged() == true) {
          addressDao.updateAddress(userId, user.getAddress().get(i));
        }
      }

      return 1;
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    return -1;
  }

  @Override
  public int deleteUser(int userId) {

    try {
      conn=DBConnection.getConnection();
      String cmd = " Delete from user where id = ?";
      pstatement= conn.prepareStatement(cmd);
      pstatement.setInt(1,userId);
      return pstatement.executeUpdate();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return -1;
  }
}
