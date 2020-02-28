package edu.northeastern.cs5200;

import edu.northeastern.cs5200.daos.AddressDao;
import edu.northeastern.cs5200.daos.AddressImpl;
import edu.northeastern.cs5200.daos.DeveloperDao;
import edu.northeastern.cs5200.daos.DeveloperImpl;
import edu.northeastern.cs5200.daos.PageDao;
import edu.northeastern.cs5200.daos.PageImpl;
import edu.northeastern.cs5200.daos.PhoneDao;
import edu.northeastern.cs5200.daos.PhoneImpl;
import edu.northeastern.cs5200.daos.RoleDao;
import edu.northeastern.cs5200.daos.RoleImpl;
import edu.northeastern.cs5200.daos.UserDao;
import edu.northeastern.cs5200.daos.UserImpl;
import edu.northeastern.cs5200.daos.WebsiteDao;
import edu.northeastern.cs5200.daos.WebsiteImpl;
import edu.northeastern.cs5200.daos.WidgetDao;
import edu.northeastern.cs5200.daos.WidgetImpl;
import edu.northeastern.cs5200.models.Address;
import edu.northeastern.cs5200.models.Developer;
import edu.northeastern.cs5200.models.Page;
import edu.northeastern.cs5200.models.Phone;
import edu.northeastern.cs5200.models.User;
import edu.northeastern.cs5200.models.Website;
import edu.northeastern.cs5200.models.Widget;
import java.util.ArrayList;
//import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import org.junit.Test;

public class hw_jdbc_bhosale_anagha {
  DeveloperDao d= new DeveloperImpl();;
  UserDao u = new UserImpl();
  WebsiteDao w = new WebsiteImpl();
  PageDao p = new PageImpl();
  WidgetDao widget = new WidgetImpl();
  RoleDao role = new RoleImpl();
  PhoneDao phone  = new PhoneImpl();
  AddressDao address = new AddressImpl();


  public void insertForAlice(){
    d.createDeveloper(new Developer(12,"4321rewq","Alice",
        "Wonder","alice","alice","alice@wonder.com",null ));
    List<Phone> alicePhones = new ArrayList<Phone>();
    alicePhones.add(new Phone("123-234-3456",true));
    alicePhones.add(new Phone("234-345-4566",false));
    for(int i = 0 ;i<alicePhones.size();i++){
      phone.createPhone(12,alicePhones.get(i));
    }
    List<Address> aliceAddress = new ArrayList<Address>();
    aliceAddress.add(new Address("123 Adam St.",null,"Alton",null,01234,true));
    aliceAddress.add(new Address("234 Birch St.",null,"Boston",null,02345,false));
    for(int i = 0 ;i<aliceAddress.size();i++){
      address.createAddress(12,aliceAddress.get(i));
    }
  }

  public void insertForBob(){
    d.createDeveloper(new Developer(23,"5432trew","Bob",
        "Marley","bob","bob","bob@marley.com",null ));
    List<Phone> bobPhones = new ArrayList<Phone>();
    bobPhones.add(new Phone("345-456-5677",true));
    for(int i = 0 ;i<bobPhones.size();i++){
      phone.createPhone(23,bobPhones.get(i));
    }
    List<Address> bobAddress = new ArrayList<Address>();
    bobAddress.add(new Address("345 Charles St.",null,"Chelms",null,03455,true));
    bobAddress.add(new Address("456 Down St.",null,"Dalton",null,04566,false));
    bobAddress.add(new Address("543 East St.",null,"Everett",null,01112,false));
    for(int i = 0 ;i<bobAddress.size();i++){
      address.createAddress(23,bobAddress.get(i));
    }
  }

  public void insertForCharlie(){
    d.createDeveloper(new Developer(34,"6543ytre","Charles",
        "Garcia","charlie","charlie","chuch@garcia.com",null ));
    List<Phone> charliePhones = new ArrayList<Phone>();
    charliePhones.add(new Phone("321-432-5435",true));
    charliePhones.add(new Phone("432-432-5433",false));
    charliePhones.add(new Phone("543-543-6544",false));
    for(int i = 0 ;i<charliePhones.size();i++){
      phone.createPhone(34,charliePhones.get(i));
    }
    List<Address> charlieAddress = new ArrayList<Address>();
    charlieAddress.add(new Address("654 Frank St.",null,"Foulton",null,04322,true));
    for(int i = 0 ;i<charlieAddress.size();i++){
      address.createAddress(34,charlieAddress.get(i));
    }
  }

