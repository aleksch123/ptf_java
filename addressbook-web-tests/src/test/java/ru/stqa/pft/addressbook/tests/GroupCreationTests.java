package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;


public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {


        app.goToGroupPage();
        app.initGroupCreation();
        app.fillGroupForm(new GroupData("Test1", "Test2", "Test3"));
        app.submitGroupCreation();
        app.returnToGroupPage();
    }

}
