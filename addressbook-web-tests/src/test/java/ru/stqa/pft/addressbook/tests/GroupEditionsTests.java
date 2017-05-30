package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;


public class GroupEditionsTests extends TestBase {

    @Test
    public void testGroupCreation() {


        app.getNavigationHalper().goToGroupPage();

        if (!app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().CreateGroup(new GroupData("Test1","Test2","Test3"));
        }
        List<GroupData> before =app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size()-1);
        app.getGroupHelper().initGroupEdition();
        app.getGroupHelper().fillGroupForm(new GroupData("EditTest2", "EditTest2", "EditTest3"));
        app.getGroupHelper().UpdateGroupEdition();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after =app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(),before.size());
    }

}