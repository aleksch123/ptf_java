package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.io.File;

/**
 * Created by Алексей on 21.05.2017.
 */
public class HelperBase {
    protected WebDriver wd;
    protected ApplicationManager app;


    public HelperBase(ApplicationManager app)
    {
        this.app=app;
        this.wd=app.getDriver();
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
    protected void attach(By Locator, File file) {
          if( file!=null) {
             wd.findElement(Locator).sendKeys(file.getAbsolutePath());


        }
    }

    protected boolean isElementPresent(By locator){
       try {
           wd.findElement(locator);
           return true;
       } catch (NoSuchElementException ex){
           return false;
       }

    }
}
