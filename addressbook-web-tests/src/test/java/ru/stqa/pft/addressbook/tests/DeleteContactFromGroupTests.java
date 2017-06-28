package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class DeleteContactFromGroupTests extends TestBase{
    @BeforeMethod
    public void ensurePreconditions(){

        app.goTo().groupPage();
        if (app.db().groups().size()==0){
            app.group().CreateGroup(new GroupData().withName("Test1").withHeader("Test2").withFooter("Test3"));
        }
        app.goTo().mainPage();
        Groups groups =app.db().groups();
        if (app.db().contacts().size()==0){
            app.contact().create(new ContactData().withFirstName("John").withLastName("Smith")
                    .withAddress("10005 NY 5st ave 123").withPhone("+1234567890")
                    .withEmail("johmsmith@yahoo.cpm").inGroup(groups.iterator().next()),true);}
         else {
            ContactData contact =app.db().contacts().iterator().next();
            if (contact.getGroups().size()==0){
              contact.inGroup(groups.iterator().next());
            }

        }
    }
    @Test
     public void testDeleteContactFromGroup(){

        ContactData contact =app.db().contacts().iterator().next();
        Groups before = contact.getGroups();
        GroupData deletedGroup =before.iterator().next();
        app.contact().deleteFromGroup(contact,deletedGroup);
        Groups after=app.db().contactById(contact.getId()).getGroups();
        assertThat(after,equalTo(before.without(deletedGroup)));




        }
    }
