package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Алексей on 20.05.2017.
 */
public class SessionHelper extends HelperBase{


    public SessionHelper(FirefoxDriver wd) {

        super(wd);
    }

    public void Login(String username, String password) {
        type(By.name("pass"),password);
        type(By.name("user"),username);
        click(By.xpath("//form[@id='LoginForm']/input[3]"));
    }
}
