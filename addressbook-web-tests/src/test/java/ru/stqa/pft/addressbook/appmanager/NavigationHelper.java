package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Алексей on 20.05.2017.
 */
public class NavigationHelper extends HelperBase{


    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void groupPage() {
        if(isElementPresent(By.tagName("h1"))
                && wd.findElement(By.tagName("h1")).getText().equals("Groups")
                && isElementPresent(By.name("new"))){
            return;
        }
        click(By.linkText("groups"));


    }
    public void goToHomePage() {
        if(isElementPresent(By.id("maintable"))){
            return;
        }

        click(By.linkText("home page"));
    }
    public void CloseAlert() {

        wd.switchTo().alert().accept();
    }
    public void mainPage(){
        click(By.linkText("home"));
    }
}
