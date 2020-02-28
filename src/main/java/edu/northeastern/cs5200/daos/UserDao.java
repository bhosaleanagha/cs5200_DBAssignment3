package edu.northeastern.cs5200.daos;

import edu.northeastern.cs5200.models.Developer;
import edu.northeastern.cs5200.models.User;
import java.util.Collection;

public interface UserDao {

  void createUser(User user);

  Collection<User> findAllUser();

  User findUserById(int userId);

  int updateUser(int userId, User user);

  int deleteUser(int userId);
}
