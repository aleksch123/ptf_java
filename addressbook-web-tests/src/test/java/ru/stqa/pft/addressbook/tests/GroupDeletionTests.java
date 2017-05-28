package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupDeletionTests extends TestBase {

    

    
    @Test
    public void testGroupDeletion() {

        app.getNavigationHalper().goToGroupPage();

        if (!app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().CreateGroup(new GroupData("Test1","Test2","Test3"));
        }
        int before =app.getGroupHelper().GetGroupCount();
        app.getGroupHelper().selectGroup(before-1);
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
        int after =app.getGroupHelper().GetGroupCount();
        Assert.assertEquals(after,before-1);
    }


}
