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



      ContactGroups pairs = app.db().contactGroups();
      for (ContactGroupData contact:pairs) {

        System.out.print(contact.getId());
      }



  }



  @Test
  public void testAssimentGroup() {

    Contacts before =app.db().contacts();
    ContactData assimentContact =before.iterator().next();
    app.contact().assiment(assimentContact);
    Contacts after =app.db().contacts();

    assertEquals(after.size(),before.size()-1);
    assertThat(after,equalTo(before));
    verifyContactListInUi();



  }


}
