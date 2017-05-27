package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactEditionsTests extends TestBase {


    @Test
    public void testContactEdition() {

        app.getNavigationHalper().goToMainPage();
        app.getContactHelper().initContactEditions();
        app.getContactHelper().fillUserData(new ContactData("John", "Smith", "St", "Jos", "Mr.",
                "Global", "10005 NY 5st ave 123", "+22222222222", "johmsmith@gmail.com",null));
        app.getContactHelper().UpdateContactEdition();
        app.getNavigationHalper().goToHomePage();
    }


}