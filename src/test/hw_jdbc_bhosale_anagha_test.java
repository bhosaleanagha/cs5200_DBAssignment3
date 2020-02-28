import edu.northeastern.cs5200.hw_jdbc_bhosale_anagha;
import org.junit.Test;

public class hw_jdbc_bhosale_anagha_test {

  hw_jdbc_bhosale_anagha instance = new hw_jdbc_bhosale_anagha();

  @Test
  public void insertInDeveloper(){
    instance.insertForAlice();
    instance.insertForBob();
    instance.insertForCharlie();
    instance.insertForDan();
    instance.insertForEd();
  }

  @Test
  public void insertForWebsite(){
    instance.insertInWebsite();
  }

  @Test
  public void insertPageForWebsite(){
    instance.insertPageForWebsite();
  }

  @Test
  public void insertWidgetForPage(){
    instance.insertWdigetForPage();
  }

  @Test
  public void assignWebsiteRole(){
    instance.assignWebsiteRole();
  }

  @Test
  public void assignPageRole(){
    instance.assignPageRole();
  }

  @Test
  public void updateDeveloper(){
    instance.updateCharliephone("333-444-5555");
  }

  @Test
  public void updateWidget(){
    instance.changeWidgetOrder();
  }

  @Test
  public void updatePage(){
    instance.updateCNETPage();
  }

  @Test
  public void updateRole(){
    instance.swapCharlieAndBobsRole();
  }

  @Test
  public void deleteDeveloper(){
    instance.deleteAlicePrimaryAddress();
  }

  @Test
  public void deleteWidget(){
    instance.deleteLastWidgetInContactPage();
  }

  @Test
  public void deletePage(){
    instance.deleteLastUpdatedPageInWikipedia();
  }

  @Test
  public void deleteWebsite(){
    instance.deleteCNETWebsite();
  }
}
