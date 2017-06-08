package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Алексей on 08.06.2017.
 */
public class ContactPhoneTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().mainPage();

        if (app.contact().all().size()==0) {
            app.contact().create(new ContactData().withFirstName("John").withLastName("Smith")
                    .withAddress("10005 NY 5st ave 123").withHomePhone("+1234567890")
                    .withMobilePhone("222222222222").withWorkPhone("44444444")
                    .withEmail("johmsmith@yahoo.cpm").withGroup("Test1"), true);
        }

    }
    @Test
    public void testContactPhones(){
        app.goTo().mainPage();
        ContactData contact =app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm =app.contact().infoFromEditForm(contact);
        assertThat(contact.getHomePhone(), equalTo(cleaned(contactInfoFromEditForm.getHomePhone())));
        assertThat(contact.getMobilePhone(), equalTo(cleaned(contactInfoFromEditForm.getMobilePhone())));
        assertThat(contact.getWorkPhone(), equalTo(cleaned(contactInfoFromEditForm.getWorkPhone())));

    }

    public String cleaned(String phone){
        return phone.replaceAll("\\s","").replaceAll("[-()]","");
    }

}
