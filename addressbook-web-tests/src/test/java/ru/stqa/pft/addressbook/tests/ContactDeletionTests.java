package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().goToMainPage();

        if (!app.getContactHelper().isThereAContact()){
            app.getContactHelper().CreateContact(new ContactData("John", "Smith",
                    "St", "Jos", "Mr.",
                    "Global", "10005 NY 5st ave 123",
                    "+1234567890", "johmsmith@yahoo.cpm","Test1"),true);}

    }


    @Test
    public void testContactDeletion() {

        List<ContactData> before =app.getContactHelper().getContactList();
        int index = before.size()-1;
        app.getContactHelper().deletContact(index);
        List<ContactData> after =app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(),index);
        before.remove(index);
        Assert.assertEquals(before,after);



    }




}