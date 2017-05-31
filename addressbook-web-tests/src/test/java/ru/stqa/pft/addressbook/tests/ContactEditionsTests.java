package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class ContactEditionsTests extends TestBase {


    @Test
    public void testContactEdition() {

        app.getNavigationHalper().goToMainPage();

        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().CreateContact(new ContactData("John", "Smith",
                    "St", "Jos", "Mr.",
                    "Global", "10005 NY 5st ave 123",
                    "+1234567890", "johmsmith@yahoo.cpm", "Test1"), true);
        }
        List<ContactData> before =app.getContactHelper().getContactList();
        app.getContactHelper().initContactEditions(before.size()-1);
        ContactData contact = new ContactData(before.get(before.size()-1).getId(),"John", "Smith",
                "St", "Jos", "Mr.",
                "Global", "10005 NY 5st ave 123", "+22222222222",
                "johmsmith@gmail.com", null);
        app.getContactHelper().fillUserData(contact, false);
        app.getContactHelper().UpdateContactEdition();
        app.getNavigationHalper().goToMainPage();
        List<ContactData> after =app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(),before.size());
        before.remove(before.size()-1);
        before.add(contact);
        Assert.assertEquals(new HashSet<>(before),new HashSet<>(after));
    }


}