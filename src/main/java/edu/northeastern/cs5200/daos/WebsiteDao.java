package edu.northeastern.cs5200.daos;

import edu.northeastern.cs5200.models.Website;
import java.util.Collection;
import java.util.List;

public interface WebsiteDao {

  void createWebsiteForDeveloper(int developerId, Website website);

  Collection<Website> findAllWebsites();

  Collection<Website> findWebsitesForDeveloper(int developerId);

  Website findWebsiteById(int websiteId);

  List<Integer> findDevelopersByWebsiteId(int websiteId);

  int findWebsiteIdByName(String name);

  int updateWebsite(int websiteId, Website website);

  int deleteWebsite(int websiteId);

}
