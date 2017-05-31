package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;


public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {


        app.getNavigationHalper().goToGroupPage();
        List<GroupData> before =app.getGroupHelper().getGroupList();

        app.getGroupHelper().initGroupCreation();
        GroupData  group = new GroupData("Test1", "Test2", "Test3");
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after =app.getGroupHelper().getGroupList();

        Assert.assertEquals(after.size(),before.size()+1);

        before.add(group);

        int max=0;
        for (GroupData g:after){
            if(g.getId()>max){
                max=g.getId();
            }
        }
        group.setId(max);
        Assert.assertEquals(new HashSet<>(before),new HashSet<>(after));
    }

}
