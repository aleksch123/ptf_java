package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

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

        Contacts before =app.contact().all();
        ContactData contact = new ContactData().withFirstName("John").withLastName("Smith")
                .withAddress("10005 NY 5st ave 123").withPhone("+1234567890")
                .withEmail("johmsmith@yahoo.cpm").withGroup("Test1");
        app.contact().create(contact,true);
        Contacts after =app.contact().all();
        assertEquals(after.size(),before.size()+1);
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));
    }




}