package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

public class GroupDeletionTests extends TestBase {

    @BeforeMethod

    public void ensurePrecondition(){
        app.goTo().groupPage();

        if (app.db().groups().size()==0){

            app.group().CreateGroup(new GroupData().withName("Test1").withHeader("Test2").withFooter("Test3"));
        }

    }

    @Test
    public void testGroupDeletion() {

        Groups before =app.db().groups();
        GroupData deletedGroup = before.iterator().next();
        app.group().delete(deletedGroup);
        Groups after =app.db().groups();
        assertEquals(after.size(),before.size()-1);
        assertThat(after,equalTo(before.without(deletedGroup)));

    }




}
