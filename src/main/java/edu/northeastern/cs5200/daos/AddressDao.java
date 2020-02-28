package edu.northeastern.cs5200.daos;

import edu.northeastern.cs5200.models.Address;
import java.util.List;

public interface AddressDao {

  void createAddress(int developerid, Address address);

  void deleteAddress(int developerid, Address address);

  int updateAddress(int id, Address address);

  List<Address> findAll(int userid);
}
