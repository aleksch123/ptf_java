package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().mainPage();

        if (app.contact().list().size()==0){
            app.contact().create(new ContactData().withFirstName("John").withLastName("Smith")
                    .withAddress("10005 NY 5st ave 123").withPhone("+1234567890")
                    .withEmail("johmsmith@yahoo.cpm").withGroup("Test1"),true);}

    }


    @Test
    public void testContactDeletion() {

        List<ContactData> before =app.contact().list();
        int index = before.size()-1;
        app.contact().delete(index);
        List<ContactData> after =app.contact().list();
        Assert.assertEquals(after.size(),index);
        before.remove(index);
        Assert.assertEquals(before,after);



    }




}