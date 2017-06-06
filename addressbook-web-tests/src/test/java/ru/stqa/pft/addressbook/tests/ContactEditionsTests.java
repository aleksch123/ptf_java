package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactEditionsTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().mainPage();

        if (app.contact().list().size()==0) {
            app.contact().create(new ContactData().withFirstName("John").withLastName("Smith")
                    .withAddress("10005 NY 5st ave 123").withPhone("+1234567890")
                    .withEmail("johmsmith@yahoo.cpm").withGroup("Test1"), true);
        }

    }


    @Test
    public void testContactEdition() {


        Set<ContactData> before =app.contact().all();
        ContactData editedContact =before.iterator().next();
        ContactData contact = new ContactData().withId(editedContact.getId()).withFirstName("John").withLastName("Smith")
                .withAddress("10005 NY 5st ave 123").withPhone("+1234567890")
                .withEmail("johmsmith@yahoo.com");
        app.contact().edit(contact);
        Set<ContactData> after =app.contact().all();
        Assert.assertEquals(after.size(),before.size());
        before.remove(editedContact);
        before.add(contact);

        Assert.assertEquals(before,after);
    }




}