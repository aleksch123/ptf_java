package ru.qa.st.mail.appmanager;

import org.openqa.selenium.WebDriver;
import ru.qa.st.mail.pageobjects.MailLoginPage;

public class SessionHelper extends HelperBase {


    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void Login(String username, String password) {

        MailLoginPage loginPage = new MailLoginPage(wd);
        loginPage.withLogin(username).withPass(password).logInMailBox();

    }
}
