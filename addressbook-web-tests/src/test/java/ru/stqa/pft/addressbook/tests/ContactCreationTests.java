package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

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

        Set<ContactData> before =app.contact().all();
        ContactData contact = new ContactData().withFirstName("John").withLastName("Smith")
                .withAddress("10005 NY 5st ave 123").withPhone("+1234567890")
                .withEmail("johmsmith@yahoo.cpm").withGroup("Test1");
        app.contact().create(contact,true);
        Set<ContactData> after =app.contact().all();
        Assert.assertEquals(after.size(),before.size()+1);

        contact.withId(after.stream().mapToInt((c)->c.getId()).max().getAsInt());
        before.add(contact);
        Assert.assertEquals(before,after);
    }




}