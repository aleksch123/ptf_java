package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {


    @Test
    public void testContactDeletion() {

        app.getNavigationHalper().goToMainPage();
        int before =app.getContactHelper().GetContactCount();
        if (!app.getContactHelper().isThereAContact()){
            app.getContactHelper().CreateContact(new ContactData("John", "Smith",
                    "St", "Jos", "Mr.",
                    "Global", "10005 NY 5st ave 123",
                    "+1234567890", "johmsmith@yahoo.cpm","Test1"),true);}
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();
        app.getNavigationHalper().CloseAlert();
        app.getNavigationHalper().goToMainPage();
        int after =app.getContactHelper().GetContactCount();
        Assert.assertEquals(after,before-1);

    }


}