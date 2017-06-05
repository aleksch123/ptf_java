package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactEditionsTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().mainPage();

        if (app.contact().list().size()==0) {
            app.contact().create(new ContactData("John", "Smith",
                    "St", "Jos", "Mr.",
                    "Global", "10005 NY 5st ave 123",
                    "+1234567890", "johmsmith@yahoo.cpm", "Test1"), true);
        }

    }


    @Test
    public void testContactEdition() {


        List<ContactData> before =app.contact().list();
        int index = before.size()-1;
        ContactData contact = new ContactData(before.get(index).getId(),"John", "Smith",
                "St", "Jos", "Mr.",
                "Global", "10005 NY 5st ave 123", "+22222222222",
                "johmsmith@gmail.com", null);
        app.contact().modify(index, contact);
        List<ContactData> after =app.contact().list();
        Assert.assertEquals(after.size(),before.size());
        before.remove(index);
        before.add(contact);
        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(),g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);
    }




}