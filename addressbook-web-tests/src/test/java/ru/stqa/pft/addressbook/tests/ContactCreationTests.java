package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

public class ContactCreationTests extends TestBase {


    @Test
    public void testContactCreation() {

        app.getContactHelper().initContactCreations();
        app.getContactHelper().fillUserData(new UserData("John", "Smith", "St", "Jos", "Mr.",
                "Global", "10005 NY 5st ave 123", "+1234567890", "johmsmith@yahoo.cpm"));
        app.getContactHelper().submitUserCreations();
        app.getNavigationHalper().goToHomePage();
    }


}