package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

/**
 * Created by user on 23.06.2017.
 */
public class AssimentGroupTests extends TestBase{
  @BeforeMethod
  public void ensurePreconditions(){

    app.goTo().groupPage();
    if (app.db().groups().size()==0){
      app.group().CreateGroup(new GroupData().withName("Test1").withHeader("Test2").withFooter("Test3"));
    }
    app.goTo().mainPage();
    Groups groups =app.db().groups();
    if (app.db().contacts().size()==0){
      app.contact().create(new ContactData().withFirstName("John").withLastName("Smith")
              .withAddress("10005 NY 5st ave 123").withPhone("+1234567890")
              .withEmail("johmsmith@yahoo.cpm").inGroup(groups.iterator().next()),true);}
  }
  @Test
  public void testAssimentGroup() {
    int contactId = 0;
    boolean completed =false;
    Groups beforeAssimentGroups =null;
    Groups beforeWithAddedGroups=null;
    Groups existedGroups =app.db().groups();
    Contacts contacts =app.db().contacts();
    
    for(ContactData editedContact:contacts) {
      beforeAssimentGroups=editedContact.getGroups();
      GroupData newGroup =app.contact().GetGroupToAssiment(existedGroups,editedContact);
      if (newGroup!=null){
          app.contact().assiment(editedContact, newGroup);
          contactId=editedContact.getId();
          beforeWithAddedGroups =beforeAssimentGroups.withAdded(newGroup);
          completed=true;
          break;
        }
      }
    if(!completed){
      app.goTo().groupPage();
      app.group().CreateGroup(new GroupData().withName("Test10").withHeader("Test2").withFooter("Test3"));
      Groups extendedGroups =app.db().groups();
      GroupData group = extendedGroups.stream().max((g1, g2) -> Integer.compare(g1.getId(), g2.getId())).get();
      ContactData contact =app.db().contacts().iterator().next();
      contactId=contact.getId();
      app.contact().assiment(contact, group);
      beforeWithAddedGroups=beforeAssimentGroups.withAdded(group);

    }
    Groups groupAfter=app.db().contactById(contactId).getGroups();

    assertThat(groupAfter, CoreMatchers.equalTo(beforeWithAddedGroups));
  }


}
