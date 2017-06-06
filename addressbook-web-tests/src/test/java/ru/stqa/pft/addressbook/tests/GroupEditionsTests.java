package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;


public class GroupEditionsTests extends TestBase {

@BeforeMethod

    public void ensurePrecondition(){
     app.goTo().groupPage();

     if (app.group().all().size()==0){
      app.group().CreateGroup(new GroupData().withName("Test1"));
  }

}

@Test
    public void testGroupCreation() {



        Set<GroupData> before =app.group().all();
        GroupData editGroup = before.iterator().next();
        GroupData  group = new GroupData()
                .withId(editGroup.getId()).withName("Test1").withHeader("Test2").withFooter("Test3");
        app.group().modify(group);
        Set<GroupData> after =app.group().all();
        Assert.assertEquals(after.size(),before.size());
        before.remove(editGroup);
        before.add(group);

        Assert.assertEquals(before,after);
    }



}