package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by user on 09.06.2017.
 */
public class ContactEmailsTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().mainPage();

    if (app.contact().all().size()==0) {
      app.contact().create(new ContactData().withFirstName("John").withLastName("Smith")
              .withAddress("10005 NY 5st ave 123").withPhone("+1234567890")
              .withEmail("johmsmith@yahoo.cpm").withEmail2("john@mail.com").withEmail3("john@gmail.com"), true);
    }

  }


  @Test
  public void testContactEmails() {
    app.goTo().mainPage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm =app.contact().infoFromEditForm(contact);
    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));

  }
  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmail(),contact.getEmail2(),contact.getEmail3())
            .stream().filter((s)->! s.equals(""))
            .collect(Collectors.joining("\n"));
  }
}
