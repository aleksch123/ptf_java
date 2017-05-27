package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactEditionsTests extends TestBase {


    @Test
    public void testContactEdition() {

        app.getNavigationHalper().goToMainPage();
        if (!app.getContactHelper().isThereAContact()){
            app.getContactHelper().CreateContact(new ContactData("John", "Smith", "St", "Jos", "Mr.",
                    "Global", "10005 NY 5st ave 123",
                    "+1234567890", "johmsmith@yahoo.cpm","Test1"),true);}
        app.getContactHelper().initContactEditions();
        app.getContactHelper().fillUserData(new ContactData("John", "Smith", "St", "Jos", "Mr.",
                "Global", "10005 NY 5st ave 123", "+22222222222",
                "johmsmith@gmail.com",null),false);
        app.getContactHelper().UpdateContactEdition();
        app.getNavigationHalper().goToHomePage();
    }


}