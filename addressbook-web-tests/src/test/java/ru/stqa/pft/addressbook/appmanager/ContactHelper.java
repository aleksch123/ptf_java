package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.ContactData;

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

    public void fillUserData(ContactData userData) {
        type(By.name("firstname"),userData.getFirstName());
        type(By.name("lastname"),userData.getLastName());
        type(By.name("middlename"),userData.getMiddleName());
        type(By.name("nickname"),userData.getNickName());
        type(By.name("title"),userData.getTitle());
        type(By.name("company"),userData.getCompany());
        type(By.name("address"),userData.getAddress());
        type(By.name("home"),userData.getPhone());
        type(By.name("email"),userData.getEmail());
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(userData.getGroup());
    }

    public void initContactCreations() {
        click(By.linkText("add new"));
    }
    public void initContactEditions() { click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));}
    public void UpdateContactEdition() {
        click(By.name("update"));
    }
    public void selectContact() {
        click(By.name("selected[]"));}

    public void deleteSelectedContact() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }
}
