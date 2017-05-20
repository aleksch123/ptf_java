package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

public class UserCreationTests extends TestBase {


    @Test
    public void UserCreationTests() {

        app.initUserCreations();
        app.fillUserData(new UserData("John", "Smith", "St", "Jos", "Mr.",
                "Global", "10005 NY 5st ave 123", "+1234567890", "johmsmith@yahoo.cpm"));
        app.submitUserCreations();
        app.goToHomePage();
    }


}