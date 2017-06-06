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
        if (app.group().all().size()==0){
            app.group().CreateGroup(new GroupData().withName("Test1").withHeader("Test2").withFooter("Test3"));
        }
        app.goTo().mainPage();

    }


    @Test
    public void testContactCreation() {

        List<ContactData> before =app.contact().list();
        ContactData contact = new ContactData().withFirstName("John").withLastName("Smith")
                .withAddress("10005 NY 5st ave 123").withPhone("+1234567890")
                .withEmail("johmsmith@yahoo.cpm").withGroup("Test1");
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