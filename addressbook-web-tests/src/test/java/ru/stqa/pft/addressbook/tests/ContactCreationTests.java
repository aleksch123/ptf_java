package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {
    @BeforeMethod

    public void ensurePreconditions(){
        if (app.group().list().size()==0){
            app.group().CreateGroup(new GroupData("Test1","Test2","Test3"));}
        app.goTo().mainPage();

    }


    @Test
    public void testContactCreation() {

        List<ContactData> before =app.contact().list();
        ContactData contact = new ContactData("John", "Smith", "St", "Jos", "Mr.",
                "Global", "10005 NY 5st ave 123",
                "+1234567890", "johmsmith@yahoo.cpm","Test1");
        app.contact().create(contact,true);
        List<ContactData> after =app.contact().list();
        Assert.assertEquals(after.size(),before.size()+1);

        before.add(contact);

        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(),g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);
    }




}