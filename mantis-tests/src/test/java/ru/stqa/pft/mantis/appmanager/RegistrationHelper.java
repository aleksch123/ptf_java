package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Алексей on 05.07.2017.
 */
public class RegistrationHelper extends HelperBase{

    private WebDriver wd;

    public RegistrationHelper(ApplicationManager app) {
        super(app);
        wd =app.getDriver();
    }

    public void start(String username, String email) {
        wd.get(app.getProperty("web.baseUrl")+"/signup_page.php");
        type(By.name("username"),username);
        type(By.name("email"),email);
        click(By.cssSelector("input[value='Signup']"));

    }

    public void finish(String confiramationLink, String password) {
        wd.get(confiramationLink);
        type(By.name("password"),password);
        type(By.name("password_confirm"),password);
        click(By.xpath("//button[@type='submit']"));
    }
}
