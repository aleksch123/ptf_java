package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;


import java.util.ArrayList;
import java.util.List;

import static ru.stqa.pft.addressbook.tests.TestBase.app;


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
    public void modifyContact(int index, ContactData contact) {
        initContactEditions(index);
        fillUserData(contact, false);
        UpdateContactEdition();
        goToMainPage();
    }
    public void deletContact(int index) {
        selectContact(index);
        deleteSelectedContact();
        app.goTo().CloseAlert();
        app.goTo().goToMainPage();
    }

    public int GetContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements =wd.findElements(By.name("entry"));
        for (WebElement element: elements){
            List <WebElement> cells = element.findElements(By.tagName("td"));

            String lastName = cells.get(1).getText();
            String name=cells.get(2).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact = new ContactData(id,name,lastName,null,null,
                    null,null,null, null,null,null);
            contacts.add(contact);

        }


        return contacts;

    }
    public void goToMainPage(){
        click(By.linkText("home"));
    }
}
