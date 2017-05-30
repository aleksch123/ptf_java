package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactCreationTests extends TestBase {


    @Test
    public void testContactCreation() {
        if (!app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().CreateGroup(new GroupData("Test1","Test2","Test3"));}
        app.getNavigationHalper().goToMainPage();
        int before =app.getContactHelper().GetContactCount();
        app.getContactHelper().initContactCreations();
        app.getContactHelper().fillUserData(new ContactData("John", "Smith", "St", "Jos", "Mr.",
                "Global", "10005 NY 5st ave 123",
                "+1234567890", "johmsmith@yahoo.cpm","Test1"),true);
        app.getContactHelper().submitUserCreations();
        app.getNavigationHalper().goToMainPage();
        int after =app.getContactHelper().GetContactCount();
        Assert.assertEquals(after,before+1);
    }


}