package edu.northeastern.cs5200.daos;

import edu.northeastern.cs5200.models.Phone;
import java.util.List;

public interface PhoneDao {
  void createPhone(int developerid,Phone phone);

  int updatePhone(int id, Phone phone);

  void deletePhone(int id,Phone phone);

  List<Phone> findAllPhoneById(int id);
}
