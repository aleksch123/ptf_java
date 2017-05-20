package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

/**
 * Created by Алексей on 20.05.2017.
 */
public class ApplicationManager  {

    FirefoxDriver wd;
    private SessionHelper sessionHelper;
    private AddrHelper addrHelper;
    private NavigationHelper navigationHalper;
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
        navigationHalper=new NavigationHelper(wd);
        sessionHelper=new SessionHelper(wd);
        addrHelper=new AddrHelper(wd);
        sessionHelper.Login("admin","secret");
    }



    public void stop() {
       wd.quit();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHalper() {
        return navigationHalper;
    }

    public void goToHomePage() {
        wd.findElement(By.linkText("home page")).click();
    }

    public AddrHelper getAddrHelper() {
        return addrHelper;
    }
}
