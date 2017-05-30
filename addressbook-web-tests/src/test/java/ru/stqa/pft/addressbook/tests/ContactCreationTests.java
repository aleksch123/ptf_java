package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class ContactCreationTests extends TestBase {


    @Test
    public void testContactCreation() {
        if (!app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().CreateGroup(new GroupData("Test1","Test2","Test3"));}
        app.getNavigationHalper().goToMainPage();
        List<ContactData> before =app.getContactHelper().getContactList();
        app.getContactHelper().initContactCreations();
        app.getContactHelper().fillUserData(new ContactData("John", "Smith", "St", "Jos", "Mr.",
                "Global", "10005 NY 5st ave 123",
                "+1234567890", "johmsmith@yahoo.cpm","Test1"),true);
        app.getContactHelper().submitUserCreations();
        app.getNavigationHalper().goToMainPage();
        List<ContactData> after =app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(),before.size()+1);
    }


}