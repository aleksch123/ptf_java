package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {


    @Test
    public void testContactDeletion() {

        app.getNavigationHalper().goToMainPage();

        if (!app.getContactHelper().isThereAContact()){
            app.getContactHelper().CreateContact(new ContactData("John", "Smith",
                    "St", "Jos", "Mr.",
                    "Global", "10005 NY 5st ave 123",
                    "+1234567890", "johmsmith@yahoo.cpm","Test1"),true);}
        List<ContactData> before =app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size()-1);
        app.getContactHelper().deleteSelectedContact();
        app.getNavigationHalper().CloseAlert();
        app.getNavigationHalper().goToMainPage();
        List<ContactData> after =app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(),before.size()-1);

    }


}