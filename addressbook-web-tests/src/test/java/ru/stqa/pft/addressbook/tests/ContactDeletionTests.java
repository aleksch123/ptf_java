package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {


    @Test
    public void testContactDeletion() {

        app.getNavigationHalper().goToMainPage();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();
        app.getNavigationHalper().CloseAlert();
        app.getNavigationHalper().goToMainPage();

    }


}