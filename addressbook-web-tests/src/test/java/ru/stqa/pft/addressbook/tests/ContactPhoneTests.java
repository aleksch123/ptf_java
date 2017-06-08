package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Алексей on 08.06.2017.
 */
public class ContactPhoneTests extends TestBase {
    @Test
    public void testContactPhones(){
        app.goTo().mainPage();
        ContactData contact =app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm =app.contact().infoFromEditForm(contact);
        assertThat(contact.getHomePhone(), equalTo(contactInfoFromEditForm.getHomePhone()));
        assertThat(contact.getMobilePhone(), equalTo(contactInfoFromEditForm.getMobilePhone()));
        assertThat(contact.getWorkPhone(), equalTo(contactInfoFromEditForm.getWorkPhone()));

    }

}
