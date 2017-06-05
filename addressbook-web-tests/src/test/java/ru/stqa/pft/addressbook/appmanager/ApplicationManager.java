package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

/**
 * Created by Алексей on 20.05.2017.
 */
public class ApplicationManager  {

    WebDriver wd;
    private SessionHelper sessionHelper;
    private ContactHelper contactHelper;
    private NavigationHelper navigationHalper;
    private  GroupHelper groupHelper;
    private String browser;

    public ApplicationManager(String browser)
    {
        this.browser = browser;
    }

    public static boolean isAlertPresent(WebDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public void init() {


        if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        } else if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.IE)) {
            wd = new InternetExplorerDriver();
            }
            wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            wd.get("http://localhost/addressbook/group.php");
            groupHelper = new GroupHelper(wd);
            navigationHalper = new NavigationHelper(wd);
            sessionHelper = new SessionHelper(wd);
            contactHelper = new ContactHelper(wd);
            sessionHelper.Login("admin", "secret");
        }



    public void stop() {
       wd.quit();
    }

    public GroupHelper group() {
        return groupHelper;
    }

    public NavigationHelper goTo() {
        return navigationHalper;
    }




    public ContactHelper contact() {
        return contactHelper;
    }
}