  public void insertForDan(){
    u.createUser(new User(45,true,"Dan","Martin",
        "dan","dan","dan@martin.com",null));
  }

  public void insertForEd(){
    u.createUser(new User(56,false,"Ed","Karaz",
        "ed","ed","ed@kar.com",null));
  }

  public void insertInWebsite(){
    w.createWebsiteForDeveloper(12,new Website(123,"Facebook",
        "an online social media and social networking service",null
        ,null,1234234));
    w.createWebsiteForDeveloper(23,new Website(123,"Facebook",
        "an online social media and social networking service",null
        ,null,1234234));
    w.createWebsiteForDeveloper(34,new Website(123,"Facebook",
        "an online social media and social networking service",null
        ,null,1234234));
    w.createWebsiteForDeveloper(12,new Website(234,"Twitter",
        "an online news and social networking service",null
        ,null,4321543));
    w.createWebsiteForDeveloper(23,new Website(234,"Twitter",
        "an online social media and social networking service",null
        ,null,4321543));
    w.createWebsiteForDeveloper(34,new Website(234,"Twitter",
        "an online social media and social networking service",null
        ,null,4321543));
    w.createWebsiteForDeveloper(12,new Website(345,"Wikipedia",
        "a free online encyclopedia",null
        ,null,3456654));
    w.createWebsiteForDeveloper(23,new Website(345,"Wikipedia",
        "a free online encyclopedia",null
        ,null,3456654));
    w.createWebsiteForDeveloper(34,new Website(345,"Wikipedia",
        "a free online encyclopedia",null
        ,null,3456654));
    w.createWebsiteForDeveloper(12,new Website(456,"CNN",
        "an American basic cable and satellite television news channel",null
        ,null,6543345));
    w.createWebsiteForDeveloper(23,new Website(456,"CNN",
        "an American basic cable and satellite television news channel",null
        ,null,6543345));
    w.createWebsiteForDeveloper(34,new Website(456,"CNN",
        "an American basic cable and satellite television news channel",null
        ,null,6543345));
    w.createWebsiteForDeveloper(12,new Website(567,"CNET",
        "an American media website that publishes reviews, news, articles, blogs,"
            + " podcasts and videos on technology and consumer electronics",null
        ,null,5433455));
    w.createWebsiteForDeveloper(23,new Website(567,"CNET",
        "an American media website that publishes reviews, news, articles, blogs,"
            + " podcasts and videos on technology and consumer electronics",null
        ,null,5433455));
    w.createWebsiteForDeveloper(34,new Website(567,"CNET",
        "an American media website that publishes reviews, news, articles, blogs,"
            + " podcasts and videos on technology and consumer electronics",null
        ,null,5433455));
    w.createWebsiteForDeveloper(12,new Website(678,"Gizmodo",
        "a design, technology, science and science fiction website that "
            + "also writes articles on politics",null
        ,null,4322345));
    w.createWebsiteForDeveloper(23,new Website(678,"Gizmodo",
        "a design, technology, science and science fiction website that "
            + "also writes articles on politics",null
        ,null,4322345));
    w.createWebsiteForDeveloper(34,new Website(678,"Gizmodo",
        "a design, technology, science and science fiction website that "
            + "also writes articles on politics",null
        ,null,4322345));
  }

  public void insertPageForWebsite(){
    p.createPageForWebsite(567,new Page(123,"Home","Landing Page",
        java.sql.Date.valueOf("2020-02-27"),java.sql.Date.valueOf("2020-02-27"),123434));
    p.createPageForWebsite(678,new Page(234,"About","Website description",
        java.sql.Date.valueOf("2020-02-27"),java.sql.Date.valueOf("2020-02-27"),234545));
    p.createPageForWebsite(345,new Page(345,"Contact","Addresses, phones, and contact info",
        java.sql.Date.valueOf("2020-02-27"),java.sql.Date.valueOf("2020-02-27"),345656));
    p.createPageForWebsite(456,new Page(456,"Preferences","Where users"
        + " can configure their preferences",
        java.sql.Date.valueOf("2020-02-27"),java.sql.Date.valueOf("2020-02-27"),456776));
    p.createPageForWebsite(567,new Page(567,"Profile","Users can "
        + "configure their personal information",
        java.sql.Date.valueOf("2020-02-27"),java.sql.Date.valueOf("2020-02-27"),567878));
  }

