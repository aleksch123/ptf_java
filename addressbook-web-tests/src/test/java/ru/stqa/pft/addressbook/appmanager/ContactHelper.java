package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.appmanager.NavigationHelper;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Алексей on 20.05.2017.
 */
public class ContactHelper extends HelperBase{


    public ContactHelper(WebDriver wd) {

        super(wd);
    }

    public void submitUserCreations() {
        click(By.name("submit"));
    }

    public void fillUserData(ContactData userData, boolean creation) {
        type(By.name("firstname"), userData.getFirstName());
        type(By.name("lastname"), userData.getLastName());
        type(By.name("middlename"), userData.getMiddleName());
        type(By.name("nickname"), userData.getNickName());
        type(By.name("title"), userData.getTitle());
        type(By.name("company"), userData.getCompany());
        type(By.name("address"), userData.getAddress());
        type(By.name("home"), userData.getPhone());
        type(By.name("email"), userData.getEmail());
        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(userData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }

            }

    public void initContactCreations() {
        click(By.linkText("add new"));
    }
    public void initContactEditions(int index){
        wd.findElements(By.xpath("//table[@id='maintable']/tbody/tr/td[8]/a/img")).get(index).click();
        }
    public void UpdateContactEdition() {
        click(By.name("update"));
    }
    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
       }

    public void deleteSelectedContact() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public boolean isThereAContact() {
        return isElementPresent(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public void CreateContact(ContactData contact, boolean b) {
        initContactCreations();
        fillUserData(contact,true);
        submitUserCreations();


    }

    public int GetContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements =wd.findElements(By.name("entry"));
        for (int i=0;i<elements.size();i++) {


            String LastName =elements.get(i).findElement(By.xpath("//table[@id='maintable']/tbody/tr["+(i+2)+"]/td[2]")).getText();
            String Name =elements.get(i).findElement(By.xpath("//table[@id='maintable']/tbody/tr["+(i+2)+"]/td[3]")).getText();
            String Address =elements.get(i).findElement(By.xpath("//table[@id='maintable']/tbody/tr["+(i+2)+"]/td[4]")).getText();
            String Email =elements.get(i).findElement(By.xpath("//table[@id='maintable']/tbody/tr["+(i+2)+"]/td[5]")).getText();
            String Phone =elements.get(i).findElement(By.xpath("//table[@id='maintable']/tbody/tr["+(i+2)+"]/td[6]")).getText();
            int id = Integer.parseInt(elements.get(i).findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact = new ContactData(id,Name,LastName,null,null,
                    null,null,Address, Phone,Email,null);
            contacts.add(contact);

        }


        return contacts;

    }
}
