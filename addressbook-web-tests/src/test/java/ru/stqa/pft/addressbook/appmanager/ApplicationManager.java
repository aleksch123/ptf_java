package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

/**
 * Created by Алексей on 20.05.2017.
 */
public class ApplicationManager {
    FirefoxDriver wd;

    private  GroupHelper groupHelper;

    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public void init() {
        wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/group.php");
        groupHelper = new GroupHelper(wd);
        Login("admin","secret");
    }

    public void Login(String username, String password) {
       wd.findElement(By.name("pass")).click();
       wd.findElement(By.name("pass")).clear();
       wd.findElement(By.name("pass")).sendKeys(password);
       wd.findElement(By.name("user")).click();
       wd.findElement(By.name("user")).clear();
       wd.findElement(By.name("user")).sendKeys(username);
       wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
    }

    public void goToGroupPage() {
       wd.findElement(By.linkText("groups")).click();
    }

    public void stop() {
       wd.quit();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }
}
