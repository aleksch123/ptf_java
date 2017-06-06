package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Алексей on 20.05.2017.
 */
public class GroupHelper extends HelperBase{

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupDate) {
        type(By.name("group_name"), groupDate.getName());
        type(By.name("group_header"), groupDate.getHeader());
        type(By.name("group_footer"), groupDate.getFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }
    public void initGroupEdition() {
        click(By.name("edit"));
    }
    public void UpdateGroupEdition() {
        click(By.name("update"));
    }
    public void deleteSelectedGroups() {
        click(By.name("delete"));
    }



    public void selectGroupById(int id) {
        wd.findElement(By.cssSelector("input[value='"+id+"']")).click();

    }
    public void CreateGroup(GroupData group) {

        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        returnToGroupPage();


    }

    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public int GetGroupCount() {
        return wd.findElements(By.name("selected[]")).size();
    }


    public Set<GroupData> all() {
        Set<GroupData> groups = new HashSet<GroupData>();
        List<WebElement> elements =wd.findElements(By.cssSelector("span.group"));
        for (WebElement element: elements){
            String name =element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            GroupData group = new GroupData().withId(id).withName(name);
            groups.add(group);
        }
        return groups;
    }
    public void modify( GroupData group) {
        selectGroupById(group.getId());
        initGroupEdition();
        fillGroupForm(group);
        UpdateGroupEdition();
        returnToGroupPage();
    }

    public void create(GroupData group) {
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        returnToGroupPage();
    }


    public void delete(GroupData group) {
        selectGroupById(group.getId());
        deleteSelectedGroups();
        returnToGroupPage();

    }
}
