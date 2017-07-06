package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Алексей on 20.05.2017.
 */
public class NavigationHelper extends HelperBase{


    private WebDriver wd;

    public NavigationHelper(ApplicationManager app) {
        super(app);
        wd =app.getDriver();
    }


    public void goToHomePage() {
        if(isElementPresent(By.id("maintable"))){
            return;
        }

        click(By.linkText("home page"));
    }

    public void manage(){
        click(By.xpath("//li[6]/a/span"));
    }
    public void login(String username, String password){

        type(By.name("username"),username);
        click(By.xpath("//input[@value='Login']"));
        type(By.name("password"),password);
        click(By.xpath("//input[@value='Login']"));
    }

    public void usersTab(){
        click(By.linkText("Manage Users"));

    }

}
