package ru.stqa.pft.addressbook.tests;

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

   /* app.goTo().groupPage();
    if (app.db().groups().size()==0){
      app.group().CreateGroup(new GroupData().withName("Test1").withHeader("Test2").withFooter("Test3"));
    }

    app.goTo().mainPage();
    if (app.db().contacts().size()==0){
      app.contact().create(new ContactData().withFirstName("John").withLastName("Smith")
              .withAddress("10005 NY 5st ave 123").withPhone("+1234567890")
              .withEmail("johmsmith@yahoo.cpm").withGroup("Test1"),true);} */







  }



  @Test
  public void testAssimentGroup() {
    Groups existedGroups =app.db().groups();
    Contacts before =app.db().contacts();
    while(before.iterator().hasNext()) {
      ContactData editedContact = before.iterator().next();
      Groups beforeAssimentGroups = editedContact.getGroups();
      while (existedGroups.iterator().hasNext()) {
        GroupData group = existedGroups.iterator().next();
        if (!beforeAssimentGroups.contains(group)) {

          app.contact().assiment(editedContact, group);
        }
      }
    }




  }


}
