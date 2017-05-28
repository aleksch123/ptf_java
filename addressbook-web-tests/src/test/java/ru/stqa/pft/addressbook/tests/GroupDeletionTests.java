package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupDeletionTests extends TestBase {

    

    
    @Test
    public void testGroupDeletion() {

        app.getNavigationHalper().goToGroupPage();
        int before =app.getGroupHelper().GetGroupCount();
        if (!app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().CreateGroup(new GroupData("Test1","Test2","Test3"));
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
        int after =app.getGroupHelper().GetGroupCount();
        Assert.assertEquals(after,before-1);
    }


}
