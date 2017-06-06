package ru.stqa.pft.addressbook.tests;


import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {

        GroupData  group = new GroupData().withName("Тест1");
        app.goTo().groupPage();
        Set<GroupData> before =app.group().all();
        app.group().create(group);
        Set<GroupData> after =app.group().all();

        assertThat(after.size(),equalTo(before.size()+1));

        group.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt());
        before.add(group);

        //assertThat(after, equalTo(before.withAdded(group)));
    }


}
