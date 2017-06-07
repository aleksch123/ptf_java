package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.*;


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



        Groups before =app.group().all();
        GroupData editGroup = before.iterator().next();
        GroupData  group = new GroupData()
                .withId(editGroup.getId()).withName("Test1").withHeader("Test2").withFooter("Test3");
        app.group().modify(group);
        Groups after =app.group().all();
            assertEquals(after.size(),before.size());
            assertThat(after,equalTo(before.without(editGroup).withAdded(group)));
    }



}