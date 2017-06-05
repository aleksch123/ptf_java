package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;


public class GroupEditionsTests extends TestBase {

@BeforeMethod

    public void ensurePrecondition(){
     app.goTo().groupPage();

     if (app.group().list().size()==0){
      app.group().CreateGroup(new GroupData("Test1","Test2","Test3"));
  }

}

@Test
    public void testGroupCreation() {



        List<GroupData> before =app.group().list();
        int index = before.size()-1;
        GroupData  group = new GroupData(before.get(index).getId(),"EditTest2", "EditTest2", "EditTest3");
        app.group().modify(index, group);
        List<GroupData> after =app.group().list();
        Assert.assertEquals(after.size(),before.size());
        before.remove(index);
        before.add(group);
        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(),g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);
    }



}