  public void insertWdigetForPage(){
    widget.createWidgetForPage(123,new Widget(1,"head123",0,0,
        null,null,"Welcome",0,2,
        null,null,null,false,false,"heading"));
    widget.createWidgetForPage(234,new Widget(2,"post234",0,0,
        null,null,"<p>Lorem</p>",0,0,
        null,null,null,false,false,"html"));
    widget.createWidgetForPage(345,new Widget(3,"head345",0,0,
        null,null,"Hi",1,2,
        null,null,null,false,false,"heading"));
    widget.createWidgetForPage(345,new Widget(4,"intro456",0,0,
        null,null,"<h1>Hi</h1>",2,0,
        null,null,null,false,false,"html"));
    widget.createWidgetForPage(345,new Widget(5,"image345",50,100,
        null,null,null,3  ,0,
        null,"/img/567.png",null,false,false,"image"));
    widget.createWidgetForPage(456,new Widget(6,"video456",400,300,
        null,null,null,0  ,0,
        null,null,"https://youtu.be/h67VX51QXiQ",false,false,
        "youtube"));
  }

  public void assignWebsiteRole(){
    role.assignWebsiteRole(12,123,1);
    role.assignWebsiteRole(23,123,4);
    role.assignWebsiteRole(34,123,2);
    role.assignWebsiteRole(23,234,1);
    role.assignWebsiteRole(34,234,4);
    role.assignWebsiteRole(12,234,2);
    role.assignWebsiteRole(34,345,1);
    role.assignWebsiteRole(12,345,4);
    role.assignWebsiteRole(23,345,2);
    role.assignWebsiteRole(12,456,1);
    role.assignWebsiteRole(23,456,4);
    role.assignWebsiteRole(34,456,2);
    role.assignWebsiteRole(23,567,1);
    role.assignWebsiteRole(34,567,4);
    role.assignWebsiteRole(12,567,2);
    role.assignWebsiteRole(34,678,1);
    role.assignWebsiteRole(12,678,4);
    role.assignWebsiteRole(23,678,2);
  }

  public void assignPageRole(){
    role.assignPageRole(12,123,4);
    role.assignPageRole(23,123,5);
    role.assignPageRole(34,123,3);
    role.assignPageRole(23,234,4);
    role.assignPageRole(34,234,5);
    role.assignPageRole(12,234,3);
    role.assignPageRole(34,345,4);
    role.assignPageRole(12,345,5);
    role.assignPageRole(23,345,3);
    role.assignPageRole(12,456,4);
    role.assignPageRole(23,456,5);
    role.assignPageRole(34,456,3);
    role.assignPageRole(23,567,4);
    role.assignPageRole(34,567,5);
    role.assignPageRole(12,567,3);
  }


  public void deleteCNETWebsite(){
    List<Page> pagelist = null;
    int id = w.findWebsiteIdByName("CNET");
      Website website = w.findWebsiteById(id);
      List<Integer> developer_id = w.findDevelopersByWebsiteId(id);
      for(int a = 0;a< developer_id.size();a++) {
        pagelist = (List<Page>) p.findPagesForWebsite(id);
        for (int i = 0; i < pagelist.size(); i++) {

          List<Widget> widgetlist = (List<Widget>) widget
              .findWidgetsForPage(pagelist.get(i).getId());
          for (int j = 0; j < widgetlist.size(); j++) {
            widget.deleteWidget(widgetlist.get(i).getId());
          }

          int role_id = role.findRoleIdForPage(developer_id.get(a),pagelist.get(i).getId());
          role.deletePageRole(developer_id.get(a), pagelist.get(i).getId(), role_id);
          p.deletePage(pagelist.get(i).getId());
        }
        int role_id_w = role.findRoleIdForWebsite(developer_id.get(a),id);
        role.deleteWebsiteRole(developer_id.get(a),id,role_id_w);

      }
    w.deleteWebsite(id);

  }



  public void deleteAlicePrimaryAddress(){
    Developer developer = d.findDeveloperByUsername("alice");
    for(int i = 0; i < developer.getAddress().size();i++){
      if(developer.getAddress().get(i).getIsprimary() == true){
        address.deleteAddress(developer.getId(),developer.getAddress().get(i));
      }
    }

  }

