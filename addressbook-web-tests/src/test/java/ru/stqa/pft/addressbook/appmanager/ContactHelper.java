package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.UserData;

/**
 * Created by Алексей on 20.05.2017.
 */
public class ContactHelper extends HelperBase{


    public ContactHelper(FirefoxDriver wd) {

        super(wd);
    }

    public void submitUserCreations() {
        click(By.name("submit"));
    }

    public void fillUserData(UserData userData) {
        type(By.name("firstname"),userData.getFirstName());
        type(By.name("lastname"),userData.getLastName());
        type(By.name("middlename"),userData.getMiddleName());
        type(By.name("nickname"),userData.getNickName());
        type(By.name("title"),userData.getTitle());
        type(By.name("company"),userData.getCompany());
        type(By.name("address"),userData.getAddress());
        type(By.name("home"),userData.getPhone());
        type(By.name("email"),userData.getEmail());

    }

    public void initUserCreations() {
        click(By.linkText("add new"));
    }
}
