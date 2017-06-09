package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by user on 09.06.2017.
 */
public class ContactAddressTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().mainPage();

    if (app.contact().all().size()==0) {
      app.contact().create(new ContactData().withFirstName("John").withLastName("Smith")
              .withAddress("10005 NY 5st ave 123").withPhone("+1234567890")
              .withEmail("johmsmith@yahoo.cpm").withGroup("Test1"), true);
    }

  }

  @Test

  public void testContactAddress() {

    app.goTo().mainPage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm =app.contact().infoFromEditForm(contact);
    assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));

  }
}