  public void deleteLastWidgetInContactPage(){
    Page page = p.findPageByPageName("Contact");
    List<Widget> w1 = (List<Widget>) widget.findWidgetsForPage(page.getId());
    int maxseq=Integer.MIN_VALUE;
    int index = -1;
    for(int i = 0;i < w1.size();i++){
      if(w1.get(i).getSequence()>maxseq){
        maxseq = w1.get(i).getSequence();
        index =i;
        System.out.println(w1.get(i).getSequence());
        System.out.println(index);
      }
    }
    widget.deleteWidget(w1.get(index).getId());

  }

  public void deleteLastUpdatedPageInWikipedia(){
    int id  = w.findWebsiteIdByName("Wikipedia");
    List<Page> page = (List<Page>) p.findPagesForWebsite(id);
    Date lastupdated =new Date(0000,0,00);
    page.sort(new Comparator<Page>() {
      @Override
      public int compare(Page o1, Page o2) {
        if(o1.getUpdated().getYear()>o2.getUpdated().getYear())
        return 1;
        else if(o1.getUpdated().getYear()==o2.getUpdated().getYear()){
          if(o1.getUpdated().getMonth()>o2.getUpdated().getMonth()){
            return 1 ;
          }
          else if(o1.getUpdated().getMonth()==o2.getUpdated().getMonth()){
            if(o1.getUpdated().getDate()>o2.getUpdated().getDate()){
              return 1;
            }
            else if(o1.getUpdated().getDate()==o2.getUpdated().getDate()){
              if(o1.getUpdated().getTime()>o2.getUpdated().getTime()){
                return 1;
              }
              else return -1;
            }
            else return -1;
          }
          else return -1;
        }
        else return -1;
      }
    });
    System.out.println(page.get(page.size()-1).getId());
    p.deletePage(page.get(page.size()-1).getId());
  }

  public void updateCharliephone(String newPhone){

    Developer developer = d.findDeveloperByUsername("charlie");
    for(int i =0 ;i< developer.getPhones().size();i++){
      if (developer.getPhones().get(i).getIsprimary() == true){
        developer.getPhones().get(i).setPhone(newPhone);
      }
    }
    d.updateDeveloper(developer.getId(),developer);
    //p.updatePage();
  }

  public void updateCNETPage(){

    int id = w.findWebsiteIdByName("CNET");
    List<Page> page= (List)p.findPagesForWebsite(id);
    for(int i =0 ;i< page.size();i++){
      page.get(i).setTitle("CNET - "+page.get(i).getTitle());
      p.updatePage(page.get(i).getId(),page.get(i));
    }

  }

  public void swapCharlieAndBobsRole(){
    int id = w.findWebsiteIdByName("CNET");
    List<Page> page= (List)p.findPagesForWebsite(id);
    int pageid=0;
    for(int i =0 ;i< page.size();i++){
      if(page.get(i).getTitle().equals("CNET - Home")){
        pageid = page.get(i).getId();
      }
    }
    if(pageid!=0) {
      Developer charlie = d.findDeveloperByUsername("charlie");
      Developer bob = d.findDeveloperByUsername("bob");
      int charliesRole = role.findRoleIdForPage(charlie.getId(), pageid);
      int bobRole = role.findRoleIdForPage(bob.getId(), pageid);

      role.deletePageRole(charlie.getId(), pageid, charliesRole);
      role.deletePageRole(bob.getId(), pageid, bobRole);

      role.assignPageRole(charlie.getId(), pageid, bobRole);
      role.assignPageRole(bob.getId(), pageid, charliesRole);
    }
    else{
      System.out.println("No Page found");
    }
  }

  public void changeWidgetOrder(){
    Widget widget_head345 = widget.findWidgetbyName("head345");
    List<Widget> widgetlist = (List<Widget>) widget.findWidgetsForPage(widget_head345.getPageid());
    for(int i =0 ;i < widgetlist.size();i++){
      int upseq = ((widgetlist.get(i).getSequence()+1)%3)+1;
      widgetlist.get(i).setSequence(upseq);
      widget.updateWidget(widgetlist.get(i).getId(),widgetlist.get(i));
    }

  }
}
