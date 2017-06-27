package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().mainPage();

        if (app.db().contacts().size()==0){
            app.contact().create(new ContactData().withFirstName("John").withLastName("Smith")
                    .withAddress("10005 NY 5st ave 123").withPhone("+1234567890")
                    .withEmail("johmsmith@yahoo.cpm"),true);}

    }


    @Test
    public void testContactDeletion() {

        Contacts before =app.db().contacts();
        ContactData deletedContact =before.iterator().next();
        app.contact().delete(deletedContact);
        Contacts after =app.db().contacts();

        assertEquals(after.size(),before.size()-1);
        assertThat(after,equalTo(before.without(deletedContact)));
        verifyContactListInUi();



    }




}