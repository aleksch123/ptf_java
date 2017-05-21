package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Алексей on 20.05.2017.
 */
public class NavigationHelper extends HelperBase{


    public NavigationHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void goToGroupPage() {

        click(By.linkText("groups"));
    }
    public void goToHomePage() {

        click(By.linkText("home page"));
    }
    public void CloseAlert() {

        wd.switchTo().alert().accept();
    }
    public void goToMainPage(){
        click(By.linkText("home"));
    }
}
