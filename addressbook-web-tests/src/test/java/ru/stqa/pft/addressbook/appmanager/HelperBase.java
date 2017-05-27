package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Алексей on 21.05.2017.
 */
public class HelperBase {
    protected WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd=wd;
    }

    protected void click(By locator) {
        wd.findElement(locator).click();
    }

    protected void type(By Locator, String text) {
        click(Locator);
        if( text!=null) {
            String existingText = wd.findElement(Locator).getAttribute("value");
            if(! text.equals(existingText)){
                wd.findElement(Locator).clear();
                wd.findElement(Locator).sendKeys(text);
            }

        }
    }
}
