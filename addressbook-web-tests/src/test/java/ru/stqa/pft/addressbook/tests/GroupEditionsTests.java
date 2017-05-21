package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;


public class GroupEditionsTests extends TestBase {

    @Test
    public void testGroupCreation() {


        app.getNavigationHalper().goToGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupEdition();
        app.getGroupHelper().fillGroupForm(new GroupData("EditTest2", "EditTest2", "EditTest3"));
        app.getGroupHelper().UpdateGroupEdition();
        app.getGroupHelper().returnToGroupPage();
    }

}