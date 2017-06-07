package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.*;

public class ContactDeletionTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().mainPage();

        if (app.contact().all().size()==0){
            app.contact().create(new ContactData().withFirstName("John").withLastName("Smith")
                    .withAddress("10005 NY 5st ave 123").withPhone("+1234567890")
                    .withEmail("johmsmith@yahoo.cpm").withGroup("Test1"),true);}

    }


    @Test
    public void testContactDeletion() {

        Contacts before =app.contact().all();
        ContactData deletedContact =before.iterator().next();
        app.contact().delete(deletedContact);
        Contacts after =app.contact().all();

        assertEquals(after.size(),before.size()-1);
        assertThat(after,equalTo(before.without(deletedContact)));



    }




